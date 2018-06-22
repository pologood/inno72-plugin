package com.point72.ddtalk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class RestResultHandler {

	private JSONObject json;

	public RestResultHandler(String result, String method) {
		json = JSON.parseObject(result).getJSONObject(method).getJSONObject("result");
	}

	public boolean isSuccess() {
		return json.getBoolean("success");
	}

	public Integer getDingOpenErrcode() {
		return json.getInteger("ding_open_errcode");
	}

	public String getErrmsg() {
		return json.getString("error_msg");
	}

	public String getString(String key) {
		return json.getString(key);
	}

	public Integer getInteger(String key) {
		return json.getInteger(key);
	}

	public Object get(String key) {
		return json.get(key);
	}

	public JSONObject getJSONObject(String key) {
		return json.getJSONObject(key);
	}

	public JSONArray getJSONArray(String key) {
		return json.getJSONArray(key);
	}

}
