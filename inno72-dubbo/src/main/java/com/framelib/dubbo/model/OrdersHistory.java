package com.framelib.dubbo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.inno72.common.datetime.CustomLocalDateTimeSerializer;

public class OrdersHistory extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6343871473341017269L;

	private String id;

	private String orderId;

	private String orderNum;

	private String creatorId;

	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime createTime;

	private String info;

	private String remark;
	
	private Integer historType;
	
	public OrdersHistory() {
		super();
	}

	public OrdersHistory(String id, String orderId, String orderNum, String creatorId, LocalDateTime createTime,
			String info, String remark, Integer historType) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.orderNum = orderNum;
		this.creatorId = creatorId;
		this.createTime = createTime;
		this.info = info;
		this.remark = remark;
		this.historType = historType;
	}

	public enum ORDERS_HISTORY_TYPE{

		AUDIT_OUTPATIENT(0,"待审核"),
		;

		private Integer k;
		private String d;

		private ORDERS_HISTORY_TYPE(Integer k, String d) {
			this.k = k;
			this.d = d;
		}
		public Integer getK() {
			return k;
		}
		public String getD() {
			return d;
		}
	}
	
	public Integer getHistorType() {
		return historType;
	}

	public void setHistorType(Integer historType) {
		this.historType = historType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum == null ? null : orderNum.trim();
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId == null ? null : creatorId.trim();
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info == null ? null : info.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}