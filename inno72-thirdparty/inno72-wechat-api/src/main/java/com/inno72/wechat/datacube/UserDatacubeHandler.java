package com.inno72.wechat.datacube;

import java.time.LocalDate;

import com.inno72.wechat.ApiUrl.DatacubeUser;
import com.inno72.wechat.common.Invoke;

/**
 * 用户统计数据接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class UserDatacubeHandler {

	/**
	 * 获取用户增减数据<br>
	 * 最大时间跨度为7
	 * 
	 * @param token
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getusersummary(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 7)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DatacubeUser.Summary.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取累计用户数据<br>
	 * 最大时间跨度为7
	 * 
	 * @param token
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getusercumulate(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 7)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DatacubeUser.Summary.url(), json, token);
		}
		return null;
	}

}
