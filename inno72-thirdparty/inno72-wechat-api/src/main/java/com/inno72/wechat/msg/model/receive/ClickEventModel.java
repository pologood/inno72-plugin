package com.inno72.wechat.msg.model.receive;

import com.inno72.wechat.msg.model.EventMsgModel;

/**
 * 点击菜单拉取消息时的事件推送
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public class ClickEventModel extends EventMsgModel {

	/**
	 * 事件KEY值，与自定义菜单接口中KEY值对应
	 */
	public String EventKey;

	@Override
	public void setEvent() {
		Event = "CLICK";
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
