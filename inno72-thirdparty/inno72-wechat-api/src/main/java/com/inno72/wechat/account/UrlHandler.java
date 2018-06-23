package com.inno72.wechat.account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.inno72.wechat.ApiUrl.Common;
import com.inno72.wechat.common.Invoke;
import com.inno72.wechat.common.ResultHandler;

/**
 * 微信链接接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class UrlHandler {
	static Logger logger = LoggerFactory.getLogger(UrlHandler.class);

	/**
	 * 长链接转短链接接口
	 * 
	 * @param token
	 * @param url
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String shortUrl(String token, String url) {
		logger.info("转换长链接：{}", url);
		JSONObject json = new JSONObject();
		json.put("long_url", url);
		json.put("action", "long2short");
		String result = Invoke.post(Common.Short_Url.url(), json.toJSONString(), token);
		ResultHandler handler = ResultHandler.create(result);
		if (!handler.isSuccess()) {
			logger.error("转换长链接失败， code【{}】 msg【{}】", handler.getErrcode(), handler.getErrmsg());
			return null;
		}
		return handler.getString("short_url");
	}

}
