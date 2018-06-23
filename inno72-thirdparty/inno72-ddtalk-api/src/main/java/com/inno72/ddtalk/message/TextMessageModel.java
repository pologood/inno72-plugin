package com.inno72.ddtalk.message;

import com.inno72.ddtalk.MessageType;

import lombok.Data;

@Data

/**
 * 文本消息对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class TextMessageModel extends AbstractMessageModel {

	public TextMessageModel(String content) {
		super(MessageType.text);
		this.text = this.new Text(content);
	}

	private Text text;

	@Data
	private class Text {
		Text(String content) {
			this.content = content;
		}

		private String content;
	}

}
