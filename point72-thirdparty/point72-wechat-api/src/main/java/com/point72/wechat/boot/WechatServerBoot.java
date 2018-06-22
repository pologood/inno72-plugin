package com.point72.wechat.boot;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
import com.point72.wechat.event.CallbackEvent;
import com.point72.wechat.event.Event;
import com.point72.wechat.event.EventProcesser;
import com.point72.wechat.pay.AbstractPayModel;
import com.point72.wechat.pay.callback.model.PayResultCallbackModel;
import com.point72.wechat.pay.callback.model.RefundResultCallbackModel;
import com.point72.wechat.pay.callback.model.ScanPayCallbackModel;
import com.point72.wechat.tools.BytesHandler;
import com.point72.wechat.tools.SignHelper;

public abstract class WechatServerBoot {

	private Logger logger = LoggerFactory.getLogger(WechatServerBoot.class);

	private static WXBizMsgCrypt msgCrypt;

	@Resource(type = EventHandler.class)
	private EventHandler eventHandler;

	@Resource(type = CallbackHandler.class)
	private CallbackHandler callbackHandler;

	/**
	 * 微信对接接口
	 * 
	 * @param req
	 * @param response
	 * @author Houkm 2017年9月6日
	 */
	@RequestMapping(value = "/main", method = { RequestMethod.GET, RequestMethod.POST })
	public void boot(HttpServletRequest req, HttpServletResponse response) {

		// 获取正文消息，如安全模式，则解密
		String body = (body(req));
		if (body != null) {
			logger.info("请求正文: {}", body);
			String result = null;
			if (eventHandler.size() > 0) {
				// 处理EventHandler中注册的事件
				result = processEvent(body);
			}

			// 未注册事件处理器
			if (result == null) {
				result = process(body);
			}
			// 返回消息，如安全模式，则加密
			write(response, result);
		} else {
			logger.info("微信验证服务器");
			String echostr = req.getParameter("echostr");
			if (check(req)) {
				logger.info("微信验证服务器：通过");
				write(response, echostr);
			} else {
				logger.info("微信验证服务器：不通过");
			}
		}
	}

	/**
	 * 统一回调接口
	 * 
	 * @param req
	 * @param response
	 * @return
	 * @author Houkm 2017年9月6日
	 */
	@RequestMapping(value = "/callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(HttpServletRequest req, HttpServletResponse response) {
		// 获取正文消息，如安全模式，则解密
		String body = (body(req));
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(body);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

		// 判断回调事件类型
		CallbackEvent event = judgeCallbackEvent(doc);
		String result = "";

		// 是否有此类型的适配器
		if (callbackHandler.exist(event)) {
			AbstractPayModel model = null;
			// 数据转化为相应的对象
			if (event.equals(CallbackEvent.Refund_Result)) {// 退款通知
				model = new RefundResultCallbackModel(doc, this.accountInfo().getPayCode());
			} else if (event.equals(CallbackEvent.Scan_Pay)) {// 扫码支付
				model = new ScanPayCallbackModel(doc, this.accountInfo().getPayCode());
			} else {// 支付结果通知
				model = new PayResultCallbackModel(doc, this.accountInfo().getPayCode());
			}
			logger.info("{} 回调事件将由适配器{}处理", event, callbackHandler.get(event).getClass().getName());
			// 适配器处理数据
			result = callbackHandler.get(event).process(model);
			logger.info("回调事件处理结果: {}", result);
		} else {
			logger.warn("回调事件 {} 没有响应适配器，将有业务方消息处理方法[process()]处理", event);
			result = this.process(body);
			logger.info("[process()]方法处理回调事件结果: {}", result);
		}
		return result;
	}

	/**
	 * 微信js签名
	 * 
	 * @param url
	 * @return
	 * @author Houkm 2017年9月6日
	 */
	@RequestMapping(value = "/jsconfig", method = { RequestMethod.GET, RequestMethod.POST })
	public Map<String, Object> jsConfig(String url) {
		logger.info("对{}签名", url);
		String nonceStr = UUID.randomUUID().toString().replaceAll("-", "");
		String timestamp = String.valueOf(System.currentTimeMillis());
		String ticket = jsticket();
		String signature = SignHelper.signUrl(ticket, nonceStr, timestamp, url);
		Map<String, Object> result = new HashMap<>();
		result.put("ticket", ticket);
		result.put("noncestr", nonceStr);
		result.put("timestamp", timestamp);
		result.put("signature", signature);
		result.put("appid", accountInfo().getAppId());
		logger.info("对{}签名结果: {}", url, result);
		return result;
	}

	private String body(HttpServletRequest req) {
		String body = null;
		try {
			int len = req.getContentLength();
			if (len <= 0) {
				return null;
			}
			ServletInputStream ins = req.getInputStream();
			byte[] bodyBytes = new byte[len];
			ins.read(bodyBytes, 0, len);
			body = new String(bodyBytes);
		} catch (IOException e1) {
			logger.error("error", e1);
		}
		if (!isSafeMode()) {
			return body;
		}
		logger.info("安全模式，等待解密: {}", body);
		if (msgCrypt == null) {
			try {
				msgCrypt = new WXBizMsgCrypt(accountInfo().getToken(), accountInfo().getEncodingAESKey(),
						accountInfo().getAppId());
			} catch (AesException e) {
				logger.error("error", e);
			}
		}
		try {
			Document doc = DocumentHelper.parseText(body);
			Element root = doc.getRootElement();
			String msgSignature = root.elementText("MsgSignature");
			String timeStamp = root.elementText("TimeStamp");
			String nonce = root.elementText("Nonce");
			String data = root.elementText("Encrypt");
			body = msgCrypt.decryptMsg(msgSignature, timeStamp, nonce, data);
		} catch (DocumentException | AesException e) {
			logger.error("error", e);
		}
		return body;
	}

	private boolean check(HttpServletRequest req) {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");

		String[] ary = { accountInfo().getToken(), timestamp, nonce };
		Arrays.sort(ary);
		StringBuilder sb = new StringBuilder();
		for (String str : ary) {
			sb.append(str);
		}

		String str = sb.toString();
		String sign = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("sha1");
			digest.reset();
			digest.update(str.getBytes("UTF-8"));
			byte[] bs = digest.digest();
			sign = BytesHandler.byteArrayToHex(bs);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			logger.error("error", e);
		}
		return sign != null && sign.equals(signature);
	}

	private void write(HttpServletResponse response, String data) {
		try {
			logger.info("响应消息：{}", data);
			if (isSafeMode()) {
				logger.info("安全模式，待加密");
				data = msgCrypt.encryptMsg(data == null ? "" : data, String.valueOf(System.currentTimeMillis()),
						UUID.randomUUID().toString());
				logger.info("加密后数据: {}", data);
			}
			response.setCharacterEncoding("UTF8");
			response.getWriter().write(data);
		} catch (IOException | AesException e) {
			logger.error("error", e);
		}
	}

	private String processEvent(String data) {
		if (eventHandler != null) {
			try {
				Document doc = DocumentHelper.parseText(data);
				Element root = doc.getRootElement();
				String msgType = root.elementText("MsgType");
				if (msgType != null && "event".equals(msgType)) {
					String eventStr = root.elementText("Event");
					Event event = Event.valueOf(eventStr);
					if (this.eventHandler.exist(event)) {
						EventProcesser processer = this.eventHandler.get(event);
						logger.info("{}处理{}类型事件", processer.getClass().getName(), event);
						return processer.process(doc);
					}
				}
			} catch (DocumentException e) {
				logger.error("error", e);
			}
		}
		return null;
	}

	private CallbackEvent judgeCallbackEvent(Document doc) {
		Element reqInfo = doc.getRootElement().element("req_info");
		Element productId = doc.getRootElement().element("product_id");
		if (reqInfo != null) {
			logger.info("解析回调事件类型：退款通知");
			return CallbackEvent.Refund_Result;
		} else if (productId != null) {
			logger.info("解析回调事件类型：扫码支付");
			return CallbackEvent.Scan_Pay;
		} else {
			logger.info("解析回调事件类型：支付结果通知");
			return CallbackEvent.Pay_Result;
		}
	}

	/**
	 * 消息处理
	 * 
	 * @param data
	 * @return
	 * @author Houkm 2017年9月5日
	 */
	public abstract String process(String data);

	/**
	 * 是否安全模式<br>
	 * 设置为true时，将自动加解密
	 * 
	 * @return
	 * @author Houkm 2017年9月5日
	 */
	public abstract boolean isSafeMode();

	/**
	 * 微信配置
	 * 
	 * @return
	 * @author Houkm 2017年9月5日
	 */
	public abstract WechatInfo accountInfo();

	/**
	 * 获取微信jsticket
	 * 
	 * @return
	 * @author Houkm 2017年9月13日
	 */
	public abstract String jsticket();

}
