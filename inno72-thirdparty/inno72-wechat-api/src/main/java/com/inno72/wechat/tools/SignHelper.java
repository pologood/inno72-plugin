package com.inno72.wechat.tools;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class SignHelper {

	private static SecretKeySpec key = null;

	public static String sha1(String sign) {
		return digest("sha1", sign, "UTF-8");
	}

	public static String sha1(String sign, String encoding) {
		return digest("sha1", sign, encoding);
	}

	public static String MD5(String sign) {
		return digest("MD5", sign, "UTF-8");
	}

	public static String MD5(String sign, String encoding) {
		return digest("MD5", sign, encoding);
	}

	public static String AES256ECB(String text, String pwd) {
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			if (key == null) {
				key = new SecretKeySpec(MD5(pwd).toLowerCase().getBytes(), "AES");
			}
			cipher.init(Cipher.DECRYPT_MODE, key);
			return new String(cipher.doFinal(Base64.decodeBase64(text)));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String signUrl(String ticket, String noncestr, String timsstamp, String url) {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("noncestr", noncestr);
		map.put("jsapi_ticket", ticket);
		map.put("timestamp", timsstamp);
		map.put("url", url);

		StringBuffer sb = new StringBuffer();

		map.forEach((k, v) -> {
			sb.append(k).append("=").append(v).append("&");
		});

		String str = sb.toString();
		str = str.substring(0, str.length() - 1);

		return sha1(str);
	}

	private static String digest(String type, String sign, String encoding) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance(type);
			digest.reset();
			digest.update(sign.getBytes(encoding));
			sign = BytesHandler.byteArrayToHex(digest.digest());
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sign;
	}

}
