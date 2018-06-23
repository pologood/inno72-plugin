package com.framelib.dubbo.doctor;

public enum NetStatusEnum {
	
	WIFI("WIFI","WIFI"),TG("2G","2G网络"),THG("3G","3G网络"),FG("4G","4G网络"),OFFLINE("OFFLINE","OFFLINE");

	private String key;
	private String value;

	NetStatusEnum(String key,String value){
		this.key = key;
		this.value =value;
	}

	public String getKey() { return key; }
	public String getValue() { return value; }
}
