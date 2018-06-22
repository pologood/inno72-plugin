package com.point72.wechat.pay.response.model;

import com.point72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 查询订单返回数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class FindOrderResponseModel extends AbstractPayModel {

	public enum TradeState {
		SUCCESS, REFUND, NOTPAY, CLOSED, REVOKED, USERPAYING, PAYERROR;
	}

	public FindOrderResponseModel(String xml) {
		this.toModel(xml);
	}

	@Override
	public boolean success() {
		boolean success = super.success();
		if (!success) {
			return false;
		} else {
			return TradeState.SUCCESS.equals(TradeState.valueOf(this.trade_state));
		}
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
	public String device_info;
	public String openid;
	public String is_subscribe;
	public String trade_type;
	public String trade_state;
	public String bank_type;
	public String total_fee;
	public String settlement_total_fee;
	public String fee_type;
	public String cash_fee;
	public String cash_fee_type;
	public String coupon_fee;
	public String transaction_id;
	public String out_trade_no;
	public String attach;
	public String time_end;
	public String trade_state_desc;

}
