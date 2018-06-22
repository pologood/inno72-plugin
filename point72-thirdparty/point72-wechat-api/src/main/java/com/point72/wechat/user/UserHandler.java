package com.point72.wechat.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.point72.wechat.ApiUrl;
import com.point72.wechat.common.Invoke;
import com.point72.wechat.common.ResultHandler;

/**
 * 用户接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class UserHandler {

	/**
	 * 设置用户备注名
	 * 
	 * @param token
	 * @param openid
	 * @param remark
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String remark(String token, String openid, String remark) {
		JSONObject json = new JSONObject();
		json.put("openid", openid);
		json.put("remark", remark);
		String result = Invoke.post(ApiUrl.User.Remark.url(), json.toJSONString(), token);
		return result;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param token
	 * @param openid
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static User get(String token, String openid) {
		String result = Invoke.get(ApiUrl.User.Info.url(), token, openid, "zh_CN");
		User user = JSON.parseObject(result, User.class);
		return user;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param token
	 * @param openids
	 * @param lang
	 *            默认zh_CN
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static List<User> get(String token, List<String> openids, String lang) {
		List<Map<String, String>> list = new ArrayList<>();
		openids.forEach(openid -> {
			Map<String, String> map = new HashMap<>();
			map.put("openid", openid);
			map.put("lang", lang == null || "".equals(lang) ? "zh_CN" : lang);
			list.add(map);
		});

		JSONObject json = new JSONObject();
		json.put("user_list", list);

		String result = Invoke.post(ApiUrl.User.Batch_Info.url(), json.toJSONString(), token);
		ResultHandler handler = ResultHandler.create(result);
		if (handler.isSuccess()) {
			handler.getJson();
			List<User> users = JSON.parseArray(handler.getJson().getString("user_info_list"), User.class);
			return users;
		}
		return null;
	}

	/**
	 * 获取用户列表
	 * 
	 * @param token
	 * @param nextOpenid
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String list(String token, String nextOpenid) {
		return Invoke.get(ApiUrl.User.List.url(), token, nextOpenid);
	}

}
