package com.framelib.dubbo.neworder.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.point72.common.datetime.CustomLocalDateSerializer;
import com.point72.common.datetime.CustomLocalDateTimeSerializer;
import com.point72.common.datetime.CustomLocalTimeSerializer;

public class ManagerOrdersModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1187209705455079192L;
	
	/** 订单id */
	private String id;
	/** 订单编号 */
	private String orderNum ;
	/** 服务项id */
	private String serviceItmeId ;
	/** 服务项名称 */
	private String serviceItmeName ;
	/** 合约单编号 */
	private String cOrderNum ;
	/** 家长id */
	private String parentId ;
	/** 家长姓名 */
	private String parentName;
	/** 医生id */
	private String doctorId ;
	/** 价格 */
	private BigDecimal price ;
	/** 状态 */
	private Integer status ;
	
	/** 订单时间 */
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime orderTime ;
	/** 预约日期 */
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate date ;
	/** 预约时间 */
	@JsonSerialize(using = CustomLocalTimeSerializer.class)
	@DateTimeFormat(iso=ISO.TIME)
	private LocalTime time ;
	/** 状态变更时间 */
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime statusUpdateTime;
	/** 报告更新时间 */
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime reportUpdateTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getServiceItmeId() {
		return serviceItmeId;
	}
	public void setServiceItmeId(String serviceItmeId) {
		this.serviceItmeId = serviceItmeId;
	}
	public String getServiceItmeName() {
		return serviceItmeName;
	}
	public void setServiceItmeName(String serviceItmeName) {
		this.serviceItmeName = serviceItmeName;
	}
	public String getcOrderNum() {
		return cOrderNum;
	}
	public void setcOrderNum(String cOrderNum) {
		this.cOrderNum = cOrderNum;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public LocalDateTime getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public LocalDateTime getStatusUpdateTime() {
		return statusUpdateTime;
	}
	public void setStatusUpdateTime(LocalDateTime statusUpdateTime) {
		this.statusUpdateTime = statusUpdateTime;
	}
	public LocalDateTime getReportUpdateTime() {
		return reportUpdateTime;
	}
	public void setReportUpdateTime(LocalDateTime reportUpdateTime) {
		this.reportUpdateTime = reportUpdateTime;
	}
	
	

}
