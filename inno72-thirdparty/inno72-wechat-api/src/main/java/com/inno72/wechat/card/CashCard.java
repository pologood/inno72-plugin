package com.inno72.wechat.card;

import com.inno72.wechat.common.BaseModel;

public class CashCard extends BaseModel {

	private String card_type = "CASH";

	private Cash cash;

	public String getCard_type() {
		return card_type;
	}

	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}

}
