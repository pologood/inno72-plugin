package com.point72.wechat.card;

import com.point72.wechat.common.BaseModel;

public class DisCountCard extends BaseModel {
	private String card_type = "DISCOUNT";

	private DisCount discount;

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public DisCount getDiscount() {
		return discount;
	}

	public void setDiscount(DisCount discount) {
		this.discount = discount;
	}

}
