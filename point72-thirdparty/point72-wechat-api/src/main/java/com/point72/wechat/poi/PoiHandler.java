package com.point72.wechat.poi;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.point72.wechat.common.Invoke;
import com.point72.wechat.common.ResultHandler;

/**
 * 微信门店接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class PoiHandler {

	/**
	 * 创建门店
	 * 
	 * @param token
	 * @param poi
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String create(String token, Poi poi) {
		JSONObject json = new JSONObject();
		json.put("business", poi);
		return Invoke.post("http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token={0}", json.toJSONString(), token);
	}

	/**
	 * 获取门店信息
	 * 
	 * @param token
	 * @param poiId
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static Poi get(String token, String poiId) {
		JSONObject json = new JSONObject();
		json.put("poi_id", poiId);
		String result = Invoke.post("http://api.weixin.qq.com/cgi-bin/poi/addpoi?access_token={0}", json.toJSONString(),
				token);
		ResultHandler handler = ResultHandler.create(result);
		if (handler.isSuccess()) {
			return JSON.parseObject(handler.getString("business"), Poi.class);
		}
		return null;
	}

	/**
	 * 获取门店列表
	 * 
	 * @param token
	 * @param begin
	 * @param limit
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static List<Poi> get(String token, int begin, int limit) {
		JSONObject json = new JSONObject();
		json.put("begin", begin);
		json.put("limit", limit);
		String result = Invoke.post("https://api.weixin.qq.com/cgi-bin/poi/getpoilist?access_token={0}",
				json.toJSONString(), token);
		ResultHandler handler = ResultHandler.create(result);
		if (handler.isSuccess()) {
			return JSON.parseArray(handler.getString("business"), Poi.class);
		}
		return null;
	}

	/**
	 * 修改门店信息
	 * 
	 * @param token
	 * @param poi
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String update(String token, Poi poi) {
		JSONObject json = new JSONObject();
		json.put("business", poi);
		return Invoke.post("http://api.weixin.qq.com/cgi-bin/poi/updatepoi?access_token={0}", json.toJSONString(),
				token);
	}

	/**
	 * 删除门店信息
	 * 
	 * @param token
	 * @param poiId
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String remove(String token, String poiId) {
		JSONObject json = new JSONObject();
		json.put("poi_id", poiId);
		return Invoke.post("http://api.weixin.qq.com/cgi-bin/poi/delpoi?access_token={0}", json.toJSONString(), token);
	}

	/**
	 * 门店类目表
	 * 
	 * @param token
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getwxcategory(String token, String poiId) {
		return Invoke.get("http://api.weixin.qq.com/cgi-bin/poi/getwxcategory?access_token={0}", token);
	}

}
