package com.point72.ddtalk.miniapp.model;

import com.alibaba.fastjson.JSONObject;

public class SetVisibleScopeModel {

	private String jsonData;

	/**
	 * 
	 * @param agentId
	 *            微应用agentId
	 * @param isHidden
	 *            是否仅限管理员可见，true代表仅限管理员可见
	 * @param deptVisibleScopes
	 *            设置可见的部门id列表，格式为JSON数组
	 * @param userVisibleScopes
	 *            设置可见的员工id列表，格式为JSON数组
	 */
	public SetVisibleScopeModel(String agentId, boolean isHidden, int[] deptVisibleScopes, String[] userVisibleScopes) {
		JSONObject json = new JSONObject();
		json.put("agentId", agentId);
		json.put("isHidden", isHidden);
		json.put("deptVisibleScopes", deptVisibleScopes);
		json.put("userVisibleScopes", userVisibleScopes);
		this.jsonData = json.toJSONString();
	}

	public String getJsonData() {
		return jsonData;
	}

}
