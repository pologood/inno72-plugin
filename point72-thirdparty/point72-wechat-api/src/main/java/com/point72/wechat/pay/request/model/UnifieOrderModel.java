package com.point72.wechat.pay.request.model;

import com.point72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 统一下单接口数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class UnifieOrderModel extends AbstractPayModel {

	public String appid;
	public String mch_id;
	public String device_info;
	public String nonce_str;
	public String sign;
	public String sign_type;
	public String body;
	public String detail;
	public String attach;
	public String out_trade_no;
	public String fee_type;
	public String total_fee;
	public String spbill_create_ip;
	public String time_start;
	public String time_expire;
	public String goods_tag;
	public String notify_url;
	public String trade_type;
	public String product_id;
	public String limit_pay;
	public String openid;
	public String scene_info;

}
