package com.inno72.ddtalk.chat;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.inno72.ddtalk.Invoke;
import com.inno72.ddtalk.RestResultHandler;
import com.inno72.ddtalk.chat.model.LinkMsgModel;
import com.inno72.ddtalk.model.CorpChatRequestModel;
import com.inno72.ddtalk.model.GetSendProgressRequestModel;

/**
 * 企业会话消息接口
 * 
 * @author Houkm
 *
 *         2017年6月28日
 */
public class CorpChatHandler {

	public static String asyncsend(CorpChatRequestModel model) {
		return Invoke.rest(model);
	}

	/**
	 * 获取异步发送消息解析json的root节点名字
	 * 
	 * @return
	 * @author Houkm 2017年6月30日
	 */
	public static String getAsyncsendMethod() {
		return "dingtalk_corp_message_corpconversation_asyncsend_response";
	}

	/**
	 * 获取查看消息结果解析json的root节点名字
	 * 
	 * @return
	 * @author Houkm 2017年6月30日
	 */
	public static String getSendResultMethod() {
		return "dingtalk_corp_message_corpconversation_getsendresult_response";
	}

	/**
	 * 通过指定微应用发送文本消息给指定用户
	 * 
	 * @param agentId
	 *            微应用ID
	 * @param token
	 * @param userIds
	 *            接收消息的用户
	 * @param msg
	 *            消息内容
	 * @return
	 * @author Houkm 2017年6月30日
	 */
	public static String asyncsendText(String agentId, String token, List<String> userIds, String msg) {
		CorpChatRequestModel model = new CorpChatRequestModel(token);
		model.setAgent_id(agentId);
		model.addUser(userIds);
		model.setMsgtype("text");
		model.setMsgcontent("{\"content\":\"" + msg + "\"}");
		return Invoke.rest(model);
	}

	/**
	 * 通过指定微应用发送LINK消息给指定用户
	 * 
	 * @param agentId
	 *            发送消息的微应用ID
	 * @param token
	 * @param userIds
	 *            接收消息的用户
	 * @param linkModel
	 *            链接消息对象
	 * @return
	 * @author Houkm 2017年6月30日
	 */
	public static String asyncsendLink(String agentId, String token, List<String> userIds, LinkMsgModel linkModel) {
		CorpChatRequestModel model = new CorpChatRequestModel(token);
		model.setAgent_id(agentId);
		model.addUser(userIds);
		model.setMsgtype("link");
		model.setMsgcontent(JSON.toJSONString(linkModel.getLink()));
		return Invoke.rest(model);
	}

	public static String getSendResult(String agentId, String taskId, String token) {
		GetSendProgressRequestModel model = new GetSendProgressRequestModel(token, taskId, agentId);
		return Invoke.rest(model);
	}

	public static String getReadableSendResult(String agentId, String taskId, String token) {
		String result = getSendResult(agentId, taskId, token);

		RestResultHandler handler = new RestResultHandler(result, getSendResultMethod());

		return prettyResult(handler);
	}

	public static String getReadableSendResult(String result) {

		RestResultHandler handler = new RestResultHandler(result, getSendResultMethod());

		return prettyResult(handler);

	}

	private static String prettyResult(RestResultHandler handler) {
		StringBuilder sb = new StringBuilder();
		sb.append("状态：").append(handler.isSuccess() ? "成功" : "失败").append("\n");
		JSONObject sr = handler.getJSONObject("send_result");
		JSONObject invalid_user_id_lis = sr.getJSONObject("invalid_user_id_lis");
		if (invalid_user_id_lis != null && !invalid_user_id_lis.isEmpty()) {
			sb.append("无效的用户id:").append(invalid_user_id_lis.get("string")).append("\n");
		}

		JSONObject forbidden_user_id_list = sr.getJSONObject("forbidden_user_id_list");

		if (forbidden_user_id_list != null && !forbidden_user_id_list.isEmpty()) {
			sb.append("被禁止发送消息的用户id:").append(forbidden_user_id_list.get("string").toString()).append("\n");
		}

		JSONObject failed_user_id_list = sr.getJSONObject("failed_user_id_list");
		if (failed_user_id_list != null && !failed_user_id_list.isEmpty()) {
			sb.append("发送失败的用户id:").append(failed_user_id_list.get("string")).append("\n");
		}

		JSONObject invalid_dept_id_list = sr.getJSONObject("invalid_dept_id_list");
		if (invalid_dept_id_list != null && !invalid_dept_id_list.isEmpty()) {
			sb.append("无效的部门id:").append(invalid_dept_id_list).append("\n");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String result = "{\"dingtalk_corp_message_corpconversation_getsendresult_response\":{\"result\":{\"ding_open_errcode\":0,\"send_result\":{\"failed_user_id_list\":{},\"invalid_dept_id_list\":{},\"invalid_user_id_list\":{},\"read_user_id_list\":{},\"unread_user_id_list\":{\"string\":[\"houkemian\"]}},\"success\":true},\"request_id\":\"eor05a8g352a\"}}";
		RestResultHandler handler = new RestResultHandler(result, getSendResultMethod());
		prettyResult(handler);
	}

}
