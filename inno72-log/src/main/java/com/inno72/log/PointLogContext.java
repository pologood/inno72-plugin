package com.inno72.log;

import org.apache.logging.log4j.ThreadContext;

import com.inno72.log.vo.AbstractLog;
import com.inno72.log.vo.LogType;
import com.inno72.log.vo.PointLog;
import com.inno72.log.vo.SysLog;

/**
 * 日志上下文
 */
public class PointLogContext {

	private AbstractLog abstractLog;
	private LogType logType;

	public PointLogContext(LogType logType) {
		if (logType == LogType.SYS) {
			abstractLog = new SysLog();
		} else {
			abstractLog = new PointLog();
		}
		abstractLog.setLogType(logType.val());
	}

	public PointLogContext tag(String tag) {
		abstractLog.setTag(tag);
		return this;
	}

	public PointLogContext machineCode(String machineCode) {
		if (abstractLog instanceof PointLog) {
			PointLog pointLog = (PointLog) abstractLog;
			pointLog.setMachineCode(machineCode);
		}
		return this;
	}

	public PointLogContext type(String type) {
		PointLog pointLog = (PointLog) abstractLog;
		pointLog.setType(type);
		return this;
	}

	public PointLogContext pointTime(String time) {
		PointLog pointLog = (PointLog) abstractLog;
		pointLog.setPointTime(time);
		return this;
	}

	public PointLogContext detail(String detail) {
		if (abstractLog instanceof PointLog) {
			PointLog pointLog = (PointLog) abstractLog;
			pointLog.setDetail(detail);
		}
		return this;
	}

	public void bulid() {
		ThreadContext.put("logInfo", abstractLog.toString());
	}

}
