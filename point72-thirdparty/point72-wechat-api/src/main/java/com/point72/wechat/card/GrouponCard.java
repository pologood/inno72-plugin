package com.point72.wechat.card;

import com.point72.wechat.common.BaseModel;

public class GrouponCard extends BaseModel {

	private String card_type = "GROUPON";

	private Groupon groupon;

	public String getCard_type() {
		return card_type;
	}

	public Groupon getGroupon() {
		return groupon;
	}

	public void setGroupon(Groupon groupon) {
		this.groupon = groupon;
	}

}
