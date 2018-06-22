package com.point72.wechat.pay.request.model;

import com.point72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 查询订单
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class FindOrderModel extends AbstractPayModel {

	public String appid;
	public String mch_id;
	public String transaction_id;
	public String out_trade_no;
	public String nonce_str;
	public String sign;
	public String sign_type;

}
