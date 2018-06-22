package com.point72.ddtalk.miniapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.point72.ddtalk.ApiUrl.MiniAPP;
import com.point72.ddtalk.Invoke;
import com.point72.ddtalk.ResultHandler;
import com.point72.ddtalk.miniapp.model.MiniAPPModel;
import com.point72.ddtalk.miniapp.model.SetVisibleScopeModel;

/**
 * 微应用接口
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class MiniAPPHandler {

	private static Logger logger = LoggerFactory.getLogger(MiniAPPHandler.class);

	/**
	 * 创建微应用
	 * 
	 * @param token
	 * @param model
	 *            {@link MiniAPPModel}
	 * @return 微应用ID
	 * @author Houkm 2017年9月8日
	 */
	public static String create(String token, MiniAPPModel model) {
		String result = Invoke.post(MiniAPP.Create.url(), model.getJsonData(), token);
		ResultHandler handler = new ResultHandler(result);
		if (handler.isSuccess()) {
			return handler.getString("id");
		} else {
			logger.error("创建微应用失败：{} --- {}", handler.getErrcode(), handler.getErrmsg());
			return null;
		}
	}

	/**
	 * 获取企业设置的微应用可见范围
	 * 
	 * @param token
	 * @param agentId
	 * @return
	 * @author Houkm 2017年9月8日
	 */
	public static String getVisibleScope(String token, long agentId) {
		JSONObject data = new JSONObject();
		data.put("agentId", agentId);
		return Invoke.post(MiniAPP.Get_Visible_Scopes.url(), data.toJSONString(), token);
	}

	/**
	 * 设置微应用的可见范围
	 * 
	 * @param token
	 * @param model
	 *            {@link SetVisibleScopeModel}
	 * @return
	 * @author Houkm 2017年9月8日
	 */
	public static boolean setVisibleScope(String token, SetVisibleScopeModel model) {
		String result = Invoke.post(MiniAPP.Set_Visible_Scopes.url(), model.getJsonData(), token);
		ResultHandler handler = new ResultHandler(result);
		if (!handler.isSuccess()) {
			logger.error("设置微应用的可见范围：{} --- {}", handler.getErrcode(), handler.getErrmsg());
		}
		return handler.isSuccess();
	}

}
