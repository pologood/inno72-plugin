package com.inno72.mongo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClientOptions;

@Configuration
@EnableConfigurationProperties(MongoClientOptionsProperties.class)
public class MongoClientOptionsConfig {

	private Logger logger = LoggerFactory.getLogger(MongoClientOptionsConfig.class);

	@Autowired
	private MongoClientOptionsProperties option;

	@Bean
	public MongoClientOptions mongoClientOptions() {
		logger.info("创建mongoClientOptions");
		logger.info("socketKeepAlive:{}", option.isSocketKeepAlive());
		logger.info("connectTimeout:{}", option.getConnectTimeout());
		logger.info("maxConnectionIdleTime:{}", option.getMaxConnectionIdleTime());
		logger.info("maxConnectionLifeTime:{}", option.getMaxConnectionLifeTime());
		logger.info("maxWaitTime:{}", option.getMaxWaitTime());
		logger.info("socketTimeout:{}", option.getSocketTimeout());
		logger.info("connectionsPerHost:{}", option.getConnectionsPerHost());
		logger.info("threadsAllowedToBlockForConnectionMultiplier:{}",
				option.getThreadsAllowedToBlockForConnectionMultiplier());

		// @formatter:off
		return MongoClientOptions.builder()
				// .socketKeepAlive(option.isSocketKeepAlive())
				// .connectTimeout(option.getConnectTimeout())
				// .maxConnectionIdleTime(option.getMaxConnectionIdleTime())
				// .maxConnectionLifeTime(option.getMaxConnectionLifeTime())
				// .maxWaitTime(option.getMaxWaitTime())
				// .socketTimeout(option.getSocketTimeout())
				// .connectionsPerHost(option.getConnectionsPerHost())
				// .threadsAllowedToBlockForConnectionMultiplier(option.getThreadsAllowedToBlockForConnectionMultiplier())
				.build();
		// @formatter:on
	}

}
