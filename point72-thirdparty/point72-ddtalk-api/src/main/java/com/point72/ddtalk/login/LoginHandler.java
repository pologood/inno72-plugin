package com.point72.ddtalk.login;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.point72.ddtalk.ApiUrl.Login;
import com.point72.ddtalk.Invoke;
import com.point72.ddtalk.ResultHandler;
import com.point72.plugin.http.HttpClient;

/**
 * 免登授权相关接口
 * 
 * @author Houkm
 *
 *         2017年9月7日
 */
public class LoginHandler {

	private static Logger logger = LoggerFactory.getLogger(LoginHandler.class);

	/**
	 * 通过CODE换取用户身份
	 * 
	 * @param token
	 * @param code
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String getUserInfoByCode(String token, String code) {
		return Invoke.get(Login.Code2UserInfo.url(), token, code);
	}

	/**
	 * 通过CODE换取微应用管理员的身份信息
	 * 
	 * @param token
	 * @param code
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String getAdminInfoByCode(String token, String code) {
		return Invoke.get(Login.Code2AdminInfo.url(), token, code);
	}

	/**
	 * 获取钉钉开放应用的ACCESS_TOKEN<br>
	 * 普通钉钉用户账号开放相关接口和企业应用开发、ISV应用开发无关，第三方web服务提供商取得钉钉开放应用的appid及appsecret后，可以获取开放应用的ACCESS_TOKEN
	 * 
	 * @param appid
	 * @param appsecret
	 * @return 解析后的accesstoken
	 * @author Houkm 2017年9月7日
	 */
	public static String getLoginAccessToken(String appid, String appsecret) {
		String result = Invoke.get(Login.Login_Access_Token.url(), appid, appsecret);
		ResultHandler handler = new ResultHandler(result);
		if (handler.isSuccess()) {
			return handler.getString("access_token");
		}
		logger.error("获取钉钉开放应用的Access_Token失败：{}:{}", handler.getErrcode(), handler.getErrmsg());
		return null;
	}

	/**
	 * 获取用户授权的持久授权码<br>
	 * 
	 * @param token
	 * @param tmpAuthCode
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String getPersistentCode(String token, String tmpAuthCode) {
		JSONObject json = new JSONObject();
		json.put("tmp_auth_code", tmpAuthCode);
		return HttpClient.post(MessageFormat.format(Login.Get_Persistent_Code.url(), token), json.toJSONString());
	}

	/**
	 * 获取用户授权的SNS_TOKEN<br>
	 * 
	 * @param token
	 * @param openid
	 * @param persistentCode
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String getSnsToken(String token, String openid, String persistentCode) {
		JSONObject json = new JSONObject();
		json.put("openid", openid);
		json.put("persistent_code", persistentCode);
		return HttpClient.post(MessageFormat.format(Login.Get_Sns_Token.url(), token), json.toJSONString());
	}

	/**
	 * 获取用户授权的个人信息<br>
	 * 
	 * @param snsToken
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String getUserinfo(String snsToken) {
		return Invoke.get(Login.Get_UserInfo.url(), snsToken);
	}

	/**
	 * 微应用管理后台免登Token<br>
	 * 
	 * @param corpId
	 * @param secret
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String getSsoToken(String corpId, String secret) {
		return Invoke.get(Login.Sso_Token.url(), corpId, secret);
	}

}
