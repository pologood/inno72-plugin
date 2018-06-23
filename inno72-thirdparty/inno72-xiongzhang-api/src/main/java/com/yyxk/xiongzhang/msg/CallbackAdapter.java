package com.inno72.xiongzhang.msg;

import com.alibaba.fastjson.JSONObject;

/**
 * 回调事件适配器
 * 
 * @author Houkm
 *
 *         2018年4月3日
 */
public interface CallbackAdapter {

	String process(JSONObject jsonObj);

	/**
	 * 回调类型
	 * 
	 * @author Houkm
	 *
	 *         2018年4月3日
	 */
	public static enum Type {
		/**
		 * 支付回调
		 */
		pay,

		/**
		 * 退款回调
		 */
		refund;
	}

}
