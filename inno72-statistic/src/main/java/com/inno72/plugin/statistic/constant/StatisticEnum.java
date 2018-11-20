package com.inno72.plugin.statistic.constant;

public enum StatisticEnum {

	REPLENISHMENT("StatisticReplenishmentService");

	private final String name; 
	
	private StatisticEnum(String name) { 
		this.name = name;
	}

	public String getName() {
		return name;
	}
	

}
