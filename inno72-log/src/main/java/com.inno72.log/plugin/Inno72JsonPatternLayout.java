package com.inno72.log.plugin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inno72.log.util.IpPortUtils;
import com.inno72.log.util.JsonUtil;
import com.inno72.log.vo.SysLog;
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

import javax.management.MalformedObjectNameException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Inno72 统一日志格式
 * @author gaoxingang
 * @date 2018/7/16
 */
@Plugin(name = "Inno72JsonPatternLayout", category = Node.CATEGORY, elementType = Layout.ELEMENT_TYPE, printObject = true)
public class Inno72JsonPatternLayout extends AbstractStringLayout {
	/** 项目路径 */

	private PatternLayout patternLayout;
	private String platform = "java";
	private String appName;
	private String logType;
	private String tag;
	private String instanceName;


	private Inno72JsonPatternLayout(Configuration config, RegexReplacement replace, String eventPattern,
			PatternSelector patternSelector, Charset charset, boolean alwaysWriteExceptions, boolean noConsoleNoAnsi,
			String headerPattern, String footerPattern, String appName) {
		super(config, charset, PatternLayout
				.createSerializer(config, replace, headerPattern, null, patternSelector, alwaysWriteExceptions,
						noConsoleNoAnsi), PatternLayout
				.createSerializer(config, replace, footerPattern, null, patternSelector, alwaysWriteExceptions,
						noConsoleNoAnsi));

		this.appName = appName;
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

		String sysLogStr = event.getContextData().getValue("sysLog");
		ThreadContext.clearMap();
		if (StringUtils.isNotEmpty(sysLogStr)) {
			// SysLog sysLog = JsonUtil.toObject(sysLogStr, SysLog.class);
			//tag = sysLog.getTag();
			//logType = sysLog.getLogType();
		} else {
			tag = "";
			logType = "";
		}

		try {
			instanceName = IpPortUtils.getIpAddressAndPort();
		} catch (MalformedObjectNameException e) {
			e.printStackTrace();
		}
		//		if (StringUtils.isEmpty(logType)) { // logType 默认为系统日志
		//			logType = "sys";
		//		}

		String jsonStr = new JsonLoggerInfo(platform, appName, instanceName, message, event.getLevel().name(), logType,
				formatTime, tag).toString();
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
				noConsoleNoAnsi, headerPattern, footerPattern, appName);
	}

	/**
	 * 输出的日志内容
	 */
	public static class JsonLoggerInfo {
		/** 平台 */
		private String platform;
		/** 实例名称 */
		private String instanceName;
		/** 项目名 */
		private String appName;
		/** 日志信息 */
		private String detail;
		/** 日志级别 */
		private String level;
		/** 日志分类 */
		private String logType;
		/** 日志时间 */
		private String time;
		/** 标签 */
		private String tag;

		public JsonLoggerInfo(String platform, String appName, String instanceName, String detail, String level,
				String logType, String time, String tag) {
			this.platform = platform;
			this.appName = appName;
			this.instanceName = instanceName;
			this.detail = detail;
			this.level = level;
			this.logType = logType;
			this.time = time;
			this.tag = tag;
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


	/**
	 * 使用参数Format格式化Date成字符串
	 *
	 * @param time 毫秒
	 * @return
	 *
	 */
	public static String format(Long time) {
		Date date = new Date();
		date.setTime(time);
		String returnValue = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			returnValue = df.format(date);
		}
		return returnValue;
	}
}