package com.inno72.alimq;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(QueueProperties.class)
public class AliMqConfig {

	@Autowired
	private QueueProperties queueProp;

	@Bean
	public ProducerBean doctorAnalysisProducer() {
		ProducerBean bean = new ProducerBean();
		Properties prop = new Properties();
		prop.setProperty("ProducerId", queueProp.getDoctorAnalysis().getProviderId());
		prop.setProperty("AccessKey", queueProp.getKeyId());
		prop.setProperty("SecretKey", queueProp.getKeySecret());
		prop.setProperty("ONSAddr", queueProp.getAddr());
		bean.setProperties(prop);
		return bean;
	}

	@Bean
	public ProducerBean doctorSearchAnalysisProducer() {
		ProducerBean bean = new ProducerBean();
		Properties prop = new Properties();
		prop.setProperty("ProducerId", queueProp.getDoctorSearchAnalysis().getProviderId());
		prop.setProperty("AccessKey", queueProp.getKeyId());
		prop.setProperty("SecretKey", queueProp.getKeySecret());
		prop.setProperty("ONSAddr", queueProp.getAddr());
		bean.setProperties(prop);
		return bean;
	}

	@Bean
	public ProducerBean logProducer() {
		ProducerBean bean = new ProducerBean();
		Properties prop = new Properties();
		prop.setProperty("ProducerId", queueProp.getLog().getProviderId());
		prop.setProperty("AccessKey", queueProp.getKeyId());
		prop.setProperty("SecretKey", queueProp.getKeySecret());
		prop.setProperty("ONSAddr", queueProp.getAddr());
		bean.setProperties(prop);
		return bean;
	}

	@Bean
	public ProducerBean qyhmsgProducer() {
		ProducerBean bean = new ProducerBean();
		Properties prop = new Properties();
		prop.setProperty("ProducerId", queueProp.getQyhmsg().getProviderId());
		prop.setProperty("AccessKey", queueProp.getKeyId());
		prop.setProperty("SecretKey", queueProp.getKeySecret());
		prop.setProperty("ONSAddr", queueProp.getAddr());
		bean.setProperties(prop);
		return bean;
	}

	@Bean
	public ProducerBean wechatTplProducer() {
		ProducerBean bean = new ProducerBean();
		Properties prop = new Properties();
		prop.setProperty("ProducerId", queueProp.getWechatTpl().getProviderId());
		prop.setProperty("AccessKey", queueProp.getKeyId());
		prop.setProperty("SecretKey", queueProp.getKeySecret());
		prop.setProperty("ONSAddr", queueProp.getAddr());
		bean.setProperties(prop);
		return bean;
	}

	@Bean
	public ProducerBean pushMsgProducer() {
		ProducerBean bean = new ProducerBean();
		Properties prop = new Properties();
		prop.setProperty("ProducerId", queueProp.getPushMsg().getProviderId());
		prop.setProperty("AccessKey", queueProp.getKeyId());
		prop.setProperty("SecretKey", queueProp.getKeySecret());
		prop.setProperty("ONSAddr", queueProp.getAddr());
		bean.setProperties(prop);
		return bean;
	}

	@Bean
	public ProducerBean logDoctorProducer() {
		ProducerBean bean = new ProducerBean();
		Properties prop = new Properties();
		prop.setProperty("ProducerId", queueProp.getLogDoctor().getProviderId());
		prop.setProperty("AccessKey", queueProp.getKeyId());
		prop.setProperty("SecretKey", queueProp.getKeySecret());
		prop.setProperty("ONSAddr", queueProp.getAddr());
		bean.setProperties(prop);
		return bean;
	}

}
