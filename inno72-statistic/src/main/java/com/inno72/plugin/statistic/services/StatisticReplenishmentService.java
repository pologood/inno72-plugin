package com.inno72.plugin.statistic.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;
import java.util.zip.DataFormatException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("StatisticReplenishmentService")
public class StatisticReplenishmentService implements StatisticService {

	@Resource
	private DataSource ds;

	Logger logger = LoggerFactory.getLogger(StatisticReplenishmentService.class);

	public void service(Map<String, Object> infos) throws DataFormatException {

		try {
			String machineCode = (String) infos.get("machineCode");
			String goodsId = (String) infos.get("goodsId");
			String channelId = (String) infos.get("channelId");
			String activityId = (String) infos.get("activityId");
			String localId = (String) infos.get("localId");
			int beforeNum = (Integer) infos.get("beforeNum");
			int afterNum = (Integer) infos.get("afterNum");
			String userId = (String) infos.get("userId");
			String areaId = (String) infos.get("areaId");
			Date time = (Date) infos.get("time");
			
			insertReplenishment(machineCode, goodsId, channelId, activityId, localId, beforeNum, afterNum, userId, areaId, time);
			
		} catch (RuntimeException e) {
			logger.error(e.getMessage(), e);
			throw new DataFormatException(e.getMessage());
		}
	}


	private void insertReplenishment(String machineCode, String goodsId, String channelId, String activityId,
			String localId, int beforeNum, int afterNum, String userId, String areaId, Date time) {


		Connection conn = null;
		PreparedStatement stm = null;
		try {
			conn = ds.getConnection();
			stm = conn.prepareStatement("insert into inno72_statistic_replenishment("
					+ "machine_code, goods_id, channel_id, activity_id, local_id, "
					+ "before_num, after_num, user_id, area_id, time, update_time)"
					+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			stm.setString(1, machineCode);
			stm.setString(2, goodsId);
			stm.setString(3, channelId);
			stm.setString(4, activityId);
			stm.setString(5, localId);
			stm.setInt(6, beforeNum);
			stm.setInt(7, afterNum);
			stm.setString(8, userId);
			stm.setString(9, areaId);
			if (time == null)
				stm.setDate(10, null);
			else
				stm.setDate(10, new java.sql.Date(time.getTime()));
			stm.setDate(11, new java.sql.Date(System.currentTimeMillis()));
			stm.execute();
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		} finally {
			try {
				if (stm != null) stm.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
			}
		}
	}

}
