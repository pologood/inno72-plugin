package com.inno72.wechat.pay.response.model;

import com.inno72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 交易保障接口返回结果数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class PayReportResponseModel extends AbstractPayModel {

	public PayReportResponseModel(String xml) {
		this.toModel(xml);
	}

	public String return_code;
	public String return_msg;
	public String result_code;

}
