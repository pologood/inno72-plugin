package com.framelib.dubbo.doctor.model;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.framelib.dubbo.model.BaseModel;
import com.point72.common.datetime.CustomLocalDateTimeSerializer;

/**
 * 医生 销售关联表
 */
public class DoctorSaleBinding extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = -5290878177278839443L;

	/** 自增主键 */
	private Integer id;
    /** 医生id */
    private Integer doctorId;
    /** 销售id */
    private String saleId;
    /** 销售姓名 */
    private String saleName;
    /** 状态 0-分配未绑定、1-绑定成功、2-解绑 */
    private Integer status;
    /** 创建时间 */
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @DateTimeFormat(iso=ISO.DATE_TIME)
    private LocalDateTime createtime;

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

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId == null ? null : saleId.trim();
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName == null ? null : saleName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public LocalDateTime getCreatetime() {
		return createtime;
	}

	public void setCreatetime(LocalDateTime createtime) {
		this.createtime = createtime;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }

}