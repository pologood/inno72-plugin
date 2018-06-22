package com.point72.wechat.pay.request.model;

import com.point72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 下载对账单请求接口数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class DownloadBillModel extends AbstractPayModel {

	public String appid;
	public String mch_id;
	public String device_info;
	public String nonce_str;
	public String sign;
	public String sign_type;
	public String bill_date;
	public String bill_type;
	public String tar_type;

}