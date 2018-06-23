package com.inno72.xiongzhang;

public enum XiongZhangDomain {

	/**
	 * 使用该域名将访问官方指定就近的接入点
	 */
	COMMON("https://openapi.baidu.com"),

	;
	private String v;

	private XiongZhangDomain(String v) {
		this.v = v;
	}

	@Override
	public String toString() {
		return this.v;
	}

}
