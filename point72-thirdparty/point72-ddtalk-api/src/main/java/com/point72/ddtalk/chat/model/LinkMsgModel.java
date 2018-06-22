package com.point72.ddtalk.chat.model;

import lombok.Data;

@Data
public class LinkMsgModel extends AbstractModel {

	private Link link;

	@Override
	public void setMsgtype() {
		super.msgtype = "link";
	}

	public LinkMsgModel(String title, String text, String pic_url, String message_url, String chatid) {
		super();
		setChatid(chatid);
		this.link = this.new Link(title, text, pic_url, message_url);
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	@Data
	class Link {
		private String title;
		private String text;
		private String picUrl;
		private String messageUrl;

		Link(String title, String text, String pic_url, String message_url) {
			this.title = title;
			this.text = text;
			this.picUrl = pic_url;
			this.messageUrl = message_url;
		}

	}

}
