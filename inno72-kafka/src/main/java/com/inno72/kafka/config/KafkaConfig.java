package com.inno72.kafka.config;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.codehaus.jackson.map.JsonSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;


@Configuration
public class KafkaConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConfig.class);


	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;
	@Value("${spring.kafka.consumer.max-poll-records}")
	private String maxPollRecords;

	@Bean
	public KafkaListenerContainerFactory<?> batchFactory(){
		ConcurrentKafkaListenerContainerFactory<Integer, String> factory
				= new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		factory.setConcurrency(4);
		factory.setBatchListener(true); //设置为批量消费，每个批次数量在Kafka配置参数中设置ConsumerConfig.MAX_POLL_RECORDS_CONFIG
		factory.getContainerProperties().setPollTimeout(1500);
		factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL_IMMEDIATE);//设置提交偏移量的方式
		return factory;

	}

	@Bean
	public ConsumerFactory consumerFactory() {
		return new DefaultKafkaConsumerFactory(consumerConfigs());
	}

	@Bean
	public Map<String, Object> consumerConfigs() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		//两次poll之间的时间隔间最大值,如果超过此值将会被认为此consumer失效,触发consumer重新平衡.
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "2000");
		//会话过期时长,consumer通过ConsumerCoordinator间歇性发送心跳
		//超期后,会被认为consumer失效,服务迁移到其他consumer节点.(group)
		//需要注意,Coordinator与kafkaConsumer共享底层通道,也是基于poll获取协调事件,但是会在单独的线程中
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, "15000");
		/**
		 * 等待响应的超时时长,如果超出阈值,则会导致请求被重试,取决"retries"参数.
		 * 此参数值必须大于sessionTimeoutMS
		 */
		props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, "20000");
		/**
		 * 从何处开始消费,latest 表示消费最新消息,earliest 表示从头开始消费,none表示抛出异常,默认latest
		 */
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

		//单次最多允许poll的消息条数.
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "100");//每一批数量
		props.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG,"120000");

		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

		//强烈建议关闭自动确认,我们使用手动ACK模式,Spring Kafka基于JMS语义为我们设计好了兼容实现.
		return props;
	}

}
