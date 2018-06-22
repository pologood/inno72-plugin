package com.point72.xiongzhang.model.msg;

import com.alibaba.fastjson.JSONObject;
import com.point72.xiongzhang.enums.MsgType;

import lombok.Data;

@Data
public class AbstractMessageModel {

	private String touser;

	private String msgtype;

	public AbstractMessageModel(String touser, MsgType msgType) {
		this.touser = touser;
		this.msgtype = msgType.name();

	}

	public String json() {
		return JSONObject.toJSONString(this);
	}

}
