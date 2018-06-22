package com.point72.xiongzhang.mch.model;

import lombok.Data;

/**
 * 调起收银台model
 * 
 * @author Houkm
 *
 *         2018年4月3日
 */
@Data
public class OrderModel {

	private String access_token;
	private String tp_order_id;
	private int total_amount;
	private String pay_result_url;
	private Object return_data;
	private Object display_data;
	private String deal_title;
	private String deal_sub_title;
	private String deal_thumb_view;

}
