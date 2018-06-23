package com.inno72.xiongzhang.mch.model;

import lombok.Data;

/**
 * 商户核销model
 * 
 * @author Houkm
 *
 *         2018年4月3日
 */
@Data
public class ApprefundModel {

	private String access_token;
	private int order_id;
	private String refund_reason;
	private String tp_order_id;
	private long official_no;

}
