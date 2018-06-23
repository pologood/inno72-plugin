package com.inno72.ddtalk.miniapp.model;

import com.alibaba.fastjson.JSONObject;

public class MiniAPPModel {

	private String jsonData;

	/**
	 * 
	 * @param appIconMediaId
	 *            微应用的图标。需要调用上传接口将图标上传到钉钉服务器后获取到的mediaId
	 * @param appName
	 *            微应用的名称。长度限制为1~10个字符
	 * @param appDesc
	 *            微应用的描述。长度限制为1~20个字符
	 * @param homepageUrl
	 *            微应用的移动端主页，必须以http开头或https开头
	 * @param pcHomepageUrl
	 *            微应用的PC端主页，必须以http开头或https开头，如果不为空则必须与homepageUrl的域名一致
	 * @param ompLink
	 *            微应用的OA后台管理主页，必须以http开头或https开头
	 */
	public MiniAPPModel(String appIconMediaId, String appName, String appDesc, String homepageUrl, String pcHomepageUrl,
			String ompLink) {
		JSONObject json = new JSONObject();
		json.put("appIcon", appIconMediaId);
		json.put("appName", appName);
		json.put("appDesc", appDesc);
		json.put("homepageUrl", homepageUrl);
		json.put("pcHomepageUrl", pcHomepageUrl);
		json.put("ompLink", ompLink);
		this.jsonData = json.toJSONString();
	}

	public String getJsonData() {
		return jsonData;
	}

}
