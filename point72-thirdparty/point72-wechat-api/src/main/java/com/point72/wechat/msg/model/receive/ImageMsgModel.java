package com.point72.wechat.msg.model.receive;

import com.point72.wechat.msg.model.AbstractModel;

/**
 * 接收到的图片消息
 * 
 * @author Houkm
 *
 *         2017年6月1日
 */
public class ImageMsgModel extends AbstractModel {

	public String MsgId;
	public String PicUrl;
	/**
	 * 图片消息媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	public String MediaId;

	@Override
	protected void setMsgType() {
		MsgType = "image";
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
