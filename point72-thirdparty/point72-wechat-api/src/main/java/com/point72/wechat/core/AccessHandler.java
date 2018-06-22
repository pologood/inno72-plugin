package com.point72.wechat.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.point72.wechat.ApiUrl.Core;
import com.point72.wechat.common.Invoke;
import com.point72.wechat.common.ResultHandler;

/**
 * 微信权限相关接口
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
	 * @return accesstoken
	 * @author Houkm 2017年9月7日
	 */
	public static String accessToken(String appid, String secret) {
		String result = Invoke.get(Core.Access_Token.url(), appid, secret);
		ResultHandler handler = ResultHandler.create(result);
		if (handler.isSuccess()) {
			return handler.getString("access_token");
		}
		logger.error("获取微信Access_Token失败：{}:{}", handler.getErrcode(), handler.getErrmsg());
		return null;
	}

	/**
	 * 获取微信服务器IP地址列表
	 * 
	 * @param token
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String[] getWxIp(String token) {
		String result = Invoke.get(Core.WechatServerIP.url(), token);
		ResultHandler handler = ResultHandler.create(result);
		if (handler.isSuccess()) {
			JSONArray array = handler.getJSONArray("ip_list");
			return array.toArray(new String[array.size()]);
		}
		logger.error("获取微信IP列表失败：{}", handler.getErrmsg());
		return null;
	}

	/**
	 * 获取网页授权accessToken
	 * 
	 * @param cropId
	 * @param secret
	 * @return accesstoken
	 * @author Houkm 2017年9月7日
	 */
	public static String webAccessToken(String appid, String secret, String code) {
		String result = Invoke.get(Core.CODE_TOKEN.url(), appid, secret, code);
		ResultHandler handler = ResultHandler.create(result);
		if (handler.isSuccess()) {
			return handler.getString("access_token");
		}
		return null;
	}

	/**
	 * code换取openid
	 * 
	 * @param cropId
	 * @param secret
	 * @return accesstoken
	 * @author Houkm 2017年9月7日
	 */
	public static String openid(String appid, String secret, String code) {
		String result = Invoke.get(Core.CODE_TOKEN.url(), appid, secret, code);
		ResultHandler handler = ResultHandler.create(result);
		if (handler.isSuccess()) {
			return handler.getString("openid");
		}
		return null;
	}
}
