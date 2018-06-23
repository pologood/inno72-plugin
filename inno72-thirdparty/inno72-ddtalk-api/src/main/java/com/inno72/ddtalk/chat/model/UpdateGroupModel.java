package com.inno72.ddtalk.chat.model;

import java.util.List;

public class UpdateGroupModel {
	private String chatid;
	private String name;
	private String owner;
	private List<String> add_useridlist;
	private List<String> del_useridlist;

	public UpdateGroupModel(String chatid, String name, String owner, List<String> add_useridlist,
			List<String> del_useridlist) {
		this.name = name;
		this.owner = owner;
		this.chatid = chatid;
		this.add_useridlist = add_useridlist;
		this.del_useridlist = del_useridlist;
	}

	public String getChatid() {
		return chatid;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

	public List<String> getAdd_useridlist() {
		return add_useridlist;
	}

	public List<String> getDel_useridlist() {
		return del_useridlist;
	}

}