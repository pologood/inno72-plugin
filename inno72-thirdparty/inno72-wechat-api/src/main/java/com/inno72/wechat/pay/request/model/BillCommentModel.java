package com.inno72.wechat.pay.request.model;

import com.inno72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 拉取订单评价数据请求数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class BillCommentModel extends AbstractPayModel {

	public String appid;
	public String mch_id;
	public String nonce_str;
	public String sign;
	public String sign_type;
	public String begin_time;
	public String end_time;
	public String offset;
	public String limit;

}