package com.inno72.elasticsearch.config;


import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;


@Configuration
@EnableConfigurationProperties(ElasticSearchProperties.class)
public class ElasticSearchConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(ElasticSearchConfig.class);

	@Autowired
	private ElasticSearchProperties elasticSearchProperties;

	@Bean
	public TransportClient elasticsearchClient() throws UnknownHostException {	//向spring注入es的客户端操作对象
		String host = elasticSearchProperties.getHost();
		int port = elasticSearchProperties.getPort();

		Settings settings = Settings.settingsBuilder()
				.put("cluster.name", "bigData-cluster").build();

		return TransportClient
					.builder()
					.settings(settings)
					.build()
					.addTransportAddress(
							new InetSocketTransportAddress(InetAddress.getByName(host), port)
					);

	}

}
