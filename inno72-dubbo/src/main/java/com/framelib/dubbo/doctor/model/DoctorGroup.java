package com.framelib.dubbo.doctor.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.inno72.common.datetime.CustomLocalDateTimeSerializer;

/**
 * 医生分组信息
 * 
 * @author zhouzengbao
 *
 */
public class DoctorGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4172854424339101338L;

	/**
	 * 主键id
	 */
	private Integer id;

	/**
	 * 层级
	 */
	private String hierarchy;

	/**
	 * 医生父id
	 */
	private Integer parentId;

	/**
	 * 分组名称 默认为组长名字加“组”
	 */
	private String groupName;

	/**
	 * 医生id
	 */
	private Integer doctorId;

	/**
	 * 医生姓名
	 */
	private String doctorName;

	/**
	 * 分组描述
	 */
	private String description;

	/**
	 * 负责人
	 */
	private Integer functionary;

	/**
	 * 状态 {@link com.framelib.dubbo.doctor.DoctorGroupStatus.java}
	 */
	private Integer status;

	/**
	 * 状态 {@link com.framelib.dubbo.doctor.DoctorGroupType.java}
	 */
	private Integer type;

	/**
	 * 创建日期
	 */
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime createTime;

	/**
	 * 最后更新日期
	 */
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime updateTime;

	/**
	 * 最后操作人id
	 */
	private String optionId;

	/**
	 * 最后操作人姓名
	 */
	private String optionName;
	/**
	 * 医生状态——医生组详情显示用
	 */
	private Integer doctorStatus;

	public Integer getDoctorStatus() {
		return doctorStatus;
	}

	public void setDoctorStatus(Integer doctorStatus) {
		this.doctorStatus = doctorStatus;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(String hierarchy) {
		this.hierarchy = hierarchy == null ? null : hierarchy.trim();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName == null ? null : groupName.trim();
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName == null ? null : doctorName.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getFunctionary() {
		return functionary;
	}

	public void setFunctionary(Integer functionary) {
		this.functionary = functionary;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId == null ? null : optionId.trim();
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName == null ? null : optionName.trim();
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(DoctorGroup.class, ToStringStyle.DEFAULT_STYLE);
	}
}