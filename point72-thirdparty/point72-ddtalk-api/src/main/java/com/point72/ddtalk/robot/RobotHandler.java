package com.point72.ddtalk.robot;

import com.point72.ddtalk.ApiUrl.Message;
import com.point72.ddtalk.Invoke;
import com.point72.ddtalk.message.LinkMessageModel;

/**
 * 机器人接口
 * 
 * @author Houkm
 *
 *         2017年9月11日
 */
public class RobotHandler {

	/**
	 * 通过机器人发送文本消息
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String sendText(String token, TextMessageModel model) {
		return Invoke.post(Message.Send_User_By_Robot.url(), model.jsonString(), token);
	}

	/**
	 * 通过机器人发送Link消息
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String sendLink(String token, LinkMessageModel model) {
		return Invoke.post(Message.Send_User_By_Robot.url(), model.jsonString(), token);
	}

	/**
	 * 通过机器人发送Markdown消息
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String sendMarkdown(String token, MarkdownMessageModel model) {
		return Invoke.post(Message.Send_User_By_Robot.url(), model.jsonString(), token);
	}

}
