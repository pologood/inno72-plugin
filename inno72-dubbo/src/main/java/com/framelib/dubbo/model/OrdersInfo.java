package com.framelib.dubbo.model;

import java.math.BigDecimal;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class OrdersInfo extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2232201144848076845L;

	/**
	 * 商品类型枚举 Title: Description:
	 * 
	 * @Create_by: Houkemian
	 * @Create_date: 2016年11月15日
	 * @Last_Edit_By: Edit_description:
	 * @version: PMP
	 */
	public enum Goods_Type {
		// 速诊
		FAST(10),
		// 速诊
		FASTAPPEND(11),
		// 儿保扫码项目
		PKG_SELFITEM(21),
		// 儿保车上加项
		PKG_ADDITION(22),
		// 新生儿项目
		NEWBORN(30),
		// 家庭医生问诊
		FAMILY(50);

		private int v;

		private Goods_Type(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}
	}

	/**
	 * 商品描述枚举 Title: Description:
	 * 
	 * @Create_by: Houkemian
	 * @Create_date: 2016年11月15日
	 * @Last_Edit_By: Edit_description:
	 * @version: PMP
	 */
	public enum Goods_Desc {
		// 速诊
		FAST("速诊"),
		// 速诊追问
		FASTAPPEND("速诊追问"),
		// 儿保订单
		PKG_SELFITEM("儿保扫码项目"),
		// 儿保订单
		PKG_ADDITION("儿保车上加项"),
		// 儿保订单
		NEWBORN("新生儿项目"),
		// 家庭医生问诊
		FAMILY("家庭医生问诊");

		private String v;

		private Goods_Desc(String v) {
			this.v = v;
		}

		public String v() {
			return this.v;
		}
	}

	/**
	 * 
	 * @param info
	 *            存放订单详细信息
	 * @param goodsType
	 * @param goodsPrice
	 */
	public OrdersInfo(Map<String, Object> info, Goods_Type goodsType, Goods_Desc goodsDesc, BigDecimal goodsPrice) {
		this.info = JSON.toJSONString(info);
		this.goodsType = goodsType.v;
		this.goodsPrice = goodsPrice;
		this.goodsDesc = goodsDesc.v;
	}

	public OrdersInfo() {
	}

	private String id;
	private String orderId;
	private String orderNum;
	private BigDecimal goodsPrice;
	private BigDecimal ext1Price;
	private BigDecimal ext2Price;
	private BigDecimal ext3Price;
	private Integer goodsType;
	private String goodsDesc;
	private String goodsId;

	/** {@link OrdersInfo info} keys 
		{@link String} illness;//病症文字描述
		{@link List<String>} imgs;//病症图片
		{@link String} remark;//用户备注
		{@link String} doctorAdvice;//医嘱休息
		{@link String} doctorAdviceTime;//医嘱提交时间
		{@link String} outpatientType;//门诊类型 1 立即 2 预约 
		{@link String} deptId;
		{@link String} deptName;
		{@link Integer} serviceTime
		{@link NewGoodsCombinigRule} group
		{@link List<NewGoodsCombinigService>} bind
		{@link NewGoodsServiceItem} service
	 */
	private String info;

	private Integer isDel;
	//服务时长
	private Integer serviceTime;
	
	private String deptId;
	
	private String deptName;
	
	

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(Integer serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId == null ? null : orderId.trim();
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum == null ? null : orderNum.trim();
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getExt1Price() {
		return ext1Price;
	}

	public void setExt1Price(BigDecimal ext1Price) {
		this.ext1Price = ext1Price;
	}

	public BigDecimal getExt2Price() {
		return ext2Price;
	}

	public void setExt2Price(BigDecimal ext2Price) {
		this.ext2Price = ext2Price;
	}

	public BigDecimal getExt3Price() {
		return ext3Price;
	}

	public void setExt3Price(BigDecimal ext3Price) {
		this.ext3Price = ext3Price;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc == null ? null : goodsDesc.trim();
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}
}