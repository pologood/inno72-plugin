package com.framelib.dubbo.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PkgGoodsVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String goodsId;
	private String goodsName;
	private Integer goodsType;
	private Integer sku;
	private Integer code;
	private String skuCode;
	private BigDecimal price;// 商品原价
	private String remark;
	private String sellPoint;
	private Integer goodsClassify;
	private String goodsProperty;
	private String behave;
	private BigDecimal discount;// 商品折扣
	private String goodsServiceType;// 1服务 2商品
	private BigDecimal discountPrice;// 折扣后价格

	private String userDoctorRecomGoodsId;

	private LocalDateTime finishTime;
	@JsonIgnore
	private String serviceItemInfo;
	@JsonIgnore
	private String goodsOptions;
	@JsonIgnore
	private List<PkgGoodsVo> appointmentItems;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public Integer getSku() {
		return sku;
	}

	public void setSku(Integer sku) {
		this.sku = sku;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public Integer getGoodsClassify() {
		return goodsClassify;
	}

	public void setGoodsClassify(Integer goodsClassify) {
		this.goodsClassify = goodsClassify;
	}

	public String getGoodsProperty() {
		return goodsProperty;
	}

	public void setGoodsProperty(String goodsProperty) {
		this.goodsProperty = goodsProperty;
	}

	public String getBehave() {
		return behave;
	}

	public void setBehave(String behave) {
		this.behave = behave;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getGoodsServiceType() {
		return goodsServiceType;
	}

	public void setGoodsServiceType(String goodsServiceType) {
		this.goodsServiceType = goodsServiceType;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getUserDoctorRecomGoodsId() {
		return userDoctorRecomGoodsId;
	}

	public void setUserDoctorRecomGoodsId(String userDoctorRecomGoodsId) {
		this.userDoctorRecomGoodsId = userDoctorRecomGoodsId;
	}

	public LocalDateTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalDateTime finishTime) {
		this.finishTime = finishTime;
	}

	public String getServiceItemInfo() {
		return serviceItemInfo;
	}

	public void setServiceItemInfo(String serviceItemInfo) {
		this.serviceItemInfo = serviceItemInfo;
	}

	public String getGoodsOptions() {
		return goodsOptions;
	}

	public void setGoodsOptions(String goodsOptions) {
		this.goodsOptions = goodsOptions;
	}

	public List<PkgGoodsVo> getAppointmentItems() {
		return appointmentItems;
	}

	public void setAppointmentItems(List<PkgGoodsVo> appointmentItems) {
		this.appointmentItems = appointmentItems;
	}

}
