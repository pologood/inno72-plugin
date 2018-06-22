package com.point72.ddtalk.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.point72.ddtalk.ApiUrl.Core;
import com.point72.ddtalk.Invoke;
import com.point72.ddtalk.ResultHandler;

/**
 * 钉钉权限相关接口
 * 
 * @author Houkm
 *
 *         2017年9月7日
 */
public class AccessHandler {

	private static Logger logger = LoggerFactory.getLogger(AccessHandler.class);

	/**
	 * 获取accessToken
	 * 
	 * @param cropId
	 * @param secret
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String accessToken(String cropId, String secret) {
		String result = Invoke.get(Core.Access_Token.url(), cropId, secret);
		ResultHandler handler = new ResultHandler(result);
		if (handler.isSuccess()) {
			return handler.getString("access_token");
		}
		logger.error("获取钉钉Access_Token失败：{}:{}", handler.getErrcode(), handler.getErrmsg());
		return null;
	}

	/**
	 * 获取jsapi_ticket
	 * 
	 * @param cropId
	 * @param secret
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String jsApiTicket(String token) {
		String result = Invoke.get(Core.JsApi_Ticket.url(), token);
		ResultHandler handler = new ResultHandler(result);
		if (handler.isSuccess()) {
			return handler.getString("ticket");
		}
		logger.error("获取钉钉jsApiTicket失败：{}:{}", handler.getErrcode(), handler.getErrmsg());
		return null;
	}

}
