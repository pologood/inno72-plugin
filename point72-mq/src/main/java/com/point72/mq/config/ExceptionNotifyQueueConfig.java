package com.point72.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.point72.config.client.MqProperties;

/**
 * 队列配置
 * 
 * @author Houkm
 *
 *         2017年6月16日
 */
@Configuration
public class ExceptionNotifyQueueConfig {
	@Autowired
	private MqProperties queueProp;

	/**
	 * 队列
	 * 
	 * @return
	 * @Date 2017年5月5日
	 * @Author Houkm
	 */
	@Bean
	Queue queue() {
		return new Queue(queueProp.getExceptionNotify().getName(), true);
	}

	/**
	 * 交换器
	 * 
	 * @return
	 * @Date 2017年5月5日
	 * @Author Houkm
	 */
	@Bean
	DirectExchange exchange() {
		return new DirectExchange(queueProp.getExceptionNotify().getExchange(), true, false);
	}

	/**
	 * 队列与交换器绑定
	 * 
	 * @param queue
	 * @param exchange
	 * @return
	 * @Date 2017年5月5日
	 * @Author Houkm
	 */
	@Bean
	Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(queueProp.getExceptionNotify().getKey());
	}
}
