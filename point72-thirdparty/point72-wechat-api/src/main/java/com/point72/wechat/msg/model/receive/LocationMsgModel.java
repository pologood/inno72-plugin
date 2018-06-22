package com.point72.wechat.msg.model.receive;

import com.point72.wechat.msg.model.AbstractModel;

/**
 * 接收到的地理位置消息
 * 
 * @author Houkm
 *
 *         2017年6月1日
 */
public class LocationMsgModel extends AbstractModel {

	public String MsgId;

	/**
	 * 地理位置维度
	 */
	public String Location_X;
	/**
	 * 地理位置经度
	 */
	public String Location_Y;
	/**
	 * 地图缩放大小
	 */
	public String Scale;
	/**
	 * 地理位置信息
	 */
	public String Label;

	@Override
	protected void setMsgType() {
		MsgType = "location";
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

}
