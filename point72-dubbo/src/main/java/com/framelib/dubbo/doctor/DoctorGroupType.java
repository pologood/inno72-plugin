package com.framelib.dubbo.doctor;

/**
 * 医生分组类型枚举
 * 类型Wie组或者医生
 * 
 * @author zhouzengbao
 *
 */
public enum DoctorGroupType {
	Z(0,"组"),D(1,"医生");

	private Integer key;
	private String value;

	DoctorGroupType(Integer key, String value){
		this.key = key;
		this.value =value;
	}

	public Integer getKey() { return key; }
	public String getValue() { return value; }
}
