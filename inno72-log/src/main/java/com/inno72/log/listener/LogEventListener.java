package com.inno72.log.listener;

import com.inno72.log.plugin.Inno72JsonAllPatternLayout;
import com.inno72.log.plugin.Inno72JsonPatternLayout;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.flume.appender.FlumeAppender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LogEventListener implements ApplicationListener<ContextRefreshedEvent> {

	@Value("${inno72.log.props.channelCapacity}")
	String channelCapacity;
	@Value("${inno72.log.props.channelTransactionCapacity}")
	String channelTransactionCapacity;
	@Value("${inno72.log.props.agent}")
	String agent;
	@Value("${inno72.log.props.hostname}")
	String hostname;
	@Value("${inno72.log.props.port}")
	String port;
	@Value("${inno72.log.props.batchSize}")
	String batchSize;
	@Value("${inno72.log.props.layout}")
	String layout;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		if (agent != null) {
			Logger avroLogger = (Logger) LogManager.getLogger("com.inno72");
			Configuration config = avroLogger.getContext().getConfiguration();

			Logger druidLogger = (Logger) LogManager.getLogger("druid.sql.Statement");

			FlumeAppender avroAppender = null;

			Property[] properties = {Property.createProperty("channel.type", "memory"),
					Property.createProperty("channel.capacity", channelCapacity),
					Property.createProperty("channel.transactionCapacity", channelTransactionCapacity),
					Property.createProperty("sinks", agent),
					Property.createProperty(agent + ".type", "avro"),
					Property.createProperty(agent + ".hostname", hostname),
					Property.createProperty(agent + ".port", port),
					Property.createProperty(agent + ".batch-size", batchSize),
					Property.createProperty("processor.type", "failover")};

			if (StringUtils.isNotEmpty(layout) && layout.equals("Inno72JsonPatternLayout")) {
				Inno72JsonPatternLayout inno72JsonPatternLayout = new Inno72JsonPatternLayout(config, null, null, null,
						null, true, false, null, null);
				avroAppender = FlumeAppender
						.createAppender(null, properties, null, "false", "Embedded", null, "1000", "1000", "1", "1000",
								"FlumeAppender", null, null, null, null, null, null, "false", "100", null, null,
								inno72JsonPatternLayout, null);
			} else if (StringUtils.isNotEmpty(layout) && layout.equals("Inno72JsonAllPatternLayout")) {
				Inno72JsonAllPatternLayout inno72JsonPatternLayout = new Inno72JsonAllPatternLayout(config, null, null,
						null, null, true, false, null, null);
				avroAppender = FlumeAppender
						.createAppender(null, properties, null, "false", "Embedded", null, "1000", "1000", "1", "1000",
								"FlumeAppender", null, null, null, null, null, null, "false", "100", null, null,
								inno72JsonPatternLayout, null);
			}

			avroAppender.start();

			Map<String, Appender> appenders = avroLogger.getAppenders();
			for (String s : appenders.keySet()) {
				avroLogger.addAppender(appenders.get(s));
			}

			avroLogger.addAppender(avroAppender);
			avroLogger.setLevel(Level.INFO);
			avroLogger.setAdditive(false);

			druidLogger.addAppender(avroAppender);
			druidLogger.setLevel(Level.DEBUG);
			druidLogger.setAdditive(false);
		}
	}

}