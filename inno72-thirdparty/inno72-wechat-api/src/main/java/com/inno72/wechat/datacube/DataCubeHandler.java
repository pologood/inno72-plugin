package com.inno72.wechat.datacube;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class DataCubeHandler {

	static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	static Logger logger = LoggerFactory.getLogger(DataCubeHandler.class);

	/**
	 * 生成获取统计数据接口的json数据
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	protected static String json(LocalDate start, LocalDate end) {
		JSONObject json = new JSONObject();
		json.put("begin_date", start.format(formatter));
		json.put("end_date", end.format(formatter));
		return json.toJSONString();
	}

	/**
	 * 检查时间跨度
	 * 
	 * @param start
	 * @param end
	 * @param span
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	protected static boolean checkSpan(LocalDate start, LocalDate end, int span) {
		long l = start.until(end, ChronoUnit.DAYS);
		boolean b = l <= 0 ? false : l <= span ? true : false;
		if (!b) {
			logger.error("接口支持最大时间跨度为: {}, 传入参数时间跨度为: {}", span, l);
		}
		return b;
	}

}
