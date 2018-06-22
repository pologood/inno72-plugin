package com.point72.ddtalk.message;

import com.point72.ddtalk.MessageType;

import lombok.Data;

@Data

/**
 * markdown消息对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class MarkdownMessageModel extends AbstractMessageModel {

	/**
	 * 
	 * @param title
	 *            首屏会话透出的展示内容
	 * @param text
	 *            markdown格式的消息
	 */
	public MarkdownMessageModel(String title, String text) {
		super(MessageType.markdown);
		this.markdown.title = title;
		this.markdown.text = text;
	}

	private Markdown markdown = new Markdown();

	@Data
	private class Markdown {
		private String title;
		private String text;
	}

}
