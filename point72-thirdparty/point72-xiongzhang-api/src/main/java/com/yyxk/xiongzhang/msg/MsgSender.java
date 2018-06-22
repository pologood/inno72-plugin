package com.point72.xiongzhang.msg;

import com.alibaba.fastjson.JSONObject;
import com.point72.xiongzhang.ApiUrl.Message;
import com.point72.xiongzhang.Invoke;
import com.point72.xiongzhang.model.msg.AbstractMessageModel;
import com.point72.xiongzhang.model.msg.TemplateMsgModel;

/**
 * 百度熊掌号消息发送类
 * 
 * @author Houkm
 *
 *         2018年4月2日
 */
public class MsgSender {

	/**
	 * 发送客服消息
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2018年4月2日
	 */
	public static String sendCustom(String token, AbstractMessageModel model) {
		return Invoke.post(Message.Custom_Service.url(), model.json(), token);
	}

	/**
	 * 发送模板消息
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2018年4月2日
	 */
	public static String sendTemplate(String token, TemplateMsgModel model) {
		return Invoke.post(Message.Template.url(), JSONObject.toJSONString(model), token);
	}

}
