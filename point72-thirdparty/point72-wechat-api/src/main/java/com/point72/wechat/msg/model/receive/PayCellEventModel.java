package com.point72.wechat.msg.model.receive;

import com.point72.wechat.msg.model.EventMsgModel;

public class PayCellEventModel extends EventMsgModel {

	private String CardId;
	private String UserCardCode;
	private String TransId;
	private String LocationName;
	private String Fee;
	private String OriginalFee;

	@Override
	public void setEvent() {
		Event = "user_pay_from_pay_cell";
	}

	public String getCardId() {
		return CardId;
	}

	public void setCardId(String cardId) {
		CardId = cardId;
	}

	public String getUserCardCode() {
		return UserCardCode;
	}

	public void setUserCardCode(String userCardCode) {
		UserCardCode = userCardCode;
	}

	public String getTransId() {
		return TransId;
	}

	public void setTransId(String transId) {
		TransId = transId;
	}

	public String getLocationName() {
		return LocationName;
	}

	public void setLocationName(String locationName) {
		LocationName = locationName;
	}

	public String getFee() {
		return Fee;
	}

	public void setFee(String fee) {
		Fee = fee;
	}

	public String getOriginalFee() {
		return OriginalFee;
	}

	public void setOriginalFee(String originalFee) {
		OriginalFee = originalFee;
	}

}
