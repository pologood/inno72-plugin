package com.inno72.wechat.msg.model;

import com.alibaba.fastjson.JSON;

import lombok.Data;

@Data
public abstract class AbstractCustomMsgModel {

	private String touser;

	private String msgtype = setMsgType();

	public abstract String setMsgType();

	public String toJson() {
		return JSON.toJSONString(this);
	}

}
