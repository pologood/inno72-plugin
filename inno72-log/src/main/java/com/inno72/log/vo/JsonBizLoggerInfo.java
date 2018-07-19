package com.inno72.log.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBizLoggerInfo {
	/** 日志分类 */
	private String logType;
	/** 平台 */
	private String platform;
	/** 项目名 */
	private String appName;
	/** 实例名称 */
	private String instanceName;
	/** 日志级别 */
	private String level;
	/** 日志时间 */
	private String time;
	/** 标签 */
	private String tag;
	/** 日志信息 */
	private String detail;

	private String userId;
	private String operatorId;
	private String activityId;

	public JsonBizLoggerInfo(String logType, String platform, String appName, String instanceName, String level,
			String time, String tag, String detail, String userId, String operatorId, String activityId) {
		this.logType = logType;
		this.platform = platform;
		this.appName = appName;
		this.instanceName = instanceName;
		this.level = level;
		this.time = time;
		this.tag = tag;
		this.detail = detail;
		this.userId = userId;
		this.operatorId = operatorId;
		this.activityId = activityId;
	}

	public String getAppName() {
		return appName;
	}

	public String getLevel() {
		return level;
	}

	public String getLogType() {
		return logType;
	}

	public String getTime() {
		return time;
	}

	public String getDetail() {
		return detail;
	}

	public String getPlatform() {
		return platform;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public String getTag() {
		return tag;
	}

	public String getUserId() {
		return userId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public String getActivityId() {
		return activityId;
	}

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
