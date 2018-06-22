package com.framelib.dubbo.neworder.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.framelib.dubbo.model.BaseModel;
import com.point72.common.datetime.CustomLocalDateTimeSerializer;

/**
 * 订单时间
 * @author zhouzengbao
 *
 */
public class OrdersTime extends BaseModel{
	private static final long serialVersionUID = 6319963112476562044L;
    /***/
    private Integer id;

    /** 订单id */
    private String orderId;

    /** 订单号 */
    private String orderNum;

    /** 时间 */
    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
   	@DateTimeFormat(iso=ISO.DATE_TIME)
    private LocalDateTime orderTime;

    /** 时间类型 */
    private Integer type;

    public enum Orders_Time_Type{
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
        FINASH(8,"已完成"),

        //待履约          ；儿保 已排版 待履约
        //已接诊 门诊待回电 ；
        WAIT_CALLBACK(5,"待回电"),
        //已回电 门诊待填写诊断 ；
        WAIT_DIAGNOSE(6,"待填写诊断"),
        //已填写诊断 门诊待审核 ；
        WAIT_AUDIT(7,"待审核"),

        OVERDUE(9,"过期时间");
        //审核通过 门诊已完成 ；

        private int v;

        private String t;

        Orders_Time_Type(int v, String t) {
            this.v = v;
            this.t = t;
        }

        public int v() {
            return this.v;
        }
        public String t() {
            return this.t;
        }

    }



    /***/
    public Integer getId() {
        return id;
    }

    /***/
    public void setId(Integer id) {
        this.id = id;
    }

    /***/
    public String getOrderId() {
        return orderId;
    }

    /***/
    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    /***/
    public String getOrderNum() {
        return orderNum;
    }

    /***/
    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    /***/
    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    /***/
    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    /***/
    public Integer getType() {
        return type;
    }

    /***/
    public void setType(Integer type) {
        this.type = type;
    }
}