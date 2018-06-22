package com.point72.wechat.msg.model.receive;

import com.point72.wechat.msg.model.EventMsgModel;

public class UnSubscribeEventModel extends EventMsgModel {

	@Override
	public void setEvent() {
		Event = "unsubscribe";
	}

}
