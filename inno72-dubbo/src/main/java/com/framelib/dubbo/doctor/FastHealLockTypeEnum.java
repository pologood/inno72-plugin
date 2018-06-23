package com.framelib.dubbo.doctor;

public enum FastHealLockTypeEnum{
	L(1,"锁定查询"),N(2,"不锁定查询"),T(3,"测试");

	private Integer key;
	private String value;

	FastHealLockTypeEnum(Integer key,String value){
		this.key = key;
		this.value =value;
	}

	public Integer getKey() { return key; }
	public String getValue() { return value; }
}
