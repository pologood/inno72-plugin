package com.framelib.dubbo.model;

public class OrdersPkgExtend extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7570572039837175458L;
	private String id;
	private String orderId;
	private String escortId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getEscortId() {
		return escortId;
	}

	public void setEscortId(String escortId) {
		this.escortId = escortId;
	}

}
