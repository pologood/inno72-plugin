package com.point72.ddtalk.data;

import com.alibaba.fastjson.JSON;
import com.point72.ddtalk.ApiUrl.Data;
import com.point72.ddtalk.Invoke;

/**
 * 统计数据接口
 * 
 * @author Houkm
 *
 *         2017年9月12日
 */
public class DataHandler {

	/**
	 * 记录统计数据
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2017年9月12日
	 */
	public static String record(String token, RecordDataModel model) {
		return Invoke.post(Data.Record.url(), JSON.toJSONString(model), token);
	}

	/**
	 * 更新统计数据
	 * 
	 * @param token
	 * @param model
	 * @return
	 * @author Houkm 2017年9月12日
	 */
	public static String update(String token, UpdateDataModel model) {
		return Invoke.post(Data.Update.url(), JSON.toJSONString(model), token);
	}

}
