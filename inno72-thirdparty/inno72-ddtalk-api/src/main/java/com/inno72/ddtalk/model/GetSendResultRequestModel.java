package com.inno72.ddtalk.model;

import com.inno72.ddtalk.ApiUrl.Message;

import lombok.Data;

/**
 * 获取异步向企业会话发送消息的结果
 * 
 * @author Houkm
 *
 *         2017年9月11日
 */
@Data
public class GetSendResultRequestModel extends AbstractRestRequestModel {

	protected String task_id;
	protected String agent_id;

	@Override
	public String setMethod() {
		return Message.Get_Send_Result.method();
	}

	private GetSendResultRequestModel(String token) {
		super(token);
	}

	public GetSendResultRequestModel(String token, String taskId, String agentId) {
		super(token);
		this.task_id = taskId;
		this.agent_id = agentId;
	}

}
