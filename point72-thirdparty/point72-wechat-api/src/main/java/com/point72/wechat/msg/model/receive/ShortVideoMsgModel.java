package com.point72.wechat.msg.model.receive;

import com.point72.wechat.msg.model.AbstractModel;

/**
 * 接收到的小视频消息
 * 
 * @author Houkm
 *
 *         2017年6月1日
 */
public class ShortVideoMsgModel extends AbstractModel {

	public String MsgId;
	/**
	 * 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	public String ThumbMediaId;
	/**
	 * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	public String MediaId;

	@Override
	protected void setMsgType() {
		MsgType = "shortvideo";
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
