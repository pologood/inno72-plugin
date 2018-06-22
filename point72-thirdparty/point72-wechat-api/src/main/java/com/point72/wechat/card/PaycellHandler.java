package com.point72.wechat.card;

import com.alibaba.fastjson.JSONObject;
import com.point72.wechat.common.Invoke;

/**
 * 快速买单接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class PaycellHandler {

	/**
	 * 设置买单接口
	 * 
	 * @param token
	 * @param cardId
	 * @param isOpen
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String set(String token, String cardId, boolean isOpen) {
		JSONObject json = new JSONObject();
		json.put("card_id", cardId);
		json.put("is_open", isOpen);
		return Invoke.post("https://api.weixin.qq.com/card/paycell/set?access_token={0}", json.toJSONString(), token);
	}

	/**
	 * 设置自助核销接口
	 * 
	 * @param token
	 * @param cardId
	 * @param isOpen
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String selfconsumecell(String token, String cardId, boolean isOpen) {
		JSONObject json = new JSONObject();
		json.put("card_id", cardId);
		json.put("is_open", isOpen);
		return Invoke.post("https://api.weixin.qq.com/card/selfconsumecell/set?access_token={0}", json.toJSONString(),
				token);
	}

}
