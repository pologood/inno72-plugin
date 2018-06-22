package com.point72.xiongzhang.core;

import com.point72.xiongzhang.ApiUrl;
import com.point72.xiongzhang.Invoke;
import com.point72.xiongzhang.tools.ResultHandler;

/**
 * 各种凭据接口
 * 
 * @author Houkm
 *
 *         2018年4月3日
 */
public class CoreHandler {

	/**
	 * 获取AccessToken
	 * 
	 * @param clientId
	 * @param clientSecret
	 * @return
	 * @author Houkm 2018年4月3日
	 */
	public static String getAccessToken(String clientId, String clientSecret) {
		String result = Invoke.get(ApiUrl.Core.Access_token.url(), clientId, clientSecret);
		ResultHandler handler = ResultHandler.create(result);
		if (handler.success()) {
			return handler.getString("access_token");
		}
		return null;
	}

	/**
	 * 获取jsapi_ticket
	 * 
	 * @param accessToken
	 * @return
	 * @author Houkm 2018年4月3日
	 */
	public static String getJsapiTicket(String accessToken) {
		String result = Invoke.get(ApiUrl.Core.Jsapi_ticket.url(), accessToken);
		ResultHandler handler = ResultHandler.create(result);
		if (handler.success()) {
			return handler.getString("ticket");
		}
		return null;
	}

}
