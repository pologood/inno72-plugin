package com.framelib.dubbo.neworder.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.point72.common.datetime.CustomLocalDateSerializer;
import com.point72.common.datetime.CustomLocalDateTimeSerializer;
import com.point72.common.datetime.CustomLocalTimeSerializer;

public class CarClassesAppointment implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3642346760705278955L;

	/***/
    private String id;
    
    private String orderNum;

    /**班次主键*/
    private String classesId;

    /**班次名称*/
    private String classesName;

    /**预约日期*/
    @JsonSerialize(using = CustomLocalDateSerializer.class)
	@DateTimeFormat(iso=ISO.DATE)
    private LocalDate classesDate;

    /**预约时间开始  如：09:00*/
    @JsonSerialize(using = CustomLocalTimeSerializer.class)
	@DateTimeFormat(iso=ISO.TIME)
    private LocalTime startTime;

    /**预约解释时间*/
    @JsonSerialize(using = CustomLocalTimeSerializer.class)
	@DateTimeFormat(iso=ISO.TIME)
    private LocalTime endTime;

    /**状态 0：失效；1：正常*/
    private Integer status;
    
    /**  省份code */
    private String provinceCode;
    
    /** 省名称 */
    private String provinceName;
    
    /**城市代码*/
    private String cityCode;
    
    /**城市名称*/
    private String cityName;

    /**区code*/
    private String areaCode;
    
    /**区名称*/
    private String areaName;

    /**经度*/
    private String longitude;

    /**纬度*/
    private String latitude;

    /**地图标记地点*/
    private String mapAddress;

    /**预约地址*/
    private String address;

    /**创建时间*/
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @DateTimeFormat(iso=ISO.DATE_TIME)
    private LocalDateTime createTime;

    /**创建人id*/
    private String createdId;

    /**创建人姓名*/
    private String createdName;
    
    
    public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/***/
    public String getId() {
        return id;
    }

    /***/
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**班次主键*/
    public String getClassesId() {
        return classesId;
    }

    /**班次主键*/
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

    /**预约日期*/
    public LocalDate getClassesDate() {
        return classesDate;
    }

    /**预约日期*/
    public void setClassesDate(LocalDate classesDate) {
        this.classesDate = classesDate;
    }

    /**预约时间开始  如：09:00*/
    public LocalTime getStartTime() {
        return startTime;
    }

    /**预约时间开始  如：09:00*/
    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    /**预约解释时间*/
    public LocalTime getEndTime() {
        return endTime;
    }

    /**预约解释时间*/
    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    /**状态 0：失效；1：正常*/
    public Integer getStatus() {
        return status;
    }

    /**状态 0：失效；1：正常*/
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**城市代码*/
    public String getCityCode() {
        return cityCode;
    }

    /**城市代码*/
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    /**城市名称*/
    public String getCityName() {
        return cityName;
    }

    /**城市名称*/
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**预约地址*/
    public String getAddress() {
        return address;
    }
    
    /**经度*/
    public String getLongitude() {
        return longitude;
    }

    /**经度*/
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**纬度*/
    public String getLatitude() {
        return latitude;
    }

    /**纬度*/
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    /**地图标记地点*/
    public String getMapAddress() {
        return mapAddress;
    }

    /**地图标记地点*/
    public void setMapAddress(String mapAddress) {
        this.mapAddress = mapAddress == null ? null : mapAddress.trim();
    }

    /**预约地址*/
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**创建时间*/
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**创建时间*/
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**创建人id*/
    public String getCreatedId() {
        return createdId;
    }

    /**创建人id*/
    public void setCreatedId(String createdId) {
        this.createdId = createdId == null ? null : createdId.trim();
    }

    /**创建人姓名*/
    public String getCreatedName() {
        return createdName;
    }

    /**创建人姓名*/
    public void setCreatedName(String createdName) {
        this.createdName = createdName == null ? null : createdName.trim();
    }
}