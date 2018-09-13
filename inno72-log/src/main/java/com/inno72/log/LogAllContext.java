package com.inno72.log;

import com.inno72.log.vo.*;
import org.apache.logging.log4j.ThreadContext;

/**
 * 日志上下文
 */
public class LogAllContext {
	private AbstractLogAll abstractLogAll;
	private LogType logType;
	private String tag = "";

	private String userId = "";
	private String operatorId = "";
	private String activityId = "";

	public LogAllContext(LogType logType) {
		if (logType == LogType.SYS) {
			abstractLogAll = new SysLogAll();
		} else {
			abstractLogAll = new BizLogAll();
		}
		abstractLogAll.setLogType(logType.val());
	}

	public LogAllContext platform(String platform) {
		abstractLogAll.setPlatform(platform);
		return this;
	}

	public LogAllContext appName(String appName) {
		abstractLogAll.setAppName(appName);
		return this;
	}

	public LogAllContext instanceName(String instanceName) {
		abstractLogAll.setInstanceName(instanceName);
		return this;
	}

	public LogAllContext level(String level) {
		abstractLogAll.setLevel(level);
		return this;
	}

	public LogAllContext time(String time) {
		abstractLogAll.setTime(time);
		return this;
	}

	public LogAllContext tag(String tag) {
		abstractLogAll.setTag(tag);
		return this;
	}

	public LogAllContext userId(String userId) {
		if (abstractLogAll instanceof BizLogAll) {
			BizLogAll bizLog = (BizLogAll) abstractLogAll;
			bizLog.setUserId(userId);
		}
		return this;
	}

	public LogAllContext operatorId(String operatorId) {
		if (abstractLogAll instanceof BizLogAll) {
			BizLogAll bizLog = (BizLogAll) abstractLogAll;
			bizLog.setOperatorId(operatorId);
		}
		return this;
	}

	public LogAllContext activityId(String activityId) {
		if (abstractLogAll instanceof BizLogAll) {
			BizLogAll bizLog = (BizLogAll) abstractLogAll;
			bizLog.setActivityId(activityId);
		}
		return this;
	}

	public LogAllContext detail(String detail) {
		if (abstractLogAll instanceof BizLogAll) {
			BizLogAll bizLog = (BizLogAll) abstractLogAll;
			bizLog.setDetail(detail);
		}
		return this;
	}

	public void bulid() {
		ThreadContext.put("logInfo", abstractLogAll.toString());
	}

}
