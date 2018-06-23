package com.inno72.wechat.pay.request.model;

import com.inno72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 交易保障接口请求数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class PayReportModel extends AbstractPayModel {

	public String appid;
	public String mch_id;
	public String device_info;
	public String nonce_str;
	public String sign;
	public String sign_type;
	public String interface_url;
	public String execute_time;
	public String return_code;
	public String return_msg;
	public String result_code;
	public String err_code;
	public String err_code_des;
	public String out_trade_no;
	public String user_ip;
	public String time;

}