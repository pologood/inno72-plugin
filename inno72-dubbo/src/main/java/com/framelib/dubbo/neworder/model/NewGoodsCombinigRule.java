package com.framelib.dubbo.neworder.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.framelib.dubbo.model.BaseModel;
import com.inno72.common.datetime.CustomLocalDateTimeSerializer;

public class NewGoodsCombinigRule extends BaseModel{
	 /**
		 * 
		 */
	private static final long serialVersionUID = -7467488189478056217L;
    /**主键组合规则id*/
    private String id;

    /**组合规则code*/
    private String code;

    /**组合规则名称*/
    private String name;

    /**简介*/
    private String info;

    /**可售卖医生组*/
    private Integer doctorGroupId;

    /**组合折扣*/
    private Integer discount;

    /**分类标签*/
    private String tags;

    /**组合价格*/
    private BigDecimal price;

    /**折后价格*/
    private BigDecimal totalPrice;

    /**可售状态*/
    private Byte sellState;

    /**备注*/
    private String remarks;

    /**创建者*/
    private String creator;

    /**更新者*/
    private String updater;

    /**创建时间*/
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createTime;

    /**更新时间*/
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updateTime;

    /***/
    private Integer ext1Int;

    /***/
    private Integer ext2Int;

    /***/
    private Integer ext3Int;

    /***/
    private String ext1Txt;

    /***/
    private String ext2Txt;

    /***/
    private String ext3Txt;

    /***/
    private BigDecimal ext1Price;

    /***/
    private BigDecimal ext2Price;

    /***/
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime ext1Time;

    /***/
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime ext2Time;

    /**主键组合规则id*/
    public String getId() {
        return id;
    }

    /**主键组合规则id*/
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**组合规则code*/
    public String getCode() {
        return code;
    }

    /**组合规则code*/
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**组合规则名称*/
    public String getName() {
        return name;
    }

    /**组合规则名称*/
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**简介*/
    public String getInfo() {
        return info;
    }

    /**简介*/
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**可售卖医生组*/
    public Integer getDoctorGroupId() {
        return doctorGroupId;
    }

    /**可售卖医生组*/
    public void setDoctorGroupId(Integer doctorGroupId) {
        this.doctorGroupId = doctorGroupId;
    }

    /**组合折扣*/
    public Integer getDiscount() {
        return discount;
    }

    /**组合折扣*/
    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    /**分类标签*/
    public String getTags() {
        return tags;
    }

    /**分类标签*/
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**组合价格*/
    public BigDecimal getPrice() {
        return price;
    }

    /**组合价格*/
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**折后价格*/
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**折后价格*/
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**可售状态*/
    public Byte getSellState() {
        return sellState;
    }

    /**可售状态*/
    public void setSellState(Byte sellState) {
        this.sellState = sellState;
    }

    /**备注*/
    public String getRemarks() {
        return remarks;
    }

    /**备注*/
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**创建者*/
    public String getCreator() {
        return creator;
    }

    /**创建者*/
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**更新者*/
    public String getUpdater() {
        return updater;
    }

    /**更新者*/
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**创建时间*/
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    /**创建时间*/
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    /**更新时间*/
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    /**更新时间*/
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    /***/
    public Integer getExt1Int() {
        return ext1Int;
    }

    /***/
    public void setExt1Int(Integer ext1Int) {
        this.ext1Int = ext1Int;
    }

    /***/
    public Integer getExt2Int() {
        return ext2Int;
    }

    /***/
    public void setExt2Int(Integer ext2Int) {
        this.ext2Int = ext2Int;
    }

    /***/
    public Integer getExt3Int() {
        return ext3Int;
    }

    /***/
    public void setExt3Int(Integer ext3Int) {
        this.ext3Int = ext3Int;
    }

    /***/
    public String getExt1Txt() {
        return ext1Txt;
    }

    /***/
    public void setExt1Txt(String ext1Txt) {
        this.ext1Txt = ext1Txt == null ? null : ext1Txt.trim();
    }

    /***/
    public String getExt2Txt() {
        return ext2Txt;
    }

    /***/
    public void setExt2Txt(String ext2Txt) {
        this.ext2Txt = ext2Txt == null ? null : ext2Txt.trim();
    }

    /***/
    public String getExt3Txt() {
        return ext3Txt;
    }

    /***/
    public void setExt3Txt(String ext3Txt) {
        this.ext3Txt = ext3Txt == null ? null : ext3Txt.trim();
    }

    /***/
    public BigDecimal getExt1Price() {
        return ext1Price;
    }

    /***/
    public void setExt1Price(BigDecimal ext1Price) {
        this.ext1Price = ext1Price;
    }

    /***/
    public BigDecimal getExt2Price() {
        return ext2Price;
    }

    /***/
    public void setExt2Price(BigDecimal ext2Price) {
        this.ext2Price = ext2Price;
    }

    /***/
    public LocalDateTime getExt1Time() {
        return ext1Time;
    }

    /***/
    public void setExt1Time(LocalDateTime ext1Time) {
        this.ext1Time = ext1Time;
    }

    /***/
    public LocalDateTime getExt2Time() {
        return ext2Time;
    }

    /***/
    public void setExt2Time(LocalDateTime ext2Time) {
        this.ext2Time = ext2Time;
    }
}