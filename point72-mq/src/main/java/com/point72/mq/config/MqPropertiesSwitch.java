package com.point72.mq.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.point72.config.client.MqProperties;

@Configuration
@EnableConfigurationProperties({ MqProperties.class })
public class MqPropertiesSwitch {

}
