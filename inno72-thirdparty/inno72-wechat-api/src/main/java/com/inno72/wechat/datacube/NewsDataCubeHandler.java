package com.inno72.wechat.datacube;

import java.time.LocalDate;

import com.inno72.wechat.ApiUrl.DataCubeNews;
import com.inno72.wechat.common.Invoke;

/**
 * 图文分析数据接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class NewsDataCubeHandler {
	/**
	 * 获取图文群发每日数据<br>
	 * 最大时间跨度为1
	 * 
	 * @param token
	 *            公众号token
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getarticlesummary(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 1)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DataCubeNews.Summary.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取图文群发总数据<br>
	 * 最大时间跨度为1
	 * 
	 * @param token
	 *            公众号token
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getarticletotal(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 1)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DataCubeNews.Total.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取图文统计数据<br>
	 * 最大时间跨度为3
	 * 
	 * @param token
	 *            公众号token
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getuserread(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 3)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DataCubeNews.Read.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取图文统计分时数据<br>
	 * 最大时间跨度为1
	 * 
	 * @param token
	 *            公众号token
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getuserreadhour(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 1)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DataCubeNews.Read_Hour.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取图文分享转发数据<br>
	 * 最大时间跨度为7
	 * 
	 * @param token
	 *            公众号token
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getusershare(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 7)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DataCubeNews.Share.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取图文分享转发分时数据<br>
	 * 最大时间跨度为1
	 * 
	 * @param token
	 *            公众号token
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getusersharehour(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 1)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DataCubeNews.Share_Hour.url(), json, token);
		}
		return null;
	}
}
