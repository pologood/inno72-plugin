package com.inno72.xiongzhang.model.msg.reply;

import lombok.Data;

@Data
public class VoiceReplyMsgModel extends AbstractReplyMsgModel {

	private VoiceReplyMsgModel(String toUserName, String fromUserName) {
		super(toUserName, fromUserName);
	}

	public VoiceReplyMsgModel(String toUserName, String fromUserName, String mediaId) {
		super(toUserName, fromUserName);
		setMediaId(mediaId);
	}

	Voice Voice;
	String MsgType = "voice";

	public void setMediaId(String mediaId) {
		this.Voice = new Voice(mediaId);
	}

	@Data
	private class Voice {
		private Voice(String mediaId) {
			this.MediaId = mediaId;
		}

		private String MediaId;
	}

}
