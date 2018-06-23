package com.inno72.ddtalk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ResultHandler {

	private JSONObject json;

	public ResultHandler(String result) {
		json = JSON.parseObject(result);
	}

	public boolean isSuccess() {
		Integer errcode = json.getInteger("errcode");
		return errcode == null || errcode == 0;
	}

	public Integer getErrcode() {
		return json.getInteger("errcode");
	}

	public String getErrmsg() {
		return json.getString("errmsg");
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
