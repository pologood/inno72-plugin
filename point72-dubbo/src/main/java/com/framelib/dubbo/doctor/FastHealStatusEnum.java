package com.framelib.dubbo.doctor;

/**
 * 状态枚举
 */
public enum FastHealStatusEnum {

	// 正常
	Ok("0"),
	// 下线
	DOWN("1"),
	// 锁定
	LOCK("2"),
	//派单
	ACCEPT("3");

	private String v;

	private FastHealStatusEnum(String v) {
		this.v = v;
	}

	public String v() {
		return this.v;
	}
}
