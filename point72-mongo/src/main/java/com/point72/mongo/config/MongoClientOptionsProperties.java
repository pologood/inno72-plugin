package com.point72.mongo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "spring.data.mongo.options")
public class MongoClientOptionsProperties {

	private int connectTimeout;
	private int maxConnectionIdleTime;
	private int maxConnectionLifeTime;
	private int maxWaitTime;
	private int socketTimeout;
	private int connectionsPerHost;
	private boolean socketKeepAlive;
	private int threadsAllowedToBlockForConnectionMultiplier;

}
