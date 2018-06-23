package com.framelib.dubbo.neworder.vo;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotNull;

import com.framelib.dubbo.model.Orders;
import com.framelib.dubbo.model.OrdersAddress;
import com.framelib.dubbo.model.OrdersInfo;
import com.framelib.dubbo.neworder.model.CarClassesAppointment;
import com.framelib.dubbo.neworder.model.ContractsBaby;
import com.framelib.dubbo.neworder.model.ContractsOrder;

public class ContractsOrderVo extends ContractsOrder{
	

	/**
	/**
	 * 
	 */
	private static final long serialVersionUID = -2197946025452763755L;

	//订单信息 保存合约单不用传值使用ordersIds
	private List<OrdersVo> infos;

	private List<String> ordersIds;
	
	private List<OrdersInfo> ordersInfos;
	
	private List<Orders> orders;
	
	private CarClassesAppointment carClassesAppointment;

	private ContractsOrder order;
	
	@NotNull(message = "无儿童对象")
	private ContractsBaby baby;
	
	private Integer includeCarPrice;
	
	@NotNull(message = "无地址对象")
	private OrdersAddress orderAddress;
	
	@NotNull(message = "无车辆")
	private String carId;
	
	@NotNull(message = "无组合项")
	private String ruleId;
	
	@NotNull(message = "无预约时间")
	private String appointmentTime;
	
	@NotNull(message = "无预约订单")
	private String appointmentOrderId;
	
	public String getAppointmentOrderId() {
		return appointmentOrderId;
	}

	public void setAppointmentOrderId(String appointmentOrderId) {
		this.appointmentOrderId = appointmentOrderId;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public OrdersAddress getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(OrdersAddress orderAddress) {
		this.orderAddress = orderAddress;
	}

	public Integer getIncludeCarPrice() {
		return includeCarPrice;
	}

	public void setIncludeCarPrice(Integer includeCarPrice) {
		this.includeCarPrice = includeCarPrice;
	}

	//用户
	private Map<String, Object> patient;
	

	public Map<String, Object> getPatient() {
		return patient;
	}

	public void setPatient(Map<String, Object> patient) {
		this.patient = patient;
	}

	public List<OrdersInfo> getOrdersInfos() {
		return ordersInfos;
	}

	public void setOrdersInfos(List<OrdersInfo> ordersInfos) {
		this.ordersInfos = ordersInfos;
	}

	public List<OrdersVo> getInfos() {
		return infos;
	}

	public void setInfos(List<OrdersVo> infos) {
		this.infos = infos;
	}

	public CarClassesAppointment getCarClassesAppointment() {
		return carClassesAppointment;
	}

	public void setCarClassesAppointment(CarClassesAppointment carClassesAppointment) {
		this.carClassesAppointment = carClassesAppointment;
	}

	public ContractsBaby getBaby() {
		return baby;
	}

	public void setBaby(ContractsBaby baby) {
		this.baby = baby;
	}

	public List<String> getOrdersIds() {
		return ordersIds;
	}

	public void setOrdersIds(List<String> ordersIds) {
		this.ordersIds = ordersIds;
	}

	public ContractsOrder getOrder() {
		return order;
	}

	public void setOrder(ContractsOrder order) {
		this.order = order;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	
}
