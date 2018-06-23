package com.framelib.dubbo.model;

import java.math.BigDecimal;

public class OrdersGoodsItem extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2232201144848076845L;

	public OrdersGoodsItem() {
	}

	private String id;
	private String orderId;
	private String orderNum;
	private String orderInfoId;
	private BigDecimal goodsPrice;
	private String serviceInfo;
	private String optionInfo;
	private String goodsInfo;

	private Integer isPerform;

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

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(String orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getServiceInfo() {
		return serviceInfo;
	}

	public void setServiceInfo(String serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	public String getOptionInfo() {
		return optionInfo;
	}

	public void setOptionInfo(String optionInfo) {
		this.optionInfo = optionInfo;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public Integer getIsPerform() {
		return isPerform;
	}

	public void setIsPerform(Integer isPerform) {
		this.isPerform = isPerform;
	}

}