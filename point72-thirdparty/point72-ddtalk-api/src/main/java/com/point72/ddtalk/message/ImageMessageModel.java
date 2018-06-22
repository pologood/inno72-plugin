package com.point72.ddtalk.message;

import com.point72.ddtalk.MessageType;

import lombok.Data;

@Data

/**
 * 图片消息对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class ImageMessageModel extends AbstractMessageModel {

	/**
	 * 
	 * 
	 * @param mediaId
	 *            图片媒体文件id，可以调用上传媒体文件接口获取。建议宽600像素 x 400像素，宽高比3：2
	 */
	public ImageMessageModel(String mediaId) {
		super(MessageType.image);
		this.image = this.new Image(mediaId);
	}

	private Image image;

	@Data
	private class Image {
		private String media_id;

		Image(String mediaId) {
			this.media_id = mediaId;
		}

	}
}
