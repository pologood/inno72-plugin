package com.inno72.wechat.card;

import com.inno72.wechat.common.BaseModel;

public class Groupon extends BaseModel {

	private BaseInfo base_info;
	private AdvancedInfo advanced_info;

	private String deal_detail;

	public String getDeal_detail() {
		return deal_detail;
	}

	public void setDeal_detail(String deal_detail) {
		this.deal_detail = deal_detail;
	}

	public BaseInfo getBase_info() {
		return base_info;
	}

	public void setBase_info(BaseInfo base_info) {
		this.base_info = base_info;
	}

	public AdvancedInfo getAdvanced_info() {
		return advanced_info;
	}

	public void setAdvanced_info(AdvancedInfo advanced_info) {
		this.advanced_info = advanced_info;
	}

}
