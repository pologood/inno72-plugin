package com.point72.wechat.boot;

import lombok.Data;

@Data
public class WechatInfo {

	private String appId;
	private String token;
	private String encodingAESKey;
	private String payCode;
	private String secret;
	private String mchId;
	private String certPath;

	public WechatInfo(String appId, String secret, String token, String encodingAESKey, String mchId, String payCode,
			String certPath) {
		this.appId = appId;
		this.token = token;
		this.encodingAESKey = encodingAESKey;
		this.payCode = payCode;
		this.secret = secret;
		this.mchId = mchId;
		this.certPath = certPath;
	}

}
