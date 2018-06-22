package com.point72.wechat.msg.model.receive;

import com.point72.wechat.msg.model.EventMsgModel;

/**
 * 扫描带参数二维码事件
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public class ScanEventModel extends EventMsgModel {

	/**
	 * 扫码时推送,事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
	 */
	public String EventKey;
	/**
	 * 扫码时推送,二维码的ticket，可用来换取二维码图片
	 */
	public String Ticket;

	@Override
	public void setEvent() {
		Event = "SCAN";
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

}
