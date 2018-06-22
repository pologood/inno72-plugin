package com.point72.xiongzhang.mch;

import com.alibaba.fastjson.JSON;
import com.point72.xiongzhang.ApiUrl;
import com.point72.xiongzhang.Invoke;
import com.point72.xiongzhang.mch.model.ApprefundModel;
import com.point72.xiongzhang.mch.model.OrderModel;
import com.point72.xiongzhang.mch.model.SettleModel;

/**
 * 商户接口
 * 
 * @author Houkm
 *
 *         2018年4月3日
 */
public class MchHandler {

	/**
	 * 调起收银台
	 * 
	 * @param model
	 * @return
	 * @author Houkm 2018年4月3日
	 */
	public static String cashierurl(OrderModel model) {
		return Invoke.post(ApiUrl.Mch.Cashierurl.url(), JSON.toJSONString(model));
	}

	/**
	 * 服务商发起核销
	 * 
	 * @param model
	 * @return
	 * @author Houkm 2018年4月3日
	 */
	public static String settle(SettleModel model) {
		return Invoke.post(ApiUrl.Mch.Settle.url(), JSON.toJSONString(model));
	}

	/**
	 * 服务商申请退款
	 * 
	 * @param model
	 * @return
	 * @author Houkm 2018年4月3日
	 */
	public static String apprefund(ApprefundModel model) {
		return Invoke.post(ApiUrl.Mch.Apprefund.url(), JSON.toJSONString(model));
	}

}
