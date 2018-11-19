package com.inno72.plugin.statistic.services;

import java.util.Map;
import java.util.zip.DataFormatException;

public interface StatisticService {
	
	public void service(Map<String, Object> infos) throws DataFormatException;

}
