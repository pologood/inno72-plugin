package com.inno72.ddtalk.chat.model;

import java.util.List;

public class CreateGroupModel {
	private String name;
	private String owner;
	private List<String> useridlist;

	public CreateGroupModel(String name, String owner, List<String> useridlist) {
		this.name = name;
		this.owner = owner;
		this.useridlist = useridlist;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

	public List<String> getUseridlist() {
		return useridlist;
	}
}