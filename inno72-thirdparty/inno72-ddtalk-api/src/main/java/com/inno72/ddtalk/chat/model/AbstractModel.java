package com.inno72.ddtalk.chat.model;

import com.alibaba.fastjson.JSON;

import lombok.Data;

@Data
public abstract class AbstractModel {

	private String chatid;
	protected String msgtype;

	public AbstractModel() {
		setMsgtype();
	}

	public String toJson() {
		return JSON.toJSONString(this);
	}

	public abstract void setMsgtype();

}
