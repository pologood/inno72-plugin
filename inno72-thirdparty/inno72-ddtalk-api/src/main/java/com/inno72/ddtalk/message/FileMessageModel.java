package com.inno72.ddtalk.message;

import com.inno72.ddtalk.MessageType;

import lombok.Data;

@Data

/**
 * 文件消息对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class FileMessageModel extends AbstractMessageModel {

	/**
	 * 
	 * 
	 * @param mediaId
	 *            媒体文件id，可以调用上传媒体文件接口获取。10MB
	 */
	public FileMessageModel(String mediaId) {
		super(MessageType.file);
		this.file = this.new File(mediaId);
	}

	private File file;

	@Data
	private class File {
		File(String mediaId) {
			this.media_id = mediaId;
		}

		private String media_id;
	}

}
