package com.framelib.dubbo.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.inno72.common.datetime.CustomLocalDateTimeSerializer;

public class OrdersFile extends BaseModel {

	private static final long serialVersionUID = 1L;

	public enum File_Type {
		// 取消
		IMAGE("image"),
		// 未接诊
		VIDEO("video");

		private String v;

		private File_Type(String v) {
			this.v = v;
		}

		public String v() {
			return this.v;
		}
	}

	private String id;

	private String orderId;

	private String orderNum;

	private String url;

	private String fileType;

	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime createTime;

	private Integer isDel;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType == null ? null : fileType.trim();
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

}