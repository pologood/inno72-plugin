package com.inno72.wechat.msg.model.receive;

import com.inno72.wechat.msg.model.EventMsgModel;

/**
 * 点击菜单拉取消息时的事件推送
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public class PoiCheckNotifyEventModel extends EventMsgModel {

	public String UniqId;
	public String PoiId;
	public String Result;
	public String msg;

	@Override
	public void setEvent() {
		Event = "poi_check_notify";
	}

	public String getUniqId() {
		return UniqId;
	}

	public void setUniqId(String uniqId) {
		UniqId = uniqId;
	}

	public String getPoiId() {
		return PoiId;
	}

	public void setPoiId(String poiId) {
		PoiId = poiId;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
