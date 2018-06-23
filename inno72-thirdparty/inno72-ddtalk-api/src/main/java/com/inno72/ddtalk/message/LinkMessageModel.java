package com.inno72.ddtalk.message;

import com.inno72.ddtalk.MessageType;

import lombok.Data;

@Data

/**
 * Link消息对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class LinkMessageModel extends AbstractMessageModel {

	/**
	 * 
	 * 
	 * @param mediaId
	 *            媒体文件id，可以调用上传媒体文件接口获取。10MB
	 */
	public LinkMessageModel(String messageUrl, String picUrl, String title, String text) {
		super(MessageType.link);
		this.link = this.new Link();
		this.link.setMessageUrl(messageUrl);
		this.link.setPicUrl(picUrl);
		this.link.setTitle(title);
		this.link.setText(text);
	}

	private Link link;

	@Data
	private class Link {
		String messageUrl;
		String picUrl;
		String title;
		String text;
	}

}
