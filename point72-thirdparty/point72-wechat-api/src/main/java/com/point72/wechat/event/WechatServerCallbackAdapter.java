package com.point72.wechat.event;

import com.point72.wechat.pay.AbstractPayModel;

/**
 * 微信回调适配器，所有回调统一接口，根据数据使用不同的适配器
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public interface WechatServerCallbackAdapter {

	String process(AbstractPayModel model);

	/**
	 * 处理成功的返回信息
	 * 
	 * @return
	 * @author Houkm 2017年10月13日
	 */
	default String getSuccessResponse() {
		return "<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>";
	}

}
