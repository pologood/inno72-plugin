package com.inno72.xiongzhang.boot;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.inno72.xiongzhang.msg.CallbackAdapter;
import com.inno72.xiongzhang.msg.EventAdapter;
import com.inno72.xiongzhang.msg.enums.EventType;
import com.inno72.xiongzhang.tools.BytesHandler;

public abstract class XiongZhangServerBoot {

	private Logger logger = LoggerFactory.getLogger(XiongZhangServerBoot.class);

	@Resource(type = EventAdapterHandler.class)
	private EventAdapterHandler eventAdapterHandler;

	@Resource(type = CallbackAdapterHandler.class)
	private CallbackAdapterHandler callbackAdapterHandler;

	private JSONObject jsonObj;

	/**
	 * 服务器配置地址
	 * 
	 * @param req
	 * @param response
	 * @author Houkm 2018年4月3日
	 */
	@RequestMapping(value = "/main", method = { RequestMethod.GET, RequestMethod.POST })
	public void boot(HttpServletRequest req, HttpServletResponse response) {

		// 获取正文消息，如安全模式，则解密
		String body = (body(req));
		if (body != null) {
			logger.info("请求正文: {}", body);
			this.jsonObj = JSONObject.parseObject(body);
			String result = null;
			if (eventAdapterHandler.size() > 0) {
				// 处理EventHandler中注册的事件
				result = processEvent();
			}

			if (result == null) {
				if (callbackAdapterHandler.size() > 0) {
					// 处理CallbackHandler中注册的回调事件
					result = processCallback();
				}
			}

			// 未注册事件处理器
			if (result == null) {
				result = process(jsonObj);
			}
			// // 返回消息，如安全模式，则加密
			write(response, result);
		} else {
			logger.info("熊掌验证服务器");
			String echostr = req.getParameter("echostr");
			if (check(req)) {
				logger.info("熊掌验证服务器：通过");
				write(response, echostr);
			} else {
				logger.info("熊掌验证服务器：不通过");
			}
		}
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
		return body;
		// logger.info("安全模式，等待解密: {}", body);
		// TODO 安全模式
	}

	/**
	 * 服务器配置校验
	 * 
	 * @param req
	 * @return
	 * @author Houkm 2018年4月3日
	 */
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
			// if (safeMode()) {
			// logger.info("安全模式，待加密");
			// data = msgCrypt.encryptMsg(data == null ? "" : data,
			// String.valueOf(System.currentTimeMillis()),
			// UUID.randomUUID().toString());
			// logger.info("加密后数据: {}", data);
			// }
			response.setCharacterEncoding("UTF8");
			response.getWriter().write(data);
		} catch (IOException e) {
			logger.error("error", e);
		}
	}

	private String processEvent() {
		if (eventAdapterHandler != null) {
			String msgType = jsonObj.getString("MsgType");
			if (msgType != null && "event".equals(msgType)) {
				String eventStr = jsonObj.getString("Event");
				EventType event = EventType.valueOf(eventStr);
				if (this.eventAdapterHandler.exist(event)) {
					EventAdapter processer = this.eventAdapterHandler.get(event);
					logger.info("{}处理{}类型事件", processer.getClass().getName(), event);
					return processer.process(jsonObj);
				}
			}
		}
		return null;

	}

	private String processCallback() {
		if (callbackAdapterHandler != null) {
			String msgType = jsonObj.getString("MsgType");
			if (msgType != null && "mch".equals(msgType)) {
				String eventStr = jsonObj.getString("Event");
				CallbackAdapter.Type type = CallbackAdapter.Type.valueOf(eventStr);
				if (this.callbackAdapterHandler.exist(type)) {
					CallbackAdapter adapter = this.callbackAdapterHandler.get(type);
					logger.info("{}处理{}类型事件", adapter.getClass().getName(), type);
					return adapter.process(jsonObj);
				}
			}
		}
		return null;
	}

	/**
	 * 消息是否密文模式
	 * 
	 * @return
	 * @author Houkm 2018年4月3日
	 */
	public abstract boolean safeMode();

	/**
	 * 熊掌号账号信息
	 * 
	 * @return
	 * @author Houkm 2018年4月3日
	 */
	public abstract AccountInfo accountInfo();

	/**
	 * 普通消息处理(非事件消息)
	 * 
	 * @param data
	 * @return
	 * @author Houkm 2018年4月3日
	 */
	public abstract String process(JSONObject jsonObj);

}
