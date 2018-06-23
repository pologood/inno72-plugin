package com.inno72.wechat.pay.callback.model;

import org.dom4j.Document;

import com.inno72.wechat.pay.AbstractPayModel;

import lombok.Data;

@Data

/**
 * 扫码支付回调数据
 * 
 * @author Houkm
 *
 *         2017年9月7日
 */
public class ScanPayCallbackModel extends AbstractPayModel {
	public ScanPayCallbackModel() {
		super();
	}

	public ScanPayCallbackModel(Document doc, String keycode) {
		super(doc, keycode);
	}

	public String appid;
	public String openid;
	public String mch_id;
	public String is_subscribe;
	public String nonce_str;
	public String product_id;
	public String sign;
}
