package com.inno72.log.vo;

public enum LogType {

	SYS("sys"), PRODUCT("product"), BIZ("biz"), POINT("point");

	private String val;

	LogType(String val) {
		this.val = val;
	}

	public String val() {
		return val;
	}

	public static void main(String[] args) {
		System.out.println(LogType.BIZ.val());
	}
}
