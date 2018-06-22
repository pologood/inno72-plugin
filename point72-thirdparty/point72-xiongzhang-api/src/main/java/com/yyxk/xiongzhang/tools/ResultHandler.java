package com.point72.xiongzhang.tools;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

@Data
public class ResultHandler {

	private ResultHandler() {
	}

	private JSONObject jsonObj;

	public static ResultHandler create(String json) {
		ResultHandler handler = new ResultHandler();
		handler.jsonObj = JSONObject.parseObject(json);
		return handler;
	}

	/**
	 * 返回值是否成功
	 * 
	 * @return
	 * @author Houkm 2018年4月3日
	 */
	public boolean success() {
		return jsonObj.getString("error_code") == null;
	}

	public String getErrmsg() {
		return jsonObj.getString("error_msg");
	}

	public String getString(String key) {
		return jsonObj.getString(key);
	}

	public int getInt(String key) {
		return jsonObj.getInteger(key);
	}

}
