package com.inno72.plugin.statistic;

import java.util.Map;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.inno72.plugin.statistic.constant.StatisticEnum;
import com.inno72.plugin.statistic.services.StatisticService;

/**
 * Hello world!
 *
 */
@Service
public class Statistic {
    
	@Autowired
	private ApplicationContext applicationContext;
	
	
	public void put(StatisticEnum e, Map<String, Object> infos) throws DataFormatException {
		StatisticService service = (StatisticService)applicationContext.getBean(e.getName());
		service.service(infos);
	}
	
}
