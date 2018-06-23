package com.inno72.wechat.card;

import com.inno72.wechat.common.BaseModel;

public class GeneralCouponCard extends BaseModel {
	private String card_type = "GENERAL_COUPON";

	private GeneralCoupon general_coupon;

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public GeneralCoupon getGeneral_coupon() {
		return general_coupon;
	}

	public void setGeneral_coupon(GeneralCoupon general_coupon) {
		this.general_coupon = general_coupon;
	}

}
