package com.inno72.log.plugin;

import com.alibaba.fastjson.JSON;
import com.inno72.log.util.FastJsonUtils;
import com.inno72.log.util.IpPortUtils;
import com.inno72.log.util.PropertiesUtil;
import com.inno72.log.vo.*;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Node;
import org.apache.logging.log4j.core.config.plugins.*;
import org.apache.logging.log4j.core.layout.AbstractStringLayout;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.apache.logging.log4j.core.layout.PatternSelector;
import org.apache.logging.log4j.core.pattern.RegexReplacement;

import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Inno72 统一日志格式
 */
@Plugin(name = "Inno72JsonPatternLayout", category = Node.CATEGORY, elementType = Layout.ELEMENT_TYPE, printObject = true)
public class Inno72JsonPatternLayout extends AbstractStringLayout {

	private PatternLayout patternLayout;
	private String platform = "java";
	private String instanceName = IpPortUtils.getIpAddressAndPort();
	private static String appName = getAppName();

	public Inno72JsonPatternLayout(Configuration config, RegexReplacement replace, String eventPattern,
			PatternSelector patternSelector, Charset charset, boolean alwaysWriteExceptions, boolean noConsoleNoAnsi,
			String headerPattern, String footerPattern) {
		super(config, charset, PatternLayout
				.createSerializer(config, replace, headerPattern, null, patternSelector, alwaysWriteExceptions,
						noConsoleNoAnsi), PatternLayout
				.createSerializer(config, replace, footerPattern, null, patternSelector, alwaysWriteExceptions,
						noConsoleNoAnsi));

		this.patternLayout = PatternLayout.newBuilder().withPattern(eventPattern).withPatternSelector(patternSelector)
				.withConfiguration(config).withRegexReplacement(replace).withCharset(charset)
				.withAlwaysWriteExceptions(alwaysWriteExceptions).withNoConsoleNoAnsi(noConsoleNoAnsi)
				.withHeader(headerPattern).withFooter(footerPattern).build();
	}

	@Override
	public String toSerializable(LogEvent event) {
		//在这里处理日志内容
		String message = patternLayout.toSerializable(event);
		String formatTime = format(event.getTimeMillis());

		String sysLogStr = event.getContextData().getValue("logInfo");

		ThreadContext.clearMap();

		if (StringUtils.isNotEmpty(message)) {
			// 所有select 操作都不做处理
			if (message.contains("SELECT") || message.contains("select")) {
				return "";
			}
			if ((message.contains("executed") && !message.contains("LAST_INSERT_ID")
					&& !message.contains("SELECT")) || (message.contains("<==    Updates"))) {
				return new JsonSysLoggerInfo(LogType.SYS.val(), platform, appName, instanceName,
						event.getLevel().name(), formatTime, "", message).toString() + "\n";
			}
		}

		AbstractLog  abstractLog = null;
		if (StringUtils.isNotEmpty(sysLogStr)) {
			String logType = FastJsonUtils.getString(sysLogStr, "logType");
			if (StringUtils.isNotEmpty(logType)) {
				if (logType.equals(LogType.SYS.val())) {
					abstractLog = FastJsonUtils.toObject(sysLogStr, SysLog.class);
				} else if (logType.equals(LogType.POINT.val())){
					abstractLog = FastJsonUtils.toObject(sysLogStr, PointLog.class);
				} else {
					abstractLog = FastJsonUtils.toObject(sysLogStr, BizLog.class);
				}
			}
		}

		String jsonStr = "";
		if (abstractLog != null) {

			if (abstractLog instanceof SysLog) {

				SysLog sysLog = (SysLog) abstractLog;
				jsonStr = new JsonSysLoggerInfo(sysLog.getLogType(), platform, appName, instanceName,
						event.getLevel().name(), formatTime, sysLog.getTag(), message).toString();

			} else if (abstractLog instanceof BizLog) {

				BizLog bizLog = (BizLog) abstractLog;
				jsonStr = new JsonBizLoggerInfo(bizLog.getLogType(), platform, appName, instanceName,
						event.getLevel().name(), formatTime, bizLog.getTag(), abstractLog.getDetail(),
						bizLog.getUserId(), bizLog.getOperatorId(), bizLog.getActivityId()).toString();

			} else if (abstractLog instanceof PointLog) {

				PointLog pointLog = (PointLog) abstractLog;
				jsonStr = jsonStr = new JsonPointLoggerInfo(
						pointLog.getLogType(), pointLog.getTag(), pointLog.getDetail(),
						pointLog.getMachineCode(), pointLog.getType(),
						pointLog.getPointTime()).toString();
			}

		} else {
			// 没有 LogContext 设置的当做系统级日志处理
			jsonStr = new JsonSysLoggerInfo(LogType.SYS.val(), platform, appName, instanceName,
					event.getLevel().name(), formatTime, "", message).toString();
			return jsonStr + "\n";
		}
		return jsonStr + "\n";
	}

	@PluginFactory
	public static Inno72JsonPatternLayout createLayout(
			@PluginAttribute(value = "pattern", defaultString = PatternLayout.DEFAULT_CONVERSION_PATTERN) final String pattern,
			@PluginElement("PatternSelector") final PatternSelector patternSelector,
			@PluginConfiguration final Configuration config, @PluginElement("Replace") final RegexReplacement replace,
			// LOG4J2-783 use platform default by default, so do not specify defaultString for charset
			@PluginAttribute(value = "charset") final Charset charset,
			@PluginAttribute(value = "alwaysWriteExceptions", defaultBoolean = true) final boolean alwaysWriteExceptions,
			@PluginAttribute(value = "noConsoleNoAnsi", defaultBoolean = false) final boolean noConsoleNoAnsi,
			@PluginAttribute("header") final String headerPattern,
			@PluginAttribute("footer") final String footerPattern, @PluginAttribute("appName") final String appName) {


		return new Inno72JsonPatternLayout(config, replace, pattern, patternSelector, charset, alwaysWriteExceptions,
				noConsoleNoAnsi, headerPattern, footerPattern);
	}

	public static String format(Long time) {
		Date date = new Date();
		date.setTime(time);
		String returnValue = "";
		if (date != null) {
			// 修改时间格式 为挺高es查询效率
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			returnValue = df.format(date);
		}
		return returnValue;
	}

	public static String getAppName() {
		String logAppName = new PropertiesUtil("application.properties").readProperty("inno72.log.appname");
		if (StringUtils.isNotEmpty(logAppName)) {
			return logAppName;
		}
		String applicationName = new PropertiesUtil("bootstrap.properties").readProperty("spring.application.name");
		return applicationName;
	}
}