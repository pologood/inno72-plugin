package com.inno72.wechat.pay.response.model;

import com.inno72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 统一下单返回结果数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class UnifieOrderResponseModel extends AbstractPayModel {

	public UnifieOrderResponseModel(String xml) {
		this.toModel(xml);
	}

	public String return_code;
	public String return_msg;
	public String appid;
	public String mch_id;
	public String device_info;
	public String nonce_str;
	public String sign;
	public String result_code;
	public String err_code;
	public String err_code_des;
	public String trade_type;
	public String prepay_id;
	public String code_url;

}
