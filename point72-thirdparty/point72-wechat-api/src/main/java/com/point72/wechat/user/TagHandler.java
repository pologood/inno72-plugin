package com.point72.wechat.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.point72.wechat.ApiUrl.Tag;
import com.point72.wechat.common.Invoke;

/**
 * 用户标签管理接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class TagHandler {

	/**
	 * 创建标签
	 * 
	 * @param token
	 * @param tag
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String create(String token, String tag) {
		JSONObject json = new JSONObject();
		Map<String, String> map = new HashMap<>();
		map.put("name", tag);
		json.put("tag", map);
		String result = Invoke.post(Tag.Create.url(), json.toJSONString(), token);
		return result;

	}

	/**
	 * 获取标签
	 * 
	 * @param token
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String get(String token) {
		String result = Invoke.get(Tag.Get.url(), token);
		return result;
	}

	/**
	 * 编辑标签
	 * 
	 * @param token
	 * @param id
	 * @param tag
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String edit(String token, int id, String tag) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("name", tag);
		JSONObject json = new JSONObject();
		json.put("tag", map);
		return Invoke.post(Tag.Update.url(), json.toJSONString(), token);
	}

	/**
	 * 删除标签
	 * 
	 * @param token
	 * @param id
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String delete(String token, int id) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		JSONObject json = new JSONObject();
		json.put("tag", map);
		return Invoke.post(Tag.Del.url(), json.toJSONString(), token);
	}

	/**
	 * 获取标签下的粉丝
	 * 
	 * @param token
	 * @param id
	 * @param nextOpenid
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getFans(String token, int id, String nextOpenid) {
		JSONObject json = new JSONObject();
		json.put("tagid", id);
		if (nextOpenid != null && !"".equals(nextOpenid)) {
			json.put("next_openid", nextOpenid);
		}
		return Invoke.post(Tag.FANS.url(), json.toJSONString(), token);
	}

	/**
	 * 批量为用户打标签
	 * 
	 * @param token
	 * @param id
	 * @param openids
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String tag(String token, int id, List<String> openids) {
		JSONObject json = new JSONObject();
		json.put("tagid", id);
		json.put("openid_list", openids);
		return Invoke.post(Tag.Tag_User.url(), json.toJSONString(), token);
	}

	/**
	 * 批量为用户取消标签
	 * 
	 * @param token
	 * @param id
	 * @param openids
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String untag(String token, int id, List<String> openids) {
		JSONObject json = new JSONObject();
		json.put("tagid", id);
		json.put("openid_list", openids);
		return Invoke.post(Tag.Batch_Untag.url(), json.toJSONString(), token);
	}

	/**
	 * 获取用户身上的标签列表
	 * 
	 * @param token
	 * @param openid
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String get(String token, String openid) {
		JSONObject json = new JSONObject();
		json.put("openid", openid);
		return Invoke.post(Tag.User_Tag.url(), json.toJSONString(), token);
	}

}
