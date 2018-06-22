package com.point72.wechat.msg.model.receive;

import com.point72.wechat.msg.model.EventMsgModel;

/**
 * 点击菜单跳转链接时的事件推送
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public class ViewEventModel extends EventMsgModel {

	/**
	 * 事件KEY值，设置的跳转UR
	 */
	public String EventKey;
	public String MenuId;

	@Override
	public void setEvent() {
		Event = "VIEW";
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getMenuId() {
		return MenuId;
	}

	public void setMenuId(String menuId) {
		MenuId = menuId;
	}

}
