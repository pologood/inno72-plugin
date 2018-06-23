package com.inno72.wechat.pay.response.model;

import com.inno72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 退款订单返回结果数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class RefundOrderResponseModel extends AbstractPayModel {

	public RefundOrderResponseModel(String xml) {
		this.toModel(xml);
	}

	public String return_code;
	public String return_msg;
	public String result_code;
	public String err_code;
	public String err_code_des;

	public String appid;
	public String mch_id;
	public String nonce_str;
	public String sign;
	public String transaction_id;
	public String out_trade_no;
	public String out_refund_no;
	public String refund_id;
	public String refund_channel;
	public String refund_fee;
	public String coupon_refund_fee;
	public String settlement_refund_fee;
	public String total_fee;
	public String settlement_total_fee;
	public String fee_type;
	public String cash_fee;
	public String cash_fee_type;
	public String cash_refund_fee;
	public String coupon_refund_count;

}
