package com.inno72.elasticsearch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "spring.data.elasticSearch.options")
public class ElasticSearchProperties {

	private String host;
	private int port;

}
