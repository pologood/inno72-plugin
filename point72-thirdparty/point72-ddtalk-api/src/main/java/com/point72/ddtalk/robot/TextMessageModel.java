package com.point72.ddtalk.robot;

import lombok.Data;

@Data
public class TextMessageModel extends com.point72.ddtalk.message.TextMessageModel {

	private At at;

	public TextMessageModel(String content, At at) {
		super(content);
		this.at = at;
	}

}
