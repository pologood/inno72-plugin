package com.inno72.ddtalk.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * 企业会话消息接口请求数据模型
 * 
 * @author Houkm
 *
 *         2017年6月28日
 */

@Data
public class CorpChatRequestModel extends AbstractRestRequestModel {

	protected String msgtype;
	protected String agent_id;
	protected String userid_list;
	protected boolean to_all_user = false;
	protected String msgcontent = null;

	protected List<String> users = new ArrayList<>();

	public void addUser(String userId) {
		this.users.add(userId);
	}

	public void addUser(List<String> userId) {
		this.users.addAll(userId);
	}

	@Override
	public String setMethod() {
		return "dingtalk.corp.message.corpconversation.asyncsend";
	}

	public CorpChatRequestModel(String token) {
		super(token);
	}

	@Override
	public Map<String, String> toRequestParam() {
		StringBuilder sb = new StringBuilder();
		this.users.forEach(user -> {
			sb.append(user).append(",");
		});
		this.userid_list = sb.toString();
		return super.toRequestParam();
	}

}
