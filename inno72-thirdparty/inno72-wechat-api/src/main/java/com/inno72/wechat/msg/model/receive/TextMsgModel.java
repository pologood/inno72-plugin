package com.inno72.wechat.msg.model.receive;

import com.inno72.wechat.msg.model.AbstractModel;

/**
 * 接收到的文本消息
 * 
 * @author Houkm
 *
 *         2017年6月1日
 */
public class TextMsgModel extends AbstractModel {

	public String MsgId;
	public String Content;

	@Override
	protected void setMsgType() {
		MsgType = "text";
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
