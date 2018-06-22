package com.point72.ddtalk;

import java.text.MessageFormat;

import com.point72.ddtalk.model.AbstractRestRequestModel;
import com.point72.plugin.http.HttpClient;

public class Invoke {
	public static String get(String url, String... data) {
		url = MessageFormat.format(url, data);
		return HttpClient.get(url);
	}

	public static String post(String url, String json, String... urlData) {
		url = MessageFormat.format(url, urlData);
		return HttpClient.post(url, json);
	}

	public static String rest(AbstractRestRequestModel model) {
		String result = HttpClient.form("https://eco.taobao.com/router/rest", model.toRequestParam(), null);
		return result;
	}

}
