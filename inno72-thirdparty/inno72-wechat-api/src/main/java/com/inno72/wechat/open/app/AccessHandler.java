package com.inno72.wechat.open.app;

import com.inno72.wechat.common.Invoke;
import com.inno72.wechat.open.app.ApiUrl.App;

/**
 * 移动应用通过微信登录相关接口
 * 
 * @author Houkm
 *
 *         2017年9月7日
 */
public class AccessHandler {

	/**
	 * 通过code获取access_token
	 * 
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public String accessToken(String appid, String secret, String code) {
		return Invoke.get(App.Access_Token.url(), appid, secret, code);
	}

	/**
	 * 刷新access_token有效期
	 * 
	 * @param appid
	 * @param refreshAccessToken
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public String refreshAccessToken(String appid, String refreshAccessToken) {
		return Invoke.get(App.REFRESH_TOKEN.url(), appid, refreshAccessToken);
	}

	/**
	 * 检验授权凭证（access_token）是否有
	 * 
	 * @param accessToken
	 * @param openid
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public boolean authAccessToken(String accessToken, String openid) {
		String result = Invoke.get(App.Access_Token_Check.url(), accessToken, openid);
		return result.contains("\"errmsg\":\"ok\"");
	}

	/**
	 * 获取用户个人信息（UnionID机制）
	 * 
	 * @param accessToken
	 * @param openid
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public String getUserInfo(String accessToken, String openid) {
		return Invoke.get(App.Userinfo.url(), accessToken, openid);
	}

}
