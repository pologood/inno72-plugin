package com.point72.ddtalk.chat.model;

public class VoiceMsgModel extends AbstractModel {

	private Voice voice;

	@Override
	public void setMsgtype() {
		super.msgtype = "voice";
	}

	public VoiceMsgModel(String mediaId, String duration, String chatid) {
		super();
		setChatid(chatid);
		this.voice = this.new Voice(mediaId, duration);
	}

	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	class Voice {
		private String media_id;
		private String duration;

		Voice(String media_id, String duration) {
			this.media_id = media_id;
			this.duration = duration;
		}

		public String getMedia_id() {
			return media_id;
		}

		public void setMedia_id(String media_id) {
			this.media_id = media_id;
		}

		public String getDuration() {
			return duration;
		}

		public void setDuration(String duration) {
			this.duration = duration;
		}

	}

}
