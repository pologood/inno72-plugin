package com.inno72.wechat.card;

import com.inno72.wechat.common.BaseModel;

public class GiftCard extends BaseModel {
	private String card_type = "GIFT";

	private Gift gift;

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

}
