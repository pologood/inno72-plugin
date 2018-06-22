package com.framelib.dubbo.neworder.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.point72.common.datetime.CustomLocalDateSerializer;
import com.point72.common.datetime.CustomLocalDateTimeSerializer;

public class ContractsBaby implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8174405444086896919L;

	/***/
	private String id;

	/** 来源id */
	@NotNull(message = "无儿童主键")
	private String fromId;

	/**履约订单表主键id*/
	private String contractsId;

	/**宝宝姓名*/
	@NotNull(message = "无儿童姓名")
	private String name;

	/**宝宝性别*/
	@NotNull(message = "无儿童性别")
	private String sex;

	private String babyNamePY;

	/**宝宝生日*/
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	@DateTimeFormat(iso=ISO.DATE)
	@NotNull(message = "无儿童生日")
	private LocalDate birthday;

	/***/
	@NotNull(message = "无儿童家长主键")
	private String parentsId;

	/***/
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	 @DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime createTime;

	/***/
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	 @DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime updateTime;

	private String babyNamePy;

	private String merchantId;

	public String getBabyNamePy() {
		return babyNamePy;
	}

	public void setBabyNamePy(String babyNamePy) {
		this.babyNamePy = babyNamePy;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/***/
	public String getId() {
		return id;
	}

	/***/
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	/**履约订单表主键id*/
	public String getContractsId() {
		return contractsId;
	}

	/**履约订单表主键id*/
	public void setContractsId(String contractsId) {
		this.contractsId = contractsId == null ? null : contractsId.trim();
	}

	/**宝宝姓名*/
	public String getName() {
		return name;
	}

	/**宝宝姓名*/
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**宝宝性别*/
	public String getSex() {
		return sex;
	}

	/**宝宝性别*/
	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	/**宝宝生日*/
	public LocalDate getBirthday() {
		return birthday;
	}

	/**宝宝生日*/
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	/***/
	public String getParentsId() {
		return parentsId;
	}

	/***/
	public void setParentsId(String parentsId) {
		this.parentsId = parentsId == null ? null : parentsId.trim();
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

	public String getBabyNamePY() {
		return babyNamePY;
	}

	public void setBabyNamePY(String babyNamePY) {
		this.babyNamePY = babyNamePY;
	}


}