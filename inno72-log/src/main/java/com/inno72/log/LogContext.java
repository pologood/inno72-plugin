package com.inno72.log;

import com.inno72.log.vo.AbstractLog;
import com.inno72.log.vo.BizLog;
import com.inno72.log.vo.LogType;
import com.inno72.log.vo.SysLog;
import org.apache.logging.log4j.ThreadContext;

/**
 * 日志上下文
 */
public class LogContext {
	private AbstractLog abstractLog;
	private LogType logType;
	private String tag = "";

	private String userId = "";
	private String operatorId = "";
	private String activityId = "";

	public LogContext(LogType logType) {
		if (logType == LogType.SYS) {
			abstractLog = new SysLog();
		} else {
			abstractLog = new BizLog();
		}
		abstractLog.setLogType(logType.val());
	}

	public LogContext tag(String tag) {
		abstractLog.setTag(tag);
		return this;
	}

	public LogContext userId(String userId) {
		if (abstractLog instanceof BizLog) {
			BizLog bizLog = (BizLog) abstractLog;
			bizLog.setUserId(userId);
		}
		return this;
	}

	public LogContext operatorId(String operatorId) {
		if (abstractLog instanceof BizLog) {
			BizLog bizLog = (BizLog) abstractLog;
			bizLog.setOperatorId(operatorId);
		}
		return this;
	}

	public LogContext activityId(String activityId) {
		if (abstractLog instanceof BizLog) {
			BizLog bizLog = (BizLog) abstractLog;
			bizLog.setActivityId(activityId);
		}
		return this;
	}

	public LogContext detail(String detail) {
		if (abstractLog instanceof BizLog) {
			BizLog bizLog = (BizLog) abstractLog;
			bizLog.setDetail(detail);
		}
		return this;
	}

	public void bulid() {
		ThreadContext.put("logInfo", abstractLog.toString());
	}

}
