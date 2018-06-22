package com.framelib.dubbo.neworder.model;

import java.util.Date;

import com.framelib.dubbo.model.BaseModel;

public class NewGoodsCombinigService extends BaseModel{
	private static final long serialVersionUID = 5388605597314788553L;
    /**主键id*/
    private String id;

    /**组合项规则id*/
    private String combinigRuleId;

    /**服务项id*/
    private String serviceId;

    /**是否必须0非必需，1必须*/
    private Integer required;

    /**排序*/
    private Integer order;

    /**创建者*/
    private String creator;

    /**创建时间*/
    private Date createTime;

    /**主键id*/
    public String getId() {
        return id;
    }

    /**主键id*/
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**组合项规则id*/
    public String getCombinigRuleId() {
        return combinigRuleId;
    }

    /**组合项规则id*/
    public void setCombinigRuleId(String combinigRuleId) {
        this.combinigRuleId = combinigRuleId == null ? null : combinigRuleId.trim();
    }

    /**服务项id*/
    public String getServiceId() {
        return serviceId;
    }

    /**服务项id*/
    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    /**是否必须0非必需，1必须*/
    public Integer getRequired() {
        return required;
    }

    /**是否必须0非必需，1必须*/
    public void setRequired(Integer required) {
        this.required = required;
    }

    /**排序*/
    public Integer getOrder() {
        return order;
    }

    /**排序*/
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**创建者*/
    public String getCreator() {
        return creator;
    }

    /**创建者*/
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**创建时间*/
    public Date getCreateTime() {
        return createTime;
    }

    /**创建时间*/
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}