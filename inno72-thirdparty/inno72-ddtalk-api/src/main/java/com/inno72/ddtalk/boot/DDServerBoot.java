package com.inno72.ddtalk.boot;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.inno72.ddtalk.tools.SignHelper;
import com.inno72.ddtalk.util.aes.DingTalkEncryptException;
import com.inno72.ddtalk.util.aes.DingTalkEncryptor;

/**
 * 钉钉回调接口抽象
 * 
 * @author Houkm
 *
 *         2017年9月11日
 */
public abstract class DDServerBoot {

	@Resource
	private CallbackHandler callbackHandler;

	/**
	 * 解析数据并交由事件处理器处理
	 * 
	 * @param data
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	@RequestMapping("/callback")
	public String callback(@RequestBody String data, String signature, String timestamp, String nonce) {

		JSONObject jsonEncrypt = JSONObject.parseObject(data);
		String encrypt = jsonEncrypt.getString("encrypt");
		DingTalkEncryptor encryptor = null;
		String plainText = null;
		try {
			encryptor = new DingTalkEncryptor(token(), encodingAesKey(), corpId());
			plainText = encryptor.getDecryptMsg(signature, timestamp, nonce, encrypt);
			callbackHandler.process(plainText);
		} catch (DingTalkEncryptException e) {
			e.printStackTrace();
		}
		return "success";
	}

	/**
	 * jssdk config签名
	 * 
	 * @param url
	 * @return
	 * @author Houkm 2017年9月12日
	 */
	@RequestMapping("/jsconfig")
	public Map<String, String> jsConfig(String url) {
		Map<String, String> map = new HashMap<>();
		url = url.substring(0, url.indexOf("#"));
		String uri = url.substring(url.indexOf("?") + 1);
		try {
			url = url.replace(uri, URLDecoder.decode(uri, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		map = SignHelper.jsConfig(getJsTicket(), url);
		return map;
	}

	public abstract String token();

	public abstract String encodingAesKey();

	public abstract String corpId();

	public abstract String getJsTicket();

}
