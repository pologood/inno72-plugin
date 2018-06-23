package com.inno72.wechat.pay.response.model;

import com.inno72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 关闭订单返回结果数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class CloseOrderResponseModel extends AbstractPayModel {

	public CloseOrderResponseModel(String xml) {
		this.toModel(xml);
	}

	public String return_code;
	public String return_msg;
	public String appid;
	public String mch_id;
	public String nonce_str;
	public String sign;
	public String result_code;
	public String result_msg;
	public String err_code;
	public String err_code_des;

}
