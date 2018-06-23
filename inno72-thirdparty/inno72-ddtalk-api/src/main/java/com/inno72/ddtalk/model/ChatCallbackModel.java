package com.inno72.ddtalk.model;

import lombok.Data;

@Data
public class ChatCallbackModel extends AbstractCallbackModel {
	private String ChatId;
	private String Owner;
	private String Title;
	private String Operator;
	private String agentId;
}
