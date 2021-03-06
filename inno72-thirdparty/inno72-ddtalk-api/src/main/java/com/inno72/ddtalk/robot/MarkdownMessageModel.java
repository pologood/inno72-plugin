package com.inno72.ddtalk.robot;

import lombok.Data;

@Data
public class MarkdownMessageModel extends com.inno72.ddtalk.message.MarkdownMessageModel {

	private At at;

	public MarkdownMessageModel(String title, String text, At at) {
		super(title, text);
		this.at = at;
	}

}
