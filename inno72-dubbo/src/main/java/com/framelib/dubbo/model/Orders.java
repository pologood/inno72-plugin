package com.framelib.dubbo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.framelib.dubbo.neworder.model.ContractsBaby;
import com.inno72.common.datetime.CustomLocalDateTimeSerializer;
import org.apache.commons.lang3.StringUtils;

public class Orders extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 63499460668340958L;


	public enum New_Order_Enum{
		// 取消
		CANCEL(0,"取消"),
		//已支付 门诊待接诊 ；儿保 已支付 ，已完成
		PAY(1,"已支付"),
		//预定            ；儿保 已预订 待排班
		BOOK(2,"预定"),
		//待履约          ；儿保 已排版 待履约
		WAIT_ACTION(3,"待履约"),
		//待支付 ； 儿保 已履约 待支付
		WAIT_PAY(4,"待支付"),
		//审核通过 门诊已完成 ；
		FINASH(8,"已完成");

		private int v;

		private String t;

		private New_Order_Enum(int v, String t) {
			this.v = v;
			this.t = t;
		}

		public int v() {
			return this.v;
		}
		public String t() {
			return this.t;
		}

		public static New_Order_Enum get(int v) {
			for (New_Order_Enum c : New_Order_Enum.values()) {
				if (c.v == v) {
					return c;
				}
			}
			return null;
		}

	}

	/**
	 * 速诊订单状态枚举 Title: Description:
	 * 
	 * @Create_by: Houkemian
	 * @Create_date: 2016年11月15日
	 * @Last_Edit_By: Edit_description:
	 * @version: PMP
	 */
	public enum Fast_Order_Status {
		// 取消
		CANCEL(0),
		// 未接诊
		UNRECEIVE(1),
		// 已接诊
		RECEIVE(2),
		// 待付款
		WAIT_TO_PAY(6),
		// 退款中
		REFUNDING(7),
		// 已退款
		REFUNDED(8),
		// 已完成
		FINISH(9);

		private int v;

		private Fast_Order_Status(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}

		public static Fast_Order_Status get(int v) {
			for (Fast_Order_Status c : Fast_Order_Status.values()) {
				if (c.v == v) {
					return c;
				}
			}
			return null;
		}
	}

	/**
	 * 儿保订单状态枚举 Title: Description:
	 * 
	 * @Create_by: Houkemian
	 * @Create_date: 2016年11月15日
	 * @Last_Edit_By: Edit_description:
	 * @version: PMP
	 */
	public enum Pkg_Order_Status {
		// 已生成
		CREATE(1),
		// 已取消
		CANCEL(0),
		// 开始履约
		BEGIN_SERVICE(2),
		// 待支付
		WAIT_TO_PAY(3),
		// 支付完成
		PAYED(4),
		// 已完成
		FINISH(9);

		private int v;

		private Pkg_Order_Status(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}
	}

	/**
	 * 儿保订单二级状态枚举 Title: Description:
	 * 
	 * @Create_by: Houkemian
	 * @Create_date: 2016年11月15日
	 * @Last_Edit_By: Edit_description:
	 * @version: PMP
	 */
	public enum Pkg_Business_Status {

		// 无状态
		NULL(0),
		// 待上传报告
		WAIT_UPLOAD(31),
		// 待分配医生
		WAIT_ASSIGN(32),
		// 待解读报告
		WAIT_EAXPLANATION(33),
		// 待全科医生解读报告
		WAIT_SELFDOCTOR_EAXPLANATION(34),
		// 待发送报告
		WAIT_SENDREPORT(35),
		// 发送报告
		SENDREPORT(36);

		private int v;

		private Pkg_Business_Status(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}

	}

	/**
	 * 速诊订单二级状态枚举 Title: Description:
	 * 
	 * @Create_by: Houkemian
	 * @Create_date: 2016年11月15日
	 * @Last_Edit_By: Edit_description:
	 * @version: PMP
	 */
	public enum FAST_Business_Status {

		// 无状态
		NULL(0),

		// 用户取消
		USER_CANCEL(1),
		// 订单改派
		REDIRECT(2),
		// 已接诊未通话
		UNCALL(23),
		// 已接诊已通话
		CALL(24),
		// 已发送医助
		TO_DOCTOR_ASSISTANT(21),
		// 医助转录完毕
		DOCTOR_ASSISTANT_FINISH(22),
		// 医生审核
		DOCTOR_REVIEW(25);

		private int v;

		private FAST_Business_Status(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}

	}

	/**
	 * 订单类型枚举 Title: Description:
	 * 
	 * @Create_by: Houkemian
	 * @Create_date: 2016年11月15日
	 * @Last_Edit_By: Edit_description:
	 * @version: PMP
	 */
	public enum Order_Type {
		//插入默认订单类型，需预先在ordervo -> orders 里设定订单类型
		DEFAULT(00, "默认订单"),
		// 速诊
		FAST(10,"速诊"),
		// 速诊追问
		APPEND(11,"速诊追问"),
		// 儿保合约订单
		PKG(30,"儿保合约订单"),
		//重构新儿保订单
		PKGN(31,"重构新儿保订单"),
		// 儿保解读订单
		PKGN_APPEND(35,"新儿保加项订单"),
		// 儿保解读订单
		UNSCRAMBLE(32,"儿保解读订单"),
		//儿保车费订单
		PKGNCAR(33,"儿保车费订单"),
		//儿保微信订单
		PKGNWECHAT(34,"儿保微信订单"),
		//儿疾出车订单
		FASEDRAWOUT(36, "儿疾出车订单"),
		// 儿保预约单
		PKG_APPOINTMENT(20,"儿保预约单"),
		// 新生儿预约单
		NEWBORN(40,"新生儿预约单"),
		// 家庭医生急诊单
		FAMILY_EM(51,"家庭医生急诊单"),
		// 家庭医生预约单
		FAMILY_APP(52,"家庭医生预约单"),
		//体检卡套餐订单
		CARD_PHYSICAL(60,"体检卡套餐订单"),
		//门诊订单
		OUTPATIENT(70,"门诊订单"),
		
		OUTPATIENT_IMMEDIATE(71,"门诊立即订单"),

		OUTPATIENT_FASEDRAWOUT(72, "儿疾门诊订单");

		private int v;
		private String t;

		private Order_Type(int v,String t) {
			this.v = v;
			this.t = t;
		}

		public int v() {
			return this.v;
		}
		public String t() {
			return t;
		}

	}

	public enum NewBorn_Order_Status {
		// 已取消
		CANCEL(0),
		// 待支付
		WAIT_TO_PAY(1),
		// 待激活
		WAIT_TO_ACTIVE(2),
		// 已激活
		ACTIVATED(3);

		private int v;

		private NewBorn_Order_Status(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}
	}

	public enum NewBorn_Business_Status {

		// 无状态
		NULL(0);

		private int v;

		private NewBorn_Business_Status(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}

	}

	public enum Family_Order_Status {
		// 取消
		CANCEL(0),
		// 待问诊
		UNRECEIVE(1),
		// 已接诊
		RECEIVE(2),
		// 待付款
		WAIT_TO_PAY(3),
		// 退款中
		REFUNDING(7),
		// 已退款
		REFUNDED(8),
		// 已完成
		FINISH(9);

		private int v;

		private Family_Order_Status(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}
	}

	public enum Family_Business_Status {

		// 无状态
		NULL(0),
		// 待填写诊断
		WAIT_TO_DIAGNOSE(21);

		private int v;

		private Family_Business_Status(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}

	}


	/**
	 * 订单支付类型枚举 Title: Description:
	 * 
	 * @Create_by: Houkemian
	 * @Create_date: 2016年11月15日
	 * @Last_Edit_By: Edit_description:
	 * @version: PMP
	 */
	public enum Pay_Type {
		// 微信支付
		WECHAT("wechat"),
		// 支付宝
		ALI("alipay"),
		//线下支付
		BELOW("below"),
		// 空
		NULL("");

		private String v;

		public static Pay_Type getPayTypeByV(String v){
			if (StringUtils.isEmpty(v)){
				return Pay_Type.NULL;
			}
			Pay_Type[] values = Pay_Type.values();
			for ( Pay_Type type : values ){
				if ( type.v.equals(v) ){
					return type;
				}
			}
			return Pay_Type.NULL;
		}

		private Pay_Type(String v) {
			this.v = v;
		}

		public String v() {
			return this.v;
		}
	}

	/**
	 * 挂起状态枚举 Title: Description:
	 * 
	 * @Create_by: Houkemian
	 * @Create_date: 2016年11月15日
	 * @Last_Edit_By: Edit_description:
	 * @version: PMP
	 */
	public enum Hold_Status {
		YES(1), NO(0),;

		private int v;

		private Hold_Status(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}
	}

	private String id;
	// 类型(2位)+timestamp(5位)+年(2位)+月(2位)+来源(2位)+日(2位)+随机数(2位)
	// 类型-10是速诊订单
	// 来源-10是微信下单,20是后台下单
	private String orderNum;
	private String userTelno; // 用户手机号
	private String userId;
	private String performerId; // 患者表ID
	private String performerName;
	private String doctorId;
	private String doctorName;
	private BigDecimal goodsPrice; // 商品价格
	private BigDecimal orderPrice; // 订单价格
	private BigDecimal discountPrice; // 优惠价格
	private BigDecimal payPrice; // 支付金额
	private String payType;

	private Integer orderStatus;
	private Integer businessStatus;
	
	public enum Orders_Business_Status{
		//待履约          ；儿保 已排版 待履约
		WAIT_ACTION(2,"待接诊"),
		//已接诊 门诊待回电 ；
		WAIT_CALLBACK(3,"待回电"),
		//已回电 门诊待填写诊断 ；
		WAIT_DIAGNOSE(4,"待填写诊断"),
		//已填写诊断 门诊待审核 ；
		WAIT_AUDIT(5,"待审核"),
		//审核通过 门诊已完成 ；
		FINASH(1,"已完成"),

		WAIT_PAY(6,"待支付"),

		CANCEL(0,"");

		private int v;

		private String t;

		private Orders_Business_Status(int v, String t) {
			this.v = v;
			this.t = t;
		}

		public int v() {
			return this.v;
		}
		public String t() {
			return this.t;
		}

		public static New_Order_Enum get(int v) {
			for (New_Order_Enum c : New_Order_Enum.values()) {
				if (c.v == v) {
					return c;
				}
			}
			return null;
		}

	}
	private Integer orderType;
	private String orderPid; // 订单关联ID
	private Integer isDel;

	private Integer channel;

	/**
	 * 订单来源枚举 Title: Description:
	 *
	 * @Create_by: Houkemian
	 * @Create_date: 2016年11月15日
	 * @Last_Edit_By: Edit_description:
	 * @version: PMP
	 */
	public enum Order_Source {
		// 微信下单
		WECHAT(10),

		WORK_STATION(40),
		// 后台下单
		PMP(20),
		// 后台改派
		REDIRECT(30),
		//熊掌
		XIONG_ZHANG(50),

		BAIDU(60),
		;

		private int v;

		private Order_Source(int v) {
			this.v = v;
		}

		public int v() {
			return this.v;
		}
	}

	private Integer holdStatus;

	// JSON格式
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	// jpa
	private LocalDateTime orderTime; // 下单时间

	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime payTime; // 支付时间

	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime finishTime; // 结束时间

	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime refundTime; // 退款时间

	private BigDecimal ext1Price; // 折扣
	private BigDecimal ext2Price;
	private BigDecimal ext3Price;
	private BigDecimal ext4Price;
	private BigDecimal ext5Price;

	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime ext1Time;
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime ext2Time;
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime ext3Time;
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime ext4Time;
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime ext5Time;

	private String ext1Str;
	private String ext2Str;
	private String ext3Str;
	private String ext4Str;
	private String ext5Str;

	private String escortId;
	private String escortName;
	private String cityCode;

	private String cityName;

	/**
	 * 状态更新时间
	 */
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime statusUpdateTime;

	/**
	 * 0:老订单，1:新订单
	 */
	private String type;
	public enum TYPE_ENUM{


		OLD("0"),NEW("1");

		private String type;

		private TYPE_ENUM(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}


	}
	/**
	 * 检验报告更新时间
	 */
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	private LocalDateTime reportUpdateTime;




	private List<OrdersInfo> orderInfoList;

	private List<OrdersHistory> orderHistoryList;

	private List<OrdersFile> orderFileList;

	private ContractsBaby baby;

	private String readDoctorId;

	private String readDoctorName;

	private Integer orderTypeMinor;

	private Integer whetherAudit;

	private String outpatientType;

	private String platform;

	private String merchantId;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getOutpatientType() {
		return outpatientType;
	}

	public void setOutpatientType(String outpatientType) {
		this.outpatientType = outpatientType;
	}

	public Integer getOrderTypeMinor() {
		return orderTypeMinor;
	}

	public void setOrderTypeMinor(Integer orderTypeMinor) {
		this.orderTypeMinor = orderTypeMinor;
	}

	public Integer getWhetherAudit() {
		return whetherAudit;
	}

	public void setWhetherAudit(Integer whetherAudit) {
		this.whetherAudit = whetherAudit;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getReadDoctorId() {
		return readDoctorId;
	}

	public void setReadDoctorId(String readDoctorId) {
		this.readDoctorId = readDoctorId;
	}

	public String getReadDoctorName() {
		return readDoctorName;
	}

	public void setReadDoctorName(String readDoctorName) {
		this.readDoctorName = readDoctorName;
	}

	public ContractsBaby getBaby() {
		return baby;
	}

	public void setBaby(ContractsBaby baby) {
		this.baby = baby;
	}

	public List<OrdersFile> getOrderFileList() {
		return orderFileList;
	}

	public void setOrderFileList(List<OrdersFile> orderFileList) {
		this.orderFileList = orderFileList;
	}

	public List<OrdersInfo> getOrderInfoList() {
		return orderInfoList;
	}

	public void setOrderInfoList(List<OrdersInfo> orderInfoList) {
		this.orderInfoList = orderInfoList;
	}

	public List<OrdersHistory> getOrderHistoryList() {
		return orderHistoryList;
	}

	public void setOrderHistoryList(List<OrdersHistory> orderHistoryList) {
		this.orderHistoryList = orderHistoryList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getUserTelno() {
		return userTelno;
	}

	public void setUserTelno(String userTelno) {
		this.userTelno = userTelno;
	}

	public String getPerformerId() {
		return performerId;
	}

	public void setPerformerId(String performerId) {
		this.performerId = performerId;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public BigDecimal getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(BigDecimal orderPrice) {
		this.orderPrice = orderPrice;
	}

	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}

	public BigDecimal getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public LocalDateTime getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(LocalDateTime orderTime) {
		this.orderTime = orderTime;
	}

	public LocalDateTime getPayTime() {
		return payTime;
	}

	public void setPayTime(LocalDateTime payTime) {
		this.payTime = payTime;
	}

	public LocalDateTime getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(LocalDateTime finishTime) {
		this.finishTime = finishTime;
	}

	public LocalDateTime getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(LocalDateTime refundTime) {
		this.refundTime = refundTime;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getBusinessStatus() {
		return businessStatus;
	}

	public void setBusinessStatus(Integer businessStatus) {
		this.businessStatus = businessStatus;
	}

	public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getOrderPid() {
		return orderPid;
	}

	public void setOrderPid(String orderPid) {
		this.orderPid = orderPid;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
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

	public BigDecimal getExt4Price() {
		return ext4Price;
	}

	public void setExt4Price(BigDecimal ext4Price) {
		this.ext4Price = ext4Price;
	}

	public BigDecimal getExt5Price() {
		return ext5Price;
	}

	public void setExt5Price(BigDecimal ext5Price) {
		this.ext5Price = ext5Price;
	}

	public LocalDateTime getExt1Time() {
		return ext1Time;
	}

	public String getExt1Time1() {
		if (ext1Time != null) {
			return ext1Time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		return "";
	}

	public String getExt2Time2() {

		if (ext1Time != null && ext2Time != null) {

			String format = ext1Time.format(DateTimeFormatter.ofPattern("HH:mm"));
			String format2 = ext2Time.format(DateTimeFormatter.ofPattern("HH:mm"));

			return format + " - " + format2;
		}
		return "";
	}

	public void setExt1Time(LocalDateTime ext1Time) {
		this.ext1Time = ext1Time;
	}

	public LocalDateTime getExt2Time() {
		return ext2Time;
	}

	public void setExt2Time(LocalDateTime ext2Time) {
		this.ext2Time = ext2Time;
	}

	public LocalDateTime getExt3Time() {
		return ext3Time;
	}

	public void setExt3Time(LocalDateTime ext3Time) {
		this.ext3Time = ext3Time;
	}

	public LocalDateTime getExt4Time() {
		return ext4Time;
	}

	public void setExt4Time(LocalDateTime ext4Time) {
		this.ext4Time = ext4Time;
	}

	public LocalDateTime getExt5Time() {
		return ext5Time;
	}

	public void setExt5Time(LocalDateTime ext5Time) {
		this.ext5Time = ext5Time;
	}

	public Integer getChannel() {
		return channel;
	}

	public void setChannel(Integer channel) {
		this.channel = channel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getHoldStatus() {
		return holdStatus;
	}

	public void setHoldStatus(Integer holdStatus) {
		this.holdStatus = holdStatus;
	}

	public String getPerformerName() {
		return performerName;
	}

	public void setPerformerName(String performerName) {
		this.performerName = performerName;
	}

	public String getEscortId() {
		return escortId;
	}

	public void setEscortId(String escortId) {
		this.escortId = escortId;
	}

	public String getEscortName() {
		return escortName;
	}

	public void setEscortName(String escortName) {
		this.escortName = escortName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getExt1Str() {
		return ext1Str;
	}

	public void setExt1Str(String ext1Str) {
		this.ext1Str = ext1Str;
	}

	public String getExt2Str() {
		return ext2Str;
	}

	public void setExt2Str(String ext2Str) {
		this.ext2Str = ext2Str;
	}

	public String getExt3Str() {
		return ext3Str;
	}

	public void setExt3Str(String ext3Str) {
		this.ext3Str = ext3Str;
	}

	public String getExt4Str() {
		return ext4Str;
	}

	public void setExt4Str(String ext4Str) {
		this.ext4Str = ext4Str;
	}

	public String getExt5Str() {
		return ext5Str;
	}

	public void setExt5Str(String ext5Str) {
		this.ext5Str = ext5Str;
	}

	public LocalDateTime getStatusUpdateTime() {
		return statusUpdateTime;
	}

	public void setStatusUpdateTime(LocalDateTime statusUpdateTime) {
		this.statusUpdateTime = statusUpdateTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDateTime getReportUpdateTime() {
		return reportUpdateTime;
	}

	public void setReportUpdateTime(LocalDateTime reportUpdateTime) {
		this.reportUpdateTime = reportUpdateTime;
	}


}
