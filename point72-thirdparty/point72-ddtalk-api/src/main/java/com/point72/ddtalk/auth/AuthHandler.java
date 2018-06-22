package com.point72.ddtalk.auth;

import com.point72.ddtalk.ApiUrl.Auth;
import com.point72.ddtalk.Invoke;

/**
 * 通讯录权限
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class AuthHandler {

	/**
	 * 获取通讯录权限
	 * 
	 * @param token
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String getScopes(String token) {
		return Invoke.get(Auth.Get_Scopes.url(), token);
	}

}
