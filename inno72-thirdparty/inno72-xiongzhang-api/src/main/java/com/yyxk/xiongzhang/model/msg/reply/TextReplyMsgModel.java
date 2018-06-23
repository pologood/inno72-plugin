package com.inno72.xiongzhang.model.msg.reply;

import lombok.Data;

@Data
public class TextReplyMsgModel extends AbstractReplyMsgModel {

	public TextReplyMsgModel(String toUserName, String fromUserName) {
		super(toUserName, fromUserName);
	}

	public TextReplyMsgModel(String toUserName, String fromUserName, String content) {
		super(toUserName, fromUserName);
		setContent(content);
	}

	private String Content;
	private String MsgType = "text";

	public void setContent(String content) {
		this.Content = content;
	}

}
