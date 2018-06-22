package com.point72.wechat.pay.callback.model;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;

import com.point72.wechat.pay.AbstractPayModel;
import com.point72.wechat.tools.SignHelper;

import lombok.Data;

@Data

/**
 * 支付结果通知数据对象
 * 
 * @author Houkm
 *
 *         2017年9月6日
 */
public class RefundResultCallbackModel extends AbstractPayModel {

	public RefundResultCallbackModel() {
		super();
	}

	public RefundResultCallbackModel(Document doc, String keycode) {
		super(doc, keycode);
		String realXml = SignHelper.AES256ECB(req_info, keycode);
		try {
			doc = DocumentHelper.parseText(realXml);
			toModel(doc);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public String return_code;
	public String return_msg;
	public String appid;
	public String mch_id;
	public String nonce_str;
	public String req_info;

	public String transaction_id;
	public String out_trade_no;
	public String refund_id;
	public String out_refund_no;
	public String total_fee;
	public String settlement_total_fee;
	public String refund_fee;
	public String settlement_refund_fee;
	public String refund_status;
	public String success_time;
	public String refund_recv_accout;
	public String refund_account;
	public String refund_request_source;

}
