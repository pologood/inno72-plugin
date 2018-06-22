package com.point72.wechat.account;

import java.text.MessageFormat;

import com.point72.plugin.http.HttpClient;
import com.point72.plugin.http.HttpClient.Response_Type;
import com.point72.wechat.ApiUrl.Qrcode;
import com.point72.wechat.common.Invoke;
import com.point72.wechat.common.ResultHandler;

/**
 * 生成带参数的二维码
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class QrCodeHandler {

	/**
	 * 创建临时二维码
	 * 
	 * @param token
	 * @param senceId
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static byte[] createTmp(String token, int senceId) {
		String json = "{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": "
				+ senceId + "}}}\"";
		return generate(token, json);
	}

	/**
	 * 创建临时二维码
	 * 
	 * @param token
	 * @param senceId
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static byte[] createTmp(String token, String senceStr) {
		String json = "{\"expire_seconds\": 604800, \"action_name\": \"QR_SCENE\", \"action_info\": {\"scene\": {\"scene_id\": \""
				+ senceStr + "\"}}}\"";
		return generate(token, json);
	}

	/**
	 * 创建永久二维码
	 * 
	 * @param token
	 * @param senceStr
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static byte[] createPermanent(String token, String senceStr) {
		String json = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \""
				+ senceStr + "\"}}}";
		return generate(token, json);
	}

	/**
	 * 创建永久二维码
	 * 
	 * @param token
	 * @param senceStr
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static byte[] createPermanent(String token, int senceId) {
		String json = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": "
				+ senceId + "}}}";
		return generate(token, json);
	}

	private static byte[] generate(String token, String json) {
		String result = Invoke.post(Qrcode.Ticket.url(), json, token);
		ResultHandler handler = ResultHandler.create(result);
		if (handler.isSuccess()) {
			String ticket = handler.getString("ticket");
			String qrUrl = MessageFormat.format(Qrcode.Generate.url(), ticket);
			byte[] bs = (byte[]) HttpClient.get(qrUrl, Response_Type.Byte);
			return bs;
		}

		return null;
	}
}
