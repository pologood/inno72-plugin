package com.framelib.dubbo.neworder.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.framelib.dubbo.model.OrdersHistory;
import com.framelib.dubbo.neworder.model.*;
import com.point72.common.datetime.CustomLocalDateTimeSerializer;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.framelib.dubbo.model.Orders;
import com.framelib.dubbo.model.OrdersAddress;
import com.framelib.dubbo.model.OrdersInfo;

public class OrdersVo implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 1716049687941126751L;

	//订单
	private Orders orders;

	//订单商品
	private OrdersInfo ordersInfo;
	private OrdersInfo info;
	//用户
	private Map<String, Object> patient;

	private NewGoodsCombinigRule newGoodsCombinigRule;

	private NewGoodsServiceItem newGoodsServiceItem;

	private NewGoodsCombinigService newGoodsCombinigService;

	private OrdersAddress orderAddress;

	private ContractsBaby contractsBaby;

	private String serviceId;

	/** 组合id */
	private String comboId;

	/**儿保套餐名称  -  手工添加订单 别名*/
	private String comboName;

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
	private Map<String, Object> infoData;

	/** 预约时间 */
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime appointmentTime;

	private Map<String, String> times;

	private List<OrdersTime> OrdersTimes;

	private Orders.Order_Type orderType;

	private String creator;

	private List<OrdersHistory> histories;

	public String getComboName() {
		return comboName;
	}

	public void setComboName(String comboName) {
		this.comboName = comboName;
	}

	public List<OrdersHistory> getHistories() {
		return histories;
	}

	public void setHistories(List<OrdersHistory> histories) {
		this.histories = histories;
	}

	public List<OrdersTime> getOrdersTimes() {
		return OrdersTimes;
	}

	public void setOrdersTimes(List<OrdersTime> ordersTimes) {
		OrdersTimes = ordersTimes;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public OrdersInfo getOrdersInfo() {
		return Optional.ofNullable(ordersInfo).orElseGet(() ->new OrdersInfo());
	}

	public void setOrdersInfo(OrdersInfo ordersInfo) {
		this.ordersInfo = ordersInfo;
	}

	public Orders.Order_Type getOrderType() {
		return orderType;
	}

	public void setOrderType(Orders.Order_Type orderType) {
		this.orderType = orderType;
	}

	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public Map<String, String> getTimes() {
		return times;
	}

	public void setTimes(Map<String, String> times) {
		this.times = times;
	}

	public Map<String, Object> getInfoData() {
		return infoData;
	}

	public void setInfoData(Map<String, Object> infoData) {
		this.infoData = infoData;
	}

	public String getComboId() {
		return comboId;
	}

	public void setComboId(String comboId) {
		this.comboId = comboId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public ContractsBaby getContractsBaby() {
		return contractsBaby;
	}

	public void setContractsBaby(ContractsBaby contractsBaby) {
		this.contractsBaby = contractsBaby;
	}

	public OrdersAddress getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(OrdersAddress orderAddress) {
		this.orderAddress = orderAddress;
	}

	public NewGoodsCombinigRule getNewGoodsCombinigRule() {
		return newGoodsCombinigRule;
	}

	public void setNewGoodsCombinigRule(NewGoodsCombinigRule newGoodsCombinigRule) {
		this.newGoodsCombinigRule = newGoodsCombinigRule;
	}

	public NewGoodsServiceItem getNewGoodsServiceItem() {
		return newGoodsServiceItem;
	}

	public void setNewGoodsServiceItem(NewGoodsServiceItem newGoodsServiceItem) {
		this.newGoodsServiceItem = newGoodsServiceItem;
	}

	public NewGoodsCombinigService getNewGoodsCombinigService() {
		return newGoodsCombinigService;
	}

	public void setNewGoodsCombinigService(NewGoodsCombinigService newGoodsCombinigService) {
		this.newGoodsCombinigService = newGoodsCombinigService;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Map<String, Object> getPatient() {
		return patient;
	}

	public void setPatient(Map<String, Object> patient) {
		this.patient = patient;
	}

	public OrdersInfo getInfo() {
		return info;
	}

	public void setInfo(OrdersInfo info) {
		this.info = info;
	}
}
