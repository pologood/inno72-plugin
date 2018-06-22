package com.point72.ddtalk.model;

import lombok.Data;

@Data
public class AbstractCallbackModel {

	private String EventType;
	private String TimeStamp;
	private String CorpId;
	private String UserId;

}
