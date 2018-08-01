package com.inno72.msg;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.inno72.config.client.ExceptionProperties;
import com.inno72.core.dto.MsgDTO;
import com.inno72.exception.ExceptionBuilder;
import com.inno72.mq.producer.Producer;
import com.inno72.redis.StringUtil;

/**
 * 发送消息类
 * 
 * @author Houkm 2017年6月29日
 *
 */
@Component
public class MsgUtil {

	@Autowired
	private Producer producer;

	@Resource
	private StringUtil redisStringUtil;

	@Autowired
	private ExceptionProperties exProp;

	private Logger logger = LoggerFactory.getLogger(MsgUtil.class);

	/**
	 * 发送短信
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            消息模板内容中的参数值，如模板为<br>
	 *            “您的验证码是{{code}}”，<br>
	 *            则params需添加key为code，value为验证码entry
	 * @param receiver
	 *            手机号
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendSMS(String code, Map<String, String> params, String receiver, String appName) {
		params = params == null ? new HashMap<>() : params;
		send(generateMsg(code, params, null, receiver, appName, null));
	}

	/**
	 * 发送个推消息
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            消息模板内容中的参数值，如模板内容为<br>
	 *            “{"code": {{code}}”，<br>
	 *            则params需添加key为code，value为状态码的entry
	 * @param alias
	 *            手机别名(不知道别名是什么的时候，问一下卢昕什么是个推的别名)
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @param title
	 *            通知文案标题
	 * @param content
	 *            通知文案内容
	 * @author Houkm 2017年6月29日
	 */
	public void sendPush(String code, Map<String, String> params, String alias, String appName, String title,
			String content) {
		params = params == null ? new HashMap<>() : params;
		params.put("title", title);
		params.put("text", content);
		send(generateMsg(code, params, null, alias, appName, null));
	}

	/**
	 * 发送文本消息给用户
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            文本内容中的参数值，如模板为<br>
	 *            “预约成功，订单号{{orderNum}}”<br>
	 *            ，则params需添加key为orderNum，value为"00110011993"的entry
	 * @param openid
	 *            用户openid
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendWechatText(String code, Map<String, String> params, String openid, String appName) {
		params = params == null ? new HashMap<>() : params;
		send(generateMsg(code, params, null, openid, appName, null));
	}

	/**
	 * 微信模板消息 <br>
	 * 以下例说明<br>
	 * { <br>
	 * "touser": null, <br>
	 * "template_id": "ddddddddddd", <br>
	 * "url": "http://www.pinwheelmedical.com", <br>
	 * "data": { <br>
	 * "first": { <br>
	 * "value": "#first#", <br>
	 * "color": "#173177" <br>
	 * }, <br>
	 * "remark": { <br>
	 * "value": "#remark#", <br>
	 * "color": "#173177" <br>
	 * }, <br>
	 * "data": { <br>
	 * "data1": { <br>
	 * "value": "#data1#", <br>
	 * "color": "#173177" <br>
	 * }, <br>
	 * "data2": { <br>
	 * "value": "#data2#", <br>
	 * "color": "#173177" <br>
	 * }, <br>
	 * "data3": { <br>
	 * "value": "#data3#", <br>
	 * "color": "#173177" <br>
	 * } } } }
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            需传入data节点中除first与remark的子节点的key和value，在上例中需要传入的key为data1，data2，data3
	 * @param firstContent
	 *            data节点中first的内容
	 * @param remarkContent
	 *            data节点中remark的内容
	 * @param openid
	 *            用户openid
	 * @param url
	 *            点击模板跳转的完整url，如不传此参数则使用消息模板中配置的url，若消息模板中没有配置url则为不跳转的模板消息
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendWechatTemplate(String code, Map<String, String> params, String firstContent, String remarkContent,
			String openid, String url, String appName) {
		params = params == null ? new HashMap<>() : params;
		params.put("first", firstContent);
		params.put("remark", remarkContent);
		params.put("url", url);
		send(generateMsg(code, params, null, openid, appName, null));
	}

	/**
	 * 发送消息给 企业微信
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            文本内容中的参数值，
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author zhangwenjie 2018年7月31日
	 */
	public void sendQyWechatMsg(String code, Map<String, String> params, Map<String, String> addedParams, String touser,
			String appName) {
		params = params == null ? new HashMap<>() : params;
		send(generateMsg(code, params, addedParams, touser, appName, null));
	}

	/**
	 * 发送熊掌号文本消息给用户
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            文本内容中的参数值，如模板为<br>
	 *            “预约成功，订单号{{orderNum}}”<br>
	 *            ，则params需添加key为orderNum，value为"00110011993"的entry
	 * @param openid
	 *            用户openid
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendXiongZhangText(String code, Map<String, String> params, String openid, String appName) {
		params = params == null ? new HashMap<>() : params;
		send(generateMsg(code, params, null, openid, appName, null));
	}

	/**
	 * 熊掌模板消息 <br>
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            需传入data节点中除first与remark的子节点的key和value，在上例中需要传入的key为data1，data2，data3
	 * @param firstContent
	 *            data节点中first的内容
	 * @param remarkContent
	 *            data节点中remark的内容
	 * @param openid
	 *            用户openid
	 * @param url
	 *            点击模板跳转的完整url，如不传此参数则使用消息模板中配置的url，若消息模板中没有配置url则为不跳转的模板消息
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendXiongZhangTemplate(String code, Map<String, String> params, String firstContent,
			String remarkContent, String openid, String url, String appName) {
		params = params == null ? new HashMap<>() : params;
		params.put("first", firstContent);
		params.put("remark", remarkContent);
		params.put("url", url);
		send(generateMsg(code, params, null, openid, appName, null));
	}

	/**
	 * 通过群发送钉钉文本消息
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            消息模板内容中的参数值，如模板为<br>
	 *            “{{function}}报错了”，<br>
	 *            则params需添加key为function，value为功能点的entry
	 * @param groupId
	 *            群Id
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendDDTextByGroup(String code, Map<String, String> params, String groupId, String appName) {
		params = params == null ? new HashMap<>() : params;
		send(generateMsg(code, params, null, groupId, appName, null));
	}

	/**
	 * 通过群发送钉钉文本消息,使用消息模板内的接收人
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            消息模板内容中的参数值，如模板为<br>
	 *            “{{function}}报错了”，<br>
	 *            则params需添加key为function，value为功能点的entry
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendDDTextByGroup(String code, Map<String, String> params, String appName) {
		params = params == null ? new HashMap<>() : params;
		send(generateMsg(code, params, null, null, appName, null));
	}

	/**
	 * 通过机器人发送钉钉文本消息
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            消息模板内容中的参数值，如模板为<br>
	 *            “{{function}}报错了”<br>
	 *            ，则params需添加key为function，value为功能点的entry
	 * @param robotToken
	 *            发送消息的机器人的token
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendDDTextByRobot(String code, Map<String, String> params, String robotToken, String appName) {
		params = params == null ? new HashMap<>() : params;
		send(generateMsg(code, params, null, robotToken, appName, null));
	}

	/**
	 * 通过机器人发送钉钉文本消息
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            消息模板内容中的参数值，如模板为<br>
	 *            “{{function}}报错了”，<br>
	 *            则params需添加key为function，value为功能点的entry
	 * @param miniAppId
	 *            发送消息的微应用ID, 如不填则使用消息模板中的值
	 * @param userIds
	 *            接收此消息的用户的钉钉ID，为用户表的userid字段，不是id
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendDDTextByMiniApp(String code, Map<String, String> params, String miniAppId, List<String> userIds,
			String appName) {
		if (userIds == null || userIds.size() < 1) {
			throw ExceptionBuilder.build(exProp).format("msg_has_no_receiver", code).create();
		}
		params = params == null ? new HashMap<>() : params;
		StringBuilder sb = new StringBuilder();
		userIds.forEach(userid -> {
			sb.append(",").append(userid);
		});
		params.put("userIds", sb.toString().substring(1));
		send(generateMsg(code, params, null, miniAppId, appName, null));
	}

	/**
	 * 通过群发送钉钉链接消息
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            消息模板内容（Link消息显示的内容）中的参数值，如模板为<br>
	 *            “{{function}}报错了”<br>
	 *            ，则params需添加key为function，value为功能点的entry
	 * @param groupId
	 *            接收消息的钉钉群Id
	 * @param title
	 *            消息的标题
	 * @param messageUrl
	 *            点击消息跳转的url
	 * @param picUrl
	 *            消息显示图片的url
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendDDLinkByGroup(String code, Map<String, String> params, String groupId, String title,
			String messageUrl, String picUrl, String appName) {
		params = params == null ? new HashMap<>() : params;
		params.put("messageUrl", messageUrl);
		params.put("picUrl", picUrl);
		send(generateMsg(code, params, null, groupId, appName, title));
	}

	/**
	 * 通过群发送钉钉链接消息,使用消息模板内的默认接收人
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            消息模板内容（Link消息显示的内容）中的参数值，如模板为<br>
	 *            “{{function}}报错了”<br>
	 *            ，则params需添加key为function，value为功能点的entry
	 * @param title
	 *            消息的标题
	 * @param messageUrl
	 *            点击消息跳转的url
	 * @param picUrl
	 *            消息显示图片的url
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendDDLinkByGroup(String code, Map<String, String> params, String title, String messageUrl,
			String picUrl, String appName) {
		params = params == null ? new HashMap<>() : params;
		params.put("messageUrl", messageUrl);
		params.put("picUrl", picUrl);
		send(generateMsg(code, params, null, null, appName, title));
	}

	/**
	 * 通过机器人发送钉钉链接消息
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            消息模板内容（Link消息显示的内容）中的参数值，如模板为<br>
	 *            “{{function}}报错了”，<br>
	 *            则params需添加key为function，value为功能点的entry
	 * @param robotToken
	 *            发送消息的机器人的token
	 * @param title
	 *            消息的标题
	 * @param messageUrl
	 *            点击消息跳转的url
	 * @param picUrl
	 *            消息显示图片的url
	 * @param appName
	 *            调用方格式：（应用.实例.类.方法）
	 * @author Houkm 2017年6月29日
	 */
	public void sendDDLinkByRobot(String code, Map<String, String> params, String robotToken, String title,
			String messageUrl, String picUrl, String appName) {
		params = params == null ? new HashMap<>() : params;
		params.put("messageUrl", messageUrl);
		params.put("picUrl", picUrl);
		send(generateMsg(code, params, null, robotToken, appName, title));
	}

	/**
	 * 通过微应用发送钉钉链接消息
	 * 
	 * @param code
	 *            消息模板key
	 * @param params
	 *            消息模板内容（Link消息显示的内容）中的参数值，如模板为<br>
	 *            “{{function}}报错了”，<br>
	 *            则params需添加key为function，value为功能点的entry
	 * @param miniAppId
	 *            发送消息的微应用ID, 如不填则使用消息模板中的值
	 * @param userIds
	 *            接收此消息的用户的钉钉ID，为用户表的userid字段，不是id
	 * @param title
	 *            消息的标题
	 * @param messageUrl
	 *            点击消息跳转的url
	 * @param picUrl
	 *            消息显示图片的url
	 * @param appName
	 *            调用方，格式为：应用.实例.类.方法
	 * @author Houkm 2017年6月29日
	 */
	public void sendDDLinkByMiniApp(String code, Map<String, String> params, String miniAppId, List<String> userIds,
			String title, String messageUrl, String picUrl, String appName) {
		if (userIds == null || userIds.size() < 1) {
			throw ExceptionBuilder.build(exProp).format("msg_has_no_receiver", code).create();
		}
		params = params == null ? new HashMap<>() : params;
		if (miniAppId != null && !"".equals(miniAppId)) {
			params.put("agentId", miniAppId);
		}
		params.put("messageUrl", messageUrl);
		params.put("picUrl", picUrl);
		StringBuilder sb = new StringBuilder();
		userIds.forEach(userid -> {
			sb.append(",").append(userid);
		});
		params.put("userIds", sb.toString().substring(1));
		send(generateMsg(code, params, null, miniAppId, appName, title));
	}

	private void send(MsgDTO msgDto) {
		logger.info("发送消息记录key【{}】", msgDto.getMsgTimestamp());
		redisStringUtil.set(msgDto.getMsgTimestamp(), JSON.toJSONString(msgDto));
		producer.msg(msgDto);
	}

	private MsgDTO generateMsg(String code, Map<String, String> params, Map<String, String> addedParams,
			String receiver, String appName, String title) {
		if (appName == null || appName.trim().equals("")) {
			throw ExceptionBuilder.build(exProp).format("msg_has_no_sender").create();
		}
		
		MsgDTO msgDto = new MsgDTO();
		msgDto.setCode(code);
		msgDto.setParams(params);
		msgDto.setAddedParams(addedParams);
		msgDto.setReceiver(receiver);
		msgDto.setSentBy(appName);
		msgDto.setTitle(title);
		return msgDto;
	}

}
