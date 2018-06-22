package com.point72.ddtalk.message;

import com.point72.ddtalk.MessageType;

import lombok.Data;

@Data

/**
 * 语音消息对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class VoiceMessageModel extends AbstractMessageModel {

	/**
	 * 
	 * 
	 * @param mediaId
	 *            语音媒体文件id，可以调用上传媒体文件接口获取。2MB，播放长度不超过60s，AMR格式
	 * @param duration
	 *            小于60，表示音频时长
	 */
	public VoiceMessageModel(String mediaId, int duration) {
		super(MessageType.voice);
		this.voice = this.new Voice(mediaId, duration);

	}

	private Voice voice;

	@Data
	private class Voice {
		Voice(String mediaId, int duration) {
			this.media_id = mediaId;
			this.duration = String.valueOf(duration < 60 ? duration : 60);
		}

		private String media_id;
		private String duration;
	}

}
