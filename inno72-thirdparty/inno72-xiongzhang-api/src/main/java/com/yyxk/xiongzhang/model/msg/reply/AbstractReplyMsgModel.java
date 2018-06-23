package com.inno72.xiongzhang.model.msg.reply;

import java.time.Clock;

import com.alibaba.fastjson.JSONObject;

import lombok.Data;

@Data
public abstract class AbstractReplyMsgModel {
	String ToUserName;
	String FromUserName;
	String CreateTime = String.valueOf(Clock.systemUTC().millis());

	public AbstractReplyMsgModel(String toUserName, String fromUserName) {
		this.ToUserName = toUserName;
		this.FromUserName = fromUserName;
	}

	public AbstractReplyMsgModel(String toUserName, String fromUserName, String CreateTime) {
		this(toUserName, fromUserName);
		this.CreateTime = CreateTime;
	}

	public String json() {
		return JSONObject.toJSONString(this);
	}

	public String encrypt() {

		return null;
	}

}
