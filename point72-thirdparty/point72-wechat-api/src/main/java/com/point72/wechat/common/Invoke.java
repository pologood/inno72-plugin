package com.point72.wechat.common;

import java.text.MessageFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.point72.plugin.http.HttpClient;

/**
 * 请求微信接口
 * 
 * @author Houkm
 *
 *         2017年5月18日
 */
public class Invoke {

	static Logger logger = LoggerFactory.getLogger(Invoke.class);

	public static String get(String url, String... data) {
		String format = MessageFormat.format(url, data);
		url = format;
		logger.info("请求微信接口：{}", url);
		return HttpClient.get(url);
	}

	public static String post(String url, String json, String... urlData) {
		url = MessageFormat.format(url, urlData);
		logger.info("请求微信接口：{}", url);
		logger.info("请求微信接口数据：{}", json);
		return HttpClient.post(url, json);
	}
}
