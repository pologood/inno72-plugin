package com.framelib.dubbo.neworder.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.inno72.common.datetime.CustomLocalDateSerializer;

public class CarClasses implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -356637430478144952L;

	/***/
    private String id;

    /**班次*/
    private String classesName;

    /***/
    @JsonSerialize(using = CustomLocalDateSerializer.class)
	@DateTimeFormat(iso=ISO.DATE)
    private LocalDate classesDate;

    /**班次可用状态 0:失效；1:正常；*/
    private Integer status;

    /***/
    private LocalDateTime createTime;

    /**创建人姓名（id）*/
    private String created;

    /***/
    public String getId() {
        return id;
    }

    /***/
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**班次*/
    public String getClassesName() {
        return classesName;
    }

    /**班次*/
    public void setClassesName(String classesName) {
        this.classesName = classesName == null ? null : classesName.trim();
    }

    /***/
    public LocalDate getClassesDate() {
        return classesDate;
    }

    /***/
    public void setClassesDate(LocalDate classesDate) {
        this.classesDate = classesDate;
    }

    /**班次可用状态 0:失效；1:正常；*/
    public Integer getStatus() {
        return status;
    }

    /**班次可用状态 0:失效；1:正常；*/
    public void setStatus(Integer status) {
        this.status = status;
    }

    /***/
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /***/
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**创建人姓名（id）*/
    public String getCreated() {
        return created;
    }

    /**创建人姓名（id）*/
    public void setCreated(String created) {
        this.created = created == null ? null : created.trim();
    }
}