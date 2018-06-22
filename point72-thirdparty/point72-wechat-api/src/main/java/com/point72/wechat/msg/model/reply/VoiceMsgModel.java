package com.point72.wechat.msg.model.reply;

import com.point72.wechat.msg.model.AbstractModel;

/**
 * 回复视频消息
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public class VoiceMsgModel extends AbstractModel {

	/**
	 * 通过素材管理中的接口上传多媒体文件，得到的id
	 */
	public String MediaId;

	/**
	 * 视频消息的标题
	 */
	public String Title;

	/**
	 * 视频消息的描述
	 */
	public String Description;

	@Override
	protected void setMsgType() {
		MsgType = "video";
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

}
