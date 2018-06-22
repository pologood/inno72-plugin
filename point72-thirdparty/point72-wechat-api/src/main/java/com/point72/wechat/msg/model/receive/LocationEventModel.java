package com.point72.wechat.msg.model.receive;

import com.point72.wechat.msg.model.EventMsgModel;

/**
 * 上报地理位置事件
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public class LocationEventModel extends EventMsgModel {

	/**
	 * 地理位置纬度
	 */
	public String Latitude;
	/**
	 * 地理位置经度
	 */
	public String Longitude;
	/**
	 * 地理位置精度
	 */
	public String Precision;

	@Override
	public void setEvent() {
		Event = "LOCATION";
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

}
