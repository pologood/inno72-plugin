package com.inno72.qy.msg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.inno72.qyh.common.Invoke;

public class MsgHandler {

	private static Logger logger = LoggerFactory.getLogger(MsgHandler.class);

	public static String send(String accessToken, String json) {
		logger.info("发送企业号消息: {}", json);
		String result = Invoke.post("https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token={0}", json,
				accessToken);
		logger.info("发送企业号消息结果: {}", result);
		return result;
	}

}
