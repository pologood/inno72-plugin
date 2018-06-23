package com.inno72.wechat.event;

public enum CallbackEvent {

	Pay_Result("pay"), Refund_Result("refund"), Scan_Pay("scanPay");

	private CallbackEvent(String v) {
		this.v = v;
	}

	private String v;

	@Override
	public String toString() {
		return this.v;
	}

}
