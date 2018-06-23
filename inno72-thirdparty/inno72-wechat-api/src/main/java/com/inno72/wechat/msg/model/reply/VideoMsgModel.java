package com.inno72.wechat.msg.model.reply;

import com.inno72.wechat.msg.model.AbstractModel;

/**
 * 回复语音消息
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public class VideoMsgModel extends AbstractModel {

	/**
	 * 通过素材管理中的接口上传多媒体文件，得到的id
	 */
	public String MediaId;

	@Override
	protected void setMsgType() {
		MsgType = "voice";
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
