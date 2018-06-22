package com.point72.wechat.msg.model.receive;

import com.point72.wechat.msg.model.AbstractModel;

/**
 * 接收到的语音消息
 * 
 * @author Houkm
 *
 *         2017年6月1日
 */
public class VoiceMsgModel extends AbstractModel {

	public String MsgId;
	/**
	 * 语音消息媒体id，可以调用多媒体文件下载接口拉取数据
	 */
	public String MediaId;
	/**
	 * 语音格式，如amr，speex等
	 */
	public String Format;
	/**
	 * 语音识别结果，UTF8编码
	 */
	public String Recognition;

	@Override
	protected void setMsgType() {
		MsgType = "voice";
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

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

}
