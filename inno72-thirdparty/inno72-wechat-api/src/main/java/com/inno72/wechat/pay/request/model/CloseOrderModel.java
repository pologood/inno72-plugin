package com.inno72.wechat.pay.request.model;

import com.inno72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 关闭订单请求数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class CloseOrderModel extends AbstractPayModel {

	public String appid;
	public String mch_id;
	public String out_trade_no;
	public String nonce_str;
	public String sign;
	public String sign_type;

}