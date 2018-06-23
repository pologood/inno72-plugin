package com.inno72.ddtalk.message;

import com.alibaba.fastjson.JSON;
import com.inno72.ddtalk.MessageType;

/**
 * 消息数据对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public abstract class AbstractMessageModel {

	private MessageType msgtype;

	/**
	 * 发送普通消息
	 */
	private String sender;

	/**
	 * 发送普通消息
	 */
	private String cid;

	@SuppressWarnings("unused")
	private AbstractMessageModel() {
	}

	public AbstractMessageModel(MessageType msgType) {
		this.msgtype = msgType;
	}

	public MessageType getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(MessageType msgtype) {
		this.msgtype = msgtype;
	}

	public String jsonString() {
		return JSON.toJSONString(this);
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
