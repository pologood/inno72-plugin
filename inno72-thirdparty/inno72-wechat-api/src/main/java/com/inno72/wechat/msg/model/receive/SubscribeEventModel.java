package com.inno72.wechat.msg.model.receive;

import com.inno72.wechat.msg.model.EventMsgModel;

public class SubscribeEventModel extends EventMsgModel {

	/**
	 * 扫码时用户未关注公众号推送此属性，qrscene_为前缀，后面为二维码的参数值
	 */
	public String EventKey;
	/**
	 * 扫码时用户未关注公众号推送此属性，二维码的ticket，可用来换取二维码图片
	 */
	public String Ticket;

	@Override
	public void setEvent() {
		Event = "subscribe";
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
