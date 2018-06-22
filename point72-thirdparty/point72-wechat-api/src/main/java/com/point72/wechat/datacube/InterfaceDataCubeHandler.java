package com.point72.wechat.datacube;

import java.time.LocalDate;

import com.point72.wechat.ApiUrl.DataCubeInterface;
import com.point72.wechat.common.Invoke;

public class InterfaceDataCubeHandler {
	/**
	 * 获取接口分析数据<br>
	 * 最大时间跨度为30
	 * 
	 * @param token
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getinterfacesummary(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 30)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DataCubeInterface.Summary.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取接口分析分时数据<br>
	 * 最大时间跨度为1
	 * 
	 * @param token
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getinterfacesummaryhour(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 1)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DataCubeInterface.Summary_Hour.url(), json, token);
		}
		return null;
	}
}
