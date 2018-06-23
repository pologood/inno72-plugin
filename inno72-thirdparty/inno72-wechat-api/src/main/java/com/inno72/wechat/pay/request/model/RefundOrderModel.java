package com.inno72.wechat.pay.request.model;

import com.inno72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data
/**
 * 退款接口请求数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class RefundOrderModel extends AbstractPayModel {

	public String appid;
	public String mch_id;
	public String nonce_str;
	public String sign;
	public String sign_type;
	public String transaction_id;
	public String out_trade_no;
	public String out_refund_no;
	public String total_fee;
	public String refund_fee;
	public String refund_fee_type;
	public String refund_desc;
	public String refund_account;

}
