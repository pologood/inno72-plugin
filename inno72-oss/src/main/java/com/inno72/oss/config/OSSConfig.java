package com.inno72.oss.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aliyun.oss.OSSClient;

@Configuration
@EnableConfigurationProperties(OSSProperties.class)
public class OSSConfig {

	private Logger logger = LoggerFactory.getLogger(OSSConfig.class);

	@Autowired
	private OSSProperties prop;

	@Bean
	public OSSClient ossClient() {
		if (prop.getEndpoint() == null || prop.getAccessKeyId() == null || prop.getAccessKeySecret() == null) {
			logger.error("OSS配置信息不全，不创建OSSClient");
			return null;
		}
		OSSClient ossClient = new OSSClient(prop.getEndpoint(), prop.getAccessKeyId(), prop.getAccessKeySecret());
		return ossClient;
	}

}
