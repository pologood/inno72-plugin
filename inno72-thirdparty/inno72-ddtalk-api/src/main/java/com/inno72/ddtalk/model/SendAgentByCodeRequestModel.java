package com.inno72.ddtalk.model;

import com.inno72.ddtalk.ApiUrl;

import lombok.Data;

@Data

/**
 * 通过用户授权码异步向企业会话发送消息
 * 
 * @author Houkm
 *
 *         2017年9月11日
 */
public class SendAgentByCodeRequestModel extends SendAgentRequestModel {

	private String code;

	@Override
	public String setMethod() {
		return ApiUrl.Message.Send_AgentByCode.method();
	}

	public SendAgentByCodeRequestModel(String token, String code, String msgType, boolean toAll, String agentId,
			String[] userIdList, String[] deptIdList, String content) {
		super(token, msgType, toAll, agentId, userIdList, deptIdList, content);
		this.code = code;
	}

}
