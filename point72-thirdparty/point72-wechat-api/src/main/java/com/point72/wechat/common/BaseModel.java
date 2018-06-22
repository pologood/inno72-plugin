package com.point72.wechat.common;

import com.alibaba.fastjson.JSON;

public class BaseModel {

	public String json() {
		return JSON.toJSONString(this);
	}

}
