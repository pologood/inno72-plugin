package com.inno72.wechat.user;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.inno72.wechat.ApiUrl.BlackList;
import com.inno72.wechat.common.Invoke;

/**
 * 黑名单管理接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class BlackListHandler {

	/**
	 * 获取黑名单列表
	 * 
	 * @param token
	 * @param beginOpenid
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String get(String token, String beginOpenid) {
		JSONObject json = new JSONObject();
		json.put("begin_openid", beginOpenid);
		return Invoke.post(BlackList.List.url(), json.toString(), token);
	}

	/**
	 * 拉黑用户
	 * 
	 * @param token
	 * @param openids
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String put(String token, List<String> openids) {
		JSONObject json = new JSONObject();
		json.put("opened_list", openids);
		return Invoke.post(BlackList.Add.url(), json.toString(), token);
	}

	/**
	 * 取消黑名单
	 * 
	 * @param token
	 * @param openids
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String remove(String token, List<String> openids) {
		JSONObject json = new JSONObject();
		json.put("opened_list", openids);
		return Invoke.post(BlackList.Remove.url(), json.toString(), token);
	}

}
