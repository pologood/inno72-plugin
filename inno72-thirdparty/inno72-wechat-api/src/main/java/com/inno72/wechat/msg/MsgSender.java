package com.inno72.wechat.msg;

import com.inno72.wechat.ApiUrl.Message;
import com.inno72.wechat.common.Invoke;
import com.inno72.wechat.msg.model.AbstractCustomMsgModel;
import com.inno72.wechat.msg.model.AbstractTemplateModel;

public class MsgSender {

	/**
	 * 发送模板消息
	 * 
	 * @param token
	 * @param model
	 * @return
	 */
	public static String sendTpl(String token, AbstractTemplateModel model) {
		return Invoke.post(Message.Template.url(), model.toJson(), token);
	}

	/**
	 * 发送客服消息
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2017年6月16日
	 */
	public static String sendCustom(String token, AbstractCustomMsgModel model) {
		return Invoke.post(Message.Custom_Service.url(), model.toJson(), token);
	}
}
