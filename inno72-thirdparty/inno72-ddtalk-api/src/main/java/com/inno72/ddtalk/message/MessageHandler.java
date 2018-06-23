package com.inno72.ddtalk.message;

import com.inno72.ddtalk.ApiUrl.Message;
import com.inno72.ddtalk.Invoke;
import com.inno72.ddtalk.model.GetSendProgressRequestModel;
import com.inno72.ddtalk.model.GetSendResultRequestModel;
import com.inno72.ddtalk.model.SendAgentByCodeRequestModel;
import com.inno72.ddtalk.model.SendAgentRequestModel;

/**
 * 发送消息接口
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class MessageHandler {

	/**
	 * 发送群消息
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2017年9月8日
	 */
	public static String sendChat(String token, AbstractMessageModel model) {
		return Invoke.post(Message.Send_Chat.url(), model.jsonString(), token);
	}

	/**
	 * 发送普通消息
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2017年9月8日
	 */
	public static String sendChat(String token, AbstractMessageModel model, String sender, String receiver) {
		model.setSender(sender);
		model.setCid(receiver);
		return Invoke.post(Message.Send_User.url(), model.jsonString(), token);
	}

	/**
	 * 企业会话消息异步发送 通过微应用发送
	 * 
	 * @param model
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String sendAgent(SendAgentRequestModel model) {
		return Invoke.rest(model);
	}

	/**
	 * 通过用户授权码异步向企业会话发送消息 通过微应用发送
	 * 
	 * @param model
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String sendAgentByCode(SendAgentByCodeRequestModel model) {
		return Invoke.rest(model);
	}

	/**
	 * 获取异步发送企业会话消息的发送进度
	 * 
	 * @param model
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String getSendProgress(GetSendProgressRequestModel model) {
		return Invoke.rest(model);
	}

	/**
	 * 获取异步向企业会话发送消息的结果
	 * 
	 * @param model
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String getSendResult(GetSendResultRequestModel model) {
		return Invoke.rest(model);
	}

}
