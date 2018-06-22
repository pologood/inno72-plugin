package com.point72.wechat.web;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.MessageFormat;

import com.point72.wechat.ApiUrl.Web;
import com.point72.wechat.common.Invoke;
import com.point72.wechat.common.ResultHandler;

/**
 * 网页接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class WebHandler {

	/**
	 * 生成微信的特别长的链接
	 * 
	 * @param appid
	 * @param scope
	 * @param redirect_uri
	 * @param response_type
	 * @param state
	 * @return
	 * @author Houkm 2017年6月2日
	 */
	public static String generateOAuthUrl(String appid, String scope, String redirect_uri, String response_type,
			String state) {
		try {
			redirect_uri = URLEncoder.encode(redirect_uri, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		scope = scope == null ? "snsapi_base" : scope;
		response_type = response_type == null ? "code" : response_type;
		Object[] args = { appid, redirect_uri, response_type, scope, state };
		String api = "https://open.weixin.qq.com/connect/oauth2/authorize?appid={0}&redirect_uri={1}&response_type={2}&scope={3}&state={4}#wechat_redirect";
		String url = MessageFormat.format(api, args);
		return url;
	}

	/**
	 * 根据code换取网页access_token
	 * 
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 * @author Houkm 2017年6月2日
	 */
	public static String getWebAccessTokenByCode(String appid, String secret, String code) {
		String result = Invoke.get(Web.Web_Access_Token.url(), appid, secret, code);
		return result;
	}

	/**
	 * 根据refresh_token刷新网页Access_token
	 * 
	 * @param appid
	 * @param refreshToken
	 * @return
	 * @author Houkm 2017年6月2日
	 */
	public static String refreshWebAccessToken(String appid, String refreshToken) {
		String result = Invoke.get(Web.Refresh_Web_Access_Token.url(), appid, refreshToken);
		return result;
	}

	/**
	 * 拉取用户信息(需scope为 snsapi_userinfo)
	 * 
	 * @param token
	 * @param openid
	 * @return
	 * @author Houkm 2017年6月2日
	 */
	public static String getUserInfoBySnsapiUserInfo(String token, String openid) {
		String result = Invoke.get(Web.UserInfo.url(), token, openid);
		return result;
	}

	/**
	 * 检验授权凭证（access_token）是否有效
	 * 
	 * @param accessToken
	 * @param openid
	 * @return
	 * @author Houkm 2017年6月2日
	 */
	public static String auth(String accessToken, String openid) {
		String result = Invoke.get(Web.Auth.url(), accessToken, openid);
		return result;
	}

	/**
	 * 获取jsticket
	 * 
	 * @param accessToken
	 * @return
	 * @author Houkm 2017年10月13日
	 */
	public static String ticket(String accessToken) {
		String result = Invoke.get(Web.Ticket.url(), accessToken);
		ResultHandler handler = ResultHandler.create(result);
		if (handler.isSuccess()) {
			return handler.getString("ticket");
		}
		return null;
	}

}
