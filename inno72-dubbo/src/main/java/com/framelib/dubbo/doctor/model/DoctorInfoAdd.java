package com.framelib.dubbo.doctor.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.framelib.dubbo.model.BaseModel;
import com.inno72.common.datetime.CustomLocalDateSerializer;
import com.inno72.common.datetime.CustomLocalDateTimeSerializer;
import com.inno72.common.utils.StringUtil;


/**
 * 医生附表 mysql
 */
public class DoctorInfoAdd extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = -9176308564952095795L;

	private Integer id;
    /** doctorInfo Id */
    private Integer doctorId;
    /** 职业资格证主页 */
    private String occupationA;
    /** 职业资格证副页 */
    private String occupationB;
    /** 医生执业证主页 */
    private String charteredA;
    /** 医生执业证副页 */
    private String charteredB;
    /** 专业资格证 */
    private String profession;
    /** 其他证书 */
    private String otherCertificate;
    /** 执业单位 */
    private String charteredUnit;
    /** 执业城市 */
    private String charteredCity;
    /** 执业地址 */
    private String charteredAddress;
    /** 执业日期 */
    @JsonSerialize(using = CustomLocalDateSerializer.class)
    @DateTimeFormat(iso=ISO.DATE)
    private LocalDate charteredDate;
    /** 单位类型 */
    private String unitType;
    /** 单位级别 */
    private String unitGrade;
    /** 儿保医生编码 */
    private String childDoctorCode;
    /** 送审时间 */
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @DateTimeFormat(iso=ISO.DATE_TIME)
    private LocalDateTime submited;
    /** 审核者 */
    private String confirmer;
    /** 审核日期 */
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @DateTimeFormat(iso=ISO.DATE_TIME)
    private LocalDateTime confirmed;
    /** 审核备注详情 */
    private String confirmedRemark;
    /** 审核人id */
    private String confirmerId;
    /** 设备号 */
    private String deviceNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getOccupationA() {
        return occupationA;
    }

    public void setOccupationA(String occupationA) {
        this.occupationA = occupationA == null ? null : occupationA.trim();
    }

    public String getOccupationB() {
        return occupationB;
    }

    public void setOccupationB(String occupationB) {
        this.occupationB = occupationB == null ? null : occupationB.trim();
    }

    public String getCharteredA() {
        return charteredA;
    }

    public void setCharteredA(String charteredA) {
        this.charteredA = charteredA == null ? null : charteredA.trim();
    }

    public String getCharteredB() {
        return charteredB;
    }

    public void setCharteredB(String charteredB) {
        this.charteredB = charteredB == null ? null : charteredB.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public String getCharteredUnit() {
        return charteredUnit;
    }

    public void setCharteredUnit(String charteredUnit) {
        this.charteredUnit = charteredUnit == null ? null : charteredUnit.trim();
    }

    public String getCharteredCity() {
        return charteredCity;
    }

    public void setCharteredCity(String charteredCity) {
        this.charteredCity = charteredCity == null ? null : charteredCity.trim();
    }

    public String getCharteredAddress() {
        return charteredAddress;
    }

    public void setCharteredAddress(String charteredAddress) {
        this.charteredAddress = charteredAddress == null ? null : charteredAddress.trim();
    }

    public LocalDate getCharteredDate() {
        return charteredDate;
    }

    public void setCharteredDate(LocalDate charteredDate) {
        this.charteredDate = charteredDate;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType == null ? null : unitType.trim();
    }

    public String getUnitGrade() {
        return unitGrade;
    }

    public void setUnitGrade(String unitGrade) {
        this.unitGrade = unitGrade == null ? null : unitGrade.trim();
    }

    public String getChildDoctorCode() {
        return childDoctorCode;
    }

    public void setChildDoctorCode(String childDoctorCode) {
        this.childDoctorCode = childDoctorCode;
    }

    public LocalDateTime getSubmited() {
        return submited;
    }

    public void setSubmited(LocalDateTime submited) {
        this.submited = submited;
    }

    public String getConfirmer() {
        return confirmer;
    }

    public void setConfirmer(String confirmer) {
        this.confirmer = confirmer == null ? null : confirmer.trim();
    }

    public LocalDateTime getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(LocalDateTime confirmed) {
        this.confirmed = confirmed;
    }
    
	public String getConfirmedRemark() {
		return confirmedRemark;
	}

	public void setConfirmedRemark(String confirmedRemark) {
		this.confirmedRemark = confirmedRemark;
	}
	
	public String getConfirmerId() {
		return confirmerId;
	}

	public void setConfirmerId(String confirmerId) {
		this.confirmerId = confirmerId;
	}

	
	public String getDeviceNumber() {
		return deviceNumber;
	}

	public void setDeviceNumber(String deviceNumber) {
		this.deviceNumber = deviceNumber;
	}
	
	public String getCharteredDateStr(){
		if (StringUtil.isEmpty(this.charteredDate)){
			return "";
		}
		int year = LocalDate.now().getYear();
		int year2 = charteredDate.getYear();
		return year-year2+"";
	}
	
	public String getOtherCertificate() {
		return otherCertificate;
	}

	public void setOtherCertificate(String otherCertificate) {
		this.otherCertificate = otherCertificate;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
	}
    
    
}