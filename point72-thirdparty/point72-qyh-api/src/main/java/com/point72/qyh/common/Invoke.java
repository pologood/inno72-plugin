package com.point72.qyh.common;

import java.text.MessageFormat;

import com.point72.plugin.http.HttpClient;

/**
 * 请求微信接口
 * 
 * @author Houkm
 *
 *         2017年5月18日
 */
public class Invoke {

	public static String get(String url, String... data) {
		String format = MessageFormat.format(url, data);
		url = format;
		return HttpClient.get(url);
	}

	public static String post(String url, String json, String... urlData) {
		url = MessageFormat.format(url, urlData);
		return HttpClient.post(url, json);
	}

}
