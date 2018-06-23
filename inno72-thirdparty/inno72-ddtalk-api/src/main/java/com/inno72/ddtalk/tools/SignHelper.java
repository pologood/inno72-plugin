package com.inno72.ddtalk.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/**
 * 签名相关工具
 * 
 * @author Houkm
 *
 *         2017年9月7日
 */
public class SignHelper {

	/**
	 * jssdk的config签名
	 * 
	 * @param jsapi_ticket
	 * @param url
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static Map<String, String> jsConfig(String jsapi_ticket, String url) {

		Map<String, String> result = new HashMap<>();

		String noncestr = UUID.randomUUID().toString().replaceAll("-", "");
		String timestamp = String.valueOf(System.currentTimeMillis());

		int index = url.indexOf("?") + 1;
		if (index != -1) {
			String decodeUrl = url.substring(index);
			try {
				decodeUrl = URLDecoder.decode(decodeUrl, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			url = url.substring(0, index) + decodeUrl;
		}

		TreeMap<String, String> map = new TreeMap<>();
		map.put("noncestr", noncestr);
		map.put("timestamp", timestamp);
		map.put("jsapi_ticket", jsapi_ticket);
		map.put("url", url);

		result.put("noncestr", noncestr);
		result.put("timestamp", timestamp);
		result.put("url", url);

		StringBuilder sb = new StringBuilder();
		map.forEach((k, v) -> {
			sb.append(k).append("=").append(v).append("&");
		});
		String plain = sb.toString().substring(0, sb.length() - 1);

		try {
			MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
			sha1.reset();
			sha1.update(plain.getBytes("UTF-8"));
			result.put("sign", bytesToHex(sha1.digest()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return result;

	}

	private static String bytesToHex(byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

}
