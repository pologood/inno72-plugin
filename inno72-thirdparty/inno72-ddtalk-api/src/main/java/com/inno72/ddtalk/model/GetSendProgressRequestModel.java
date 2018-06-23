package com.inno72.ddtalk.model;

import com.inno72.ddtalk.ApiUrl.Message;

import lombok.Data;

@Data
/**
 * 获取异步发送企业会话消息的发送进度
 * 
 * @author Houkm
 *
 *         2017年9月11日
 */
public class GetSendProgressRequestModel extends AbstractRestRequestModel {

	protected String task_id;
	protected String agent_id;

	@Override
	public String setMethod() {
		return Message.Get_Send_Progress.method();
	}

	private GetSendProgressRequestModel(String token) {
		super(token);
	}

	public GetSendProgressRequestModel(String token, String taskId, String agentId) {
		super(token);
		this.task_id = taskId;
		this.agent_id = agentId;
	}

}
