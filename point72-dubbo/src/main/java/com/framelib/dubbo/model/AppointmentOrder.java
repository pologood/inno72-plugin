package com.framelib.dubbo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.point72.common.datetime.CustomLocalDateSerializer;
import com.point72.common.datetime.CustomLocalDateTimeSerializer;

public class AppointmentOrder {

	public enum Status {

		// 取消
		CANCLE(0),
		// 未生成
		INIT(1),
		// 部分生成
		PART(2),
		// 已生成
		ALL(3);

		private int v;

		private Status(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}
	}

	public enum Desc {
		// 单独生成合约
		CREATE("生成合约"),
		// 批量生成
		CREATES("批量生成合约");

		private String v;

		private Desc(String v) {
			this.v = v;
		}

		public String v() {
			return this.v;
		}
	}

	private String id;
	private String orderNum;
	private String doctorId;
	private String doctorName;
	private String performerId;
	private String performerName;
	private String performerNo;

	/**
	 * @see {@link SEX}
	 */
	private int performerSex;

	@JsonSerialize(using = CustomLocalDateSerializer.class)
	private LocalDate performerBirthday;
	private String userId;
	private String userName;
	private String userTelno;
	private String userIdentity;
	private String escortId;
	private String escortName;
	private String escortMobile;
	private String escortCardid;
	private int escortSex;
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime ext1Time; // 预约时间
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime orderTime;

	private String province;
	private String city;
	private String district;
	private String address;
	private double longitude;
	private double latitude;
	private String poi;

	private String remark;

	private int status;

	private String doctorCode;// 医生推荐码

	private BigDecimal goodsPrice;
	private BigDecimal orderPrice;
	private BigDecimal discountPrice;
	private BigDecimal payPrice;
	private BigDecimal ext1Price;

	private String businessStatus;
	private String orderType;
	private String orderPid;
	private String isDel;
	private String channel;
	private String holdStatus;

	private String userDoctorRecomId;
	private String adminAreaId;

	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime payTime;
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime finishTime;
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime refundTime;

	private BigDecimal ext2Price;
	private BigDecimal ext3Price;
	private BigDecimal ext4Price;
	private BigDecimal ext5Price;

	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime ext2Time;
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime ext3Time;
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime ext4Time;
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime ext5Time;

	private List<AppointmentItem> appointmentItems;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPerformerNo() {
		return performerNo;
	}

	public void setPerformerNo(String performerNo) {
		this.performerNo = performerNo;
	}

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

	public int getPerformerSex() {
		return performerSex;
	}

	public void setPerformerSex(int performerSex) {
		this.performerSex = performerSex;
	}

	public LocalDate getPerformerBirthday() {
		return performerBirthday;
	}

	public void setPerformerBirthday(LocalDate performerBirthday) {
		this.performerBirthday = performerBirthday;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getEscortMobile() {
		return escortMobile;
	}

	public void setEscortMobile(String escortMobile) {
		this.escortMobile = escortMobile;
	}

	public String getEscortCardid() {
		return escortCardid;
	}

	public void setEscortCardid(String escortCardid) {
		this.escortCardid = escortCardid;
	}

	public LocalDateTime getExt1Time() {
		return ext1Time;
	}

	public void setExt1Time(LocalDateTime ext1Time) {
		this.ext1Time = ext1Time;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public BigDecimal getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}

	public BigDecimal getExt1Price() {
		return ext1Price;
	}

	public void setExt1Price(BigDecimal ext1Price) {
		this.ext1Price = ext1Price;
	}

	public String getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(String businessStatus) {
		this.businessStatus = businessStatus;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderPid() {
		return orderPid;
	}

	public void setOrderPid(String orderPid) {
		this.orderPid = orderPid;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getHoldStatus() {
		return holdStatus;
	}

	public void setHoldStatus(String holdStatus) {
		this.holdStatus = holdStatus;
	}

	public LocalDateTime getPayTime() {
		return payTime;
	}

	public void setPayTime(LocalDateTime payTime) {
		this.payTime = payTime;
	}

	public LocalDateTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalDateTime finishTime) {
		this.finishTime = finishTime;
	}

	public LocalDateTime getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(LocalDateTime refundTime) {
		this.refundTime = refundTime;
	}

	public BigDecimal getExt2Price() {
		return ext2Price;
	}

	public void setExt2Price(BigDecimal ext2Price) {
		this.ext2Price = ext2Price;
	}

	public BigDecimal getExt3Price() {
		return ext3Price;
	}

	public void setExt3Price(BigDecimal ext3Price) {
		this.ext3Price = ext3Price;
	}

	public BigDecimal getExt4Price() {
		return ext4Price;
	}

	public void setExt4Price(BigDecimal ext4Price) {
		this.ext4Price = ext4Price;
	}

	public BigDecimal getExt5Price() {
		return ext5Price;
	}

	public void setExt5Price(BigDecimal ext5Price) {
		this.ext5Price = ext5Price;
	}

	public LocalDateTime getExt2Time() {
		return ext2Time;
	}

	public void setExt2Time(LocalDateTime ext2Time) {
		this.ext2Time = ext2Time;
	}

	public LocalDateTime getExt3Time() {
		return ext3Time;
	}

	public void setExt3Time(LocalDateTime ext3Time) {
		this.ext3Time = ext3Time;
	}

	public LocalDateTime getExt4Time() {
		return ext4Time;
	}

	public void setExt4Time(LocalDateTime ext4Time) {
		this.ext4Time = ext4Time;
	}

	public LocalDateTime getExt5Time() {
		return ext5Time;
	}

	public void setExt5Time(LocalDateTime ext5Time) {
		this.ext5Time = ext5Time;
	}

	public List<AppointmentItem> getAppointmentItems() {
		return appointmentItems;
	}

	public void setAppointmentItems(List<AppointmentItem> appointmentItems) {
		this.appointmentItems = appointmentItems;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDoctorCode() {
		return doctorCode;
	}

	public void setDoctorCode(String doctorCode) {
		this.doctorCode = doctorCode;
	}

	public String getUserDoctorRecomId() {
		return userDoctorRecomId;
	}

	public void setUserDoctorRecomId(String userDoctorRecomId) {
		this.userDoctorRecomId = userDoctorRecomId;
	}

	public String getAdminAreaId() {
		return adminAreaId;
	}

	public void setAdminAreaId(String adminAreaId) {
		this.adminAreaId = adminAreaId;
	}

	public String getUserIdentity() {
		return userIdentity;
	}

	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}

	public int getEscortSex() {
		return escortSex;
	}

	public void setEscortSex(int escortSex) {
		this.escortSex = escortSex;
	}

}
