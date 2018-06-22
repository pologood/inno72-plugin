package com.point72.wechat.msg.custom;

import com.point72.wechat.msg.model.AbstractCustomMsgModel;

import lombok.Data;

@Data
public class TextMsgModel extends AbstractCustomMsgModel {

	private Text text;

	@Override
	public String setMsgType() {
		return "text";
	}

	@Data
	public class Text {
		private String content;
	}

}
