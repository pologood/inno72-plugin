package com.inno72.xiongzhang.model.msg.reply;

import lombok.Data;

@Data
public class ImageReplyMsgModel extends AbstractReplyMsgModel {

	private ImageReplyMsgModel(String toUserName, String fromUserName) {
		super(toUserName, fromUserName);
	}

	public ImageReplyMsgModel(String toUserName, String fromUserName, String mediaId) {
		super(toUserName, fromUserName);
		setMediaId(mediaId);
	}

	Image Image;
	String MsgType = "image";

	public void setMediaId(String mediaId) {
		this.Image = new Image(mediaId);
	}

	@Data
	private class Image {
		private Image(String mediaId) {
			this.MediaId = mediaId;
		}

		private String MediaId;
	}

}
