package com.point72.wechat.pay.callback.model;

import org.dom4j.Document;

import com.point72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 支付结果通知数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class PayResultCallbackModel extends AbstractPayModel {

	public PayResultCallbackModel() {
		super();
	}

	public PayResultCallbackModel(Document doc, String keycode) {
		super(doc, keycode);
	}

	public String return_code;
	public String return_msg;
	public String appid;
	public String mch_id;
	public String device_info;
	public String nonce_str;
	public String sign;
	public String sign_type;
	public String result_code;
	public String err_code;
	public String err_code_des;
	public String openid;
	public String is_subscribe;
	public String trade_type;
	public String bank_type;
	public String total_fee;
	public String settlement_total_fee;
	public String fee_type;
	public String cash_fee;
	public String cash_fee_type;
	public String coupon_fee;
	public String coupon_count;
	public String transaction_id;
	public String out_trade_no;
	public String attach;
	public String time_end;
}
