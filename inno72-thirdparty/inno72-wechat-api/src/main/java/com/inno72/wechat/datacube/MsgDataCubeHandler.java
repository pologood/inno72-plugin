package com.inno72.wechat.datacube;

import java.time.LocalDate;

import com.inno72.wechat.ApiUrl.DatacubeMessage;
import com.inno72.wechat.common.Invoke;

/**
 * 消息分析数据接口
 * 
 * @author Houkm
 *
 *         2017年6月5日
 */
public class MsgDataCubeHandler {

	/**
	 * 获取消息发送概况数据<br>
	 * 最大时间跨度为7
	 * 
	 * @param token
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getupstreammsg(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 7)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DatacubeMessage.Upstream_Msg.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取消息分送分时数据<br>
	 * 最大时间跨度为1
	 * 
	 * @param token
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getupstreammsghour(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 7)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DatacubeMessage.Upstream_Msg_Hour.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取消息发送周数据<br>
	 * 最大时间跨度为30
	 * 
	 * @param token
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getupstreammsgweek(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 30)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DatacubeMessage.Upstream_Msg_Week.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取消息发送月数据<br>
	 * 最大时间跨度为30
	 * 
	 * @param token
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getupstreammsgmonth(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 30)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DatacubeMessage.Upstream_Msg_Month.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取消息发送分布数据<br>
	 * 最大时间跨度为15
	 * 
	 * @param token
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getupstreammsgdist(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 15)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DatacubeMessage.Upstream_Msg_Dist.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取消息发送分布周数据<br>
	 * 最大时间跨度为30
	 * 
	 * @param token
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getupstreammsgdistweek(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 30)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DatacubeMessage.Upstream_Msg_Dist_Week.url(), json, token);
		}
		return null;
	}

	/**
	 * 获取消息发送分布月数据<br>
	 * 最大时间跨度为30
	 * 
	 * @param token
	 * @param start
	 * @param end
	 * @return
	 * @author Houkm 2017年6月5日
	 */
	public static String getupstreammsgdistmonth(String token, LocalDate start, LocalDate end) {
		if (DataCubeHandler.checkSpan(start, end, 30)) {
			String json = DataCubeHandler.json(start, end);
			return Invoke.post(DatacubeMessage.Upstream_Msg_Dist_Month.url(), json, token);
		}
		return null;
	}

}
