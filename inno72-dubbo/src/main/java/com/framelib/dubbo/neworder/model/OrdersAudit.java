package com.framelib.dubbo.neworder.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.inno72.common.datetime.CustomLocalDateTimeSerializer;

/**
 * 审核单
 * 
 * @author zhouzengbao
 *
 */
public class OrdersAudit {
	/***/
	private String id;

	/**订单orders  id*/
	private String orderId;

	/**订单号*/
	private String orderNum;

	/**审核详情*/
	private String auditInfo;

	/**审核人*/
	private String auditor;

	/**审核时间*/
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime auditTime;

	/**审核状态*/
	private Integer auditStatus;
	public enum AUDIT_STATUS{

		AWAIT(0,"待审核"),
		REJECT(2,"驳回"),
		PASS(1,"审核通过")
		;

		private Integer k;
		private String d;

		private AUDIT_STATUS(Integer k, String d) {
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
	
	/**提交时间*/
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime submitTime;

	/**创建时间*/
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime createTime;

	/**更新时间*/
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime updateTime;

	/**审核类型*/
	private Integer type;

	public enum AUDIT_TYPE{

		OUTPATIENT(1,"门诊"),

		;

		private Integer k;
		private String d;

		private AUDIT_TYPE(Integer k, String d) {
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

	

	public LocalDateTime getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(LocalDateTime submitTime) {
		this.submitTime = submitTime;
	}

	/***/
	public String getId() {
		return id;
	}

	/***/
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**订单orders  id*/
	public String getOrderId() {
		return orderId;
	}

	/**订单orders  id*/
	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	/**订单号*/
	public String getOrderNum() {
		return orderNum;
	}

	/**订单号*/
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum == null ? null : orderNum.trim();
	}

	/**审核详情*/
	public String getAuditInfo() {
		return auditInfo;
	}

	/**审核详情*/
	public void setAuditInfo(String auditInfo) {
		this.auditInfo = auditInfo == null ? null : auditInfo.trim();
	}

	/**审核人*/
	public String getAuditor() {
		return auditor;
	}

	/**审核人*/
	public void setAuditor(String auditor) {
		this.auditor = auditor == null ? null : auditor.trim();
	}

	/**审核时间*/
	public LocalDateTime getAuditTime() {
		return auditTime;
	}

	/**审核时间*/
	public void setAuditTime(LocalDateTime auditTime) {
		this.auditTime = auditTime;
	}

	/**审核状态*/
	public Integer getAuditStatus() {
		return auditStatus;
	}

	/**审核状态*/
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**创建时间*/
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	/**创建时间*/
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	/**更新时间*/
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	/**更新时间*/
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	/**审核类型*/
	public Integer getType() {
		return type;
	}

	/**审核类型*/
	public void setType(Integer type) {
		this.type = type;
	}
}