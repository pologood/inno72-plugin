package com.inno72.xiongzhang.model.msg;

import com.inno72.xiongzhang.enums.MsgType;

import lombok.Data;

@Data
public class TextModel extends AbstractMessageModel {

	private Text text;

	public TextModel(String touser) {
		super(touser, MsgType.text);
		text = new Text();
	}

	public TextModel(String touser, String text) {
		this(touser);
		this.text.setContent(text);
	}

	@Data
	private static class Text {
		private String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}
	}

}
