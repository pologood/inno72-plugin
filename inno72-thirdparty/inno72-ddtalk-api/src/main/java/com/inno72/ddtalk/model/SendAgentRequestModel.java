package com.inno72.ddtalk.model;

import com.inno72.ddtalk.ApiUrl.Message;

import lombok.Data;

@Data

/**
 * 企业会话消息异步发送
 * 
 * @author Houkm
 *
 *         2017年9月11日
 */
public class SendAgentRequestModel extends AbstractRestRequestModel {

	private String msgtype;
	private String agent_id;
	private String[] userid_list;
	private String[] dept_id_list;
	private boolean to_all_user;
	private String msgcontent;

	@Override
	public String setMethod() {
		return Message.Send_Agent.method();
	}

	private SendAgentRequestModel(String token) {
		super(token);
	}

	public SendAgentRequestModel(String token, String msgType, boolean toAll, String agentId, String[] userIdList,
			String[] deptIdList, String content) {
		super(token);
		this.to_all_user = toAll;
		this.agent_id = agentId;
		this.userid_list = userIdList;
		this.dept_id_list = deptIdList;
		this.msgcontent = content;
		this.msgtype = msgType;
	}

}
