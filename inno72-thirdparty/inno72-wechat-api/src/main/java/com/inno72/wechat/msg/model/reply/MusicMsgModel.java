package com.inno72.wechat.msg.model.reply;

import com.inno72.wechat.msg.model.AbstractModel;

/**
 * 回复音乐消息
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public class MusicMsgModel extends AbstractModel {

	/**
	 * 音乐标题
	 */
	public String Title;

	/**
	 * 音乐描述
	 */
	public String Description;

	/**
	 * 音乐链接
	 */
	public String MusicURL;

	/**
	 * 高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 */
	public String HQMusicUrl;

	/**
	 * 缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
	 */
	public String ThumbMediaId;

	@Override
	protected void setMsgType() {
		MsgType = "image";
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

	public String getMusicURL() {
		return MusicURL;
	}

	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
