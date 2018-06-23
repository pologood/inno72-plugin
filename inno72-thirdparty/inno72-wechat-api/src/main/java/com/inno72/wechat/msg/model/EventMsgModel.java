package com.inno72.wechat.msg.model;

/**
 * 事件消息
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public abstract class EventMsgModel extends AbstractModel {

	@Override
	protected void setMsgType() {
		MsgType = "event";
	}

	public String Event;

	public String getEvent() {
		return Event;
	}

	public abstract void setEvent();

}
