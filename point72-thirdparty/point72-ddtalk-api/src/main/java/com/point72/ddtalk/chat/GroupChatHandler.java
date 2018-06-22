package com.point72.ddtalk.chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.point72.ddtalk.Invoke;
import com.point72.ddtalk.chat.model.AbstractModel;
import com.point72.ddtalk.chat.model.CreateGroupModel;
import com.point72.ddtalk.chat.model.UpdateGroupModel;

/**
 * 群回话接口
 * 
 * @author Houkm
 *
 *         2017年6月12日
 */
public class GroupChatHandler {

	private static Logger logger = LoggerFactory.getLogger(GroupChatHandler.class);

	/**
	 * 创建回话
	 * 
	 * @param token
	 * @param group
	 * @return
	 * @author Houkm 2017年6月12日
	 */
	public static String create(String token, CreateGroupModel group) {
		String result = Invoke.post("https://oapi.dingtalk.com/chat/create?access_token={0}", JSON.toJSONString(group),
				token);
		return result;
	}

	/**
	 * 修改回话
	 * 
	 * @param token
	 * @param group
	 * @return
	 * @author Houkm 2017年6月12日
	 */
	public static String update(String token, UpdateGroupModel group) {
		String result = Invoke.post("https://oapi.dingtalk.com/chat/update?access_token={0}", JSON.toJSONString(group),
				token);
		return result;
	}

	/**
	 * 获取回话信息
	 * 
	 * @param token
	 * @param chatId
	 * @return
	 * @author Houkm 2017年6月12日
	 */
	public static String get(String token, String chatId) {
		String result = Invoke.get("https://oapi.dingtalk.com/chat/get?access_token={0}&chatid={1}", token, chatId);
		return result;
	}

	/**
	 * 发送消息到群
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2017年6月12日
	 */
	public static String send(String token, AbstractModel model) {
		logger.info("发送钉钉消息： model【{}】", model.toJson());
		String result = Invoke.post("https://oapi.dingtalk.com/chat/send?access_token={0}", model.toJson(), token);
		return result;
	}

	/**
	 * 通过机器人发送消息
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2017年6月22日
	 */
	public static String sendRabotMsg(String token, AbstractModel model) {
		logger.info("发送钉钉机器人消息：token【{}】, model【{}】", token, model.toJson());
		String result = Invoke.post("https://oapi.dingtalk.com/robot/send?access_token={0}", model.toJson(), token);
		return result;
	}

}
