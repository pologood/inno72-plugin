package com.framelib.dubbo.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PkgOrderVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderNum;
	private String appOrderNum;
	private String doctorId;
	private String doctorName;
	private String performerId;
	private String performerName;

	private String userId;
	private String userTelno;
	private String escortId;
	private String escortName;

	private LocalDateTime orderEndTime; // 预约时间
	private LocalDateTime orderBeginTime;

	private String province;
	private String city;
	private String district;
	private String address;
	private double longitude;
	private double latitude;
	private String poi;

	private BigDecimal goodsPrice;
	private BigDecimal orderPrice;
	private BigDecimal payPrice;

	private String adminAreaId;

	private String creator;

	private List<PkgGoodsVo> goods;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPerformerId() {
		return performerId;
	}

	public void setPerformerId(String performerId) {
		this.performerId = performerId;
	}

	public String getPerformerName() {
		return performerName;
	}

	public void setPerformerName(String performerName) {
		this.performerName = performerName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserTelno() {
		return userTelno;
	}

	public void setUserTelno(String userTelno) {
		this.userTelno = userTelno;
	}

	public String getEscortId() {
		return escortId;
	}

	public void setEscortId(String escortId) {
		this.escortId = escortId;
	}

	public String getEscortName() {
		return escortName;
	}

	public void setEscortName(String escortName) {
		this.escortName = escortName;
	}

	public LocalDateTime getOrderEndTime() {
		return orderEndTime;
	}

	public void setOrderEndTime(LocalDateTime orderEndTime) {
		this.orderEndTime = orderEndTime;
	}

	public LocalDateTime getOrderBeginTime() {
		return orderBeginTime;
	}

	public void setOrderBeginTime(LocalDateTime orderBeginTime) {
		this.orderBeginTime = orderBeginTime;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getPoi() {
		return poi;
	}

	public void setPoi(String poi) {
		this.poi = poi;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public BigDecimal getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getAppOrderNum() {
		return appOrderNum;
	}

	public void setAppOrderNum(String appOrderNum) {
		this.appOrderNum = appOrderNum;
	}

	public List<PkgGoodsVo> getGoods() {
		return goods;
	}

	public void setGoods(List<PkgGoodsVo> goods) {
		this.goods = goods;
	}

	public String getAdminAreaId() {
		return adminAreaId;
	}

	public void setAdminAreaId(String adminAreaId) {
		this.adminAreaId = adminAreaId;
	}

}
