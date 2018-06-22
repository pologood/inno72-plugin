package com.framelib.dubbo.neworder.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.point72.common.datetime.CustomLocalDateSerializer;
import com.point72.common.datetime.CustomLocalDateTimeSerializer;
import com.point72.common.datetime.CustomLocalTimeSerializer;

public class ContractsOrder implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4412957135065943787L;

	/***/
	private String id;

	/**合约单订单号*/
	private String orderNum;

	/**合约单状态*/
	private Integer status;

	public enum OrderStatus{

		CANCEL(0,"取消"),
		FINISH(1,"报告已上传完成"),
		WAIT_CLASSES(2,"待排班"),
		WAIT_ACTION(3,"待履约"),
		WAIT_USERINCAR(4,"待用户上车"),
		START(5,"开始履约"),
		WAIT_THIRD_REPORT(8,"待第三方上传报告"),
		WAIT_UPREPORT(6,"待上传报告");

		private int status;

		private String desc;

		public static Map<Integer, Object> getAllStatus(){
			OrderStatus[] values = OrderStatus.values();
			Map<Integer, Object> map = new HashMap<>();
			for (int i = 0; i < values.length; i++) {
				OrderStatus orderStatus = values[i];
				int status2 = orderStatus.getStatus();
				String desc2 = orderStatus.getDesc();
				map.put(status2, desc2);
			}
			return map;

		}

		OrderStatus(int status, String desc) {
			this.status = status;
			this.desc = desc;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**班次id*/
	private String classesId;
	
	/**班次num*/
	private String classesNum;

	/**班次名称*/
	private String classesName;

	/**班次预约日期*/
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate classesDate;

	/**预约开始时间*/
	@JsonSerialize(using = CustomLocalTimeSerializer.class)
	@DateTimeFormat(iso=ISO.TIME)
	private LocalTime startTime;

	/**预约结束时间*/
	@JsonSerialize(using = CustomLocalTimeSerializer.class)
	@DateTimeFormat(iso=ISO.TIME)
	private LocalTime endTime;

	/**服务时长*/
	private Integer serviceDuration;

	/**家长id*/
	private String parentsId;

	/**家长姓名*/
	private String parentsName;

	/**家长电话，关联查询结果*/
	private String parentsPhone;
	
	/**
	 * 陪护人id
	 */
	private String escortId;

	/**陪护人手机号*/
	private String escortMobile;

	/**陪护人姓名*/
	private String escortName;

	/**陪护人身份*/
	private String escortIdentity;

	/***/
	private String babyId;

	/***/
	private String babyName;

	/**宝宝生日*/
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate babyBirthday;

	/**宝宝性别*/
	private String babySex;

	/***/
	private String areaCode;

	/***/
	private String cityCode;

	/***/
	private String address;

	/***/
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime createTime;

	/***/
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime updateTime;

	/**用户名（id）*/
	private String created;

	private String babyNamePY;

	/**备注*/
	private String remark;

	private Integer includeCarPrice;

	private String merchantId;

	private String merchantName;

	private String carId;

	private Integer allotStatus;

	public Integer getAllotStatus() {
		return allotStatus;
	}

	public void setAllotStatus(Integer allotStatus) {
		this.allotStatus = allotStatus;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getClassesNum() {
		return classesNum;
	}


	public void setClassesNum(String classesNum) {
		this.classesNum = classesNum;
	}


	public String getBabyNamePY() {
		return babyNamePY;
	}


	public void setBabyNamePY(String babyNamePY) {
		this.babyNamePY = babyNamePY;
	}


	/***/
	public String getId() {
		return id;
	}


	/***/
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	/**合约单订单号*/
	public String getOrderNum() {
		return orderNum;
	}

	/**合约单订单号*/
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum == null ? null : orderNum.trim();
	}

	/**合约单状态*/
	public Integer getStatus() {
		return status;
	}

	/**合约单状态*/
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**班次id*/
	public String getClassesId() {
		return classesId;
	}

	/**班次id*/
	public void setClassesId(String classesId) {
		this.classesId = classesId == null ? null : classesId.trim();
	}

	/**班次名称*/
	public String getClassesName() {
		return classesName;
	}

	/**班次名称*/
	public void setClassesName(String classesName) {
		this.classesName = classesName == null ? null : classesName.trim();
	}

	/**班次预约日期*/
	public LocalDate getClassesDate() {
		return classesDate;
	}

	/**班次预约日期*/
	public void setClassesDate(LocalDate classesDate) {
		this.classesDate = classesDate;
	}

	/**预约开始时间*/
	public LocalTime getStartTime() {
		return startTime;
	}

	/**预约开始时间*/
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	/**预约结束时间*/
	public LocalTime getEndTime() {
		return endTime;
	}

	/**预约结束时间*/
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	/**服务时长*/
	public Integer getServiceDuration() {
		return serviceDuration;
	}

	/**服务时长*/
	public void setServiceDuration(Integer serviceDuration) {
		this.serviceDuration = serviceDuration;
	}

	/**家长id*/
	public String getParentsId() {
		return parentsId;
	}

	/**家长id*/
	public void setParentsId(String parentsId) {
		this.parentsId = parentsId == null ? null : parentsId.trim();
	}

	/**家长姓名*/
	public String getParentsName() {
		return parentsName;
	}

	/**家长姓名*/
	public void setParentsName(String parentsName) {
		this.parentsName = parentsName == null ? null : parentsName.trim();
	}
	
	public String getParentsPhone() {
		return parentsPhone;
	}


	public void setParentsPhone(String parentsPhone) {
		this.parentsPhone = parentsPhone;
	}


	/**陪护人手机号*/
	public String getEscortMobile() {
		return escortMobile;
	}

	/**陪护人手机号*/
	public void setEscortMobile(String escortMobile) {
		this.escortMobile = escortMobile == null ? null : escortMobile.trim();
	}

	/**陪护人姓名*/
	public String getEscortName() {
		return escortName;
	}

	/**陪护人姓名*/
	public void setEscortName(String escortName) {
		this.escortName = escortName == null ? null : escortName.trim();
	}

	/**陪护人身份*/
	public String getEscortIdentity() {
		return escortIdentity;
	}

	/**陪护人身份*/
	public void setEscortIdentity(String escortIdentity) {
		this.escortIdentity = escortIdentity == null ? null : escortIdentity.trim();
	}

	/***/
	public String getBabyId() {
		return babyId;
	}

	/***/
	public void setBabyId(String babyId) {
		this.babyId = babyId == null ? null : babyId.trim();
	}

	/***/
	public String getBabyName() {
		return babyName;
	}

	/***/
	public void setBabyName(String babyName) {
		this.babyName = babyName == null ? null : babyName.trim();
	}

	/**宝宝生日*/
	public LocalDate getBabyBirthday() {
		return babyBirthday;
	}

	/**宝宝生日*/
	public void setBabyBirthday(LocalDate babyBirthday) {
		this.babyBirthday = babyBirthday;
	}

	/**宝宝性别*/
	public String getBabySex() {
		return babySex;
	}

	/**宝宝性别*/
	public void setBabySex(String babySex) {
		this.babySex = babySex == null ? null : babySex.trim();
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/***/
	public String getCityCode() {
		return cityCode;
	}

	/***/
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode == null ? null : cityCode.trim();
	}

	/***/
	public String getAddress() {
		return address;
	}

	/***/
	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	/***/
	public LocalDateTime getCreateTime() {
		return createTime;
	}

	/***/
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	/***/
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	/***/
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	/**用户名（id）*/
	public String getCreated() {
		return created;
	}

	/**用户名（id）*/
	public void setCreated(String created) {
		this.created = created == null ? null : created.trim();
	}

	/**备注*/
	public String getRemark() {
		return remark;
	}

	public String getEscortId() {
		return escortId;
	}


	public void setEscortId(String escortId) {
		this.escortId = escortId;
	}


	/**备注*/
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}


	public Integer getIncludeCarPrice() {
		return includeCarPrice;
	}


	public void setIncludeCarPrice(Integer includeCarPrice) {
		this.includeCarPrice = includeCarPrice;
	}



}