package com.point72.mq.producer;

import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.point72.config.client.MqProperties;
import com.point72.config.client.WechatApiProperties.Msg;
import com.point72.core.dto.ExceptionNotifyDTO;
import com.point72.core.dto.LogExceptionDTO;
import com.point72.core.dto.MsgDTO;

/**
 * MQ发送端
 * 
 * @author Houkm
 *
 *         2017年5月5日
 */
@Component
public class Producer {

	@Autowired
	private RabbitTemplate template;

	@Autowired
	private MqProperties props;

	/**
	 * 医生搜索统计
	 * 
	 * @param content
	 */
	public void asDoctorCountListener(String content) {
		template.convertAndSend(props.getDoctorCount().getExchange(), props.getDoctorCount().getKey(), content);
	}

	/**
	 * 医生问诊统计
	 * 
	 * @param map
	 */
	public void asSymptomCount(String content) {
		template.convertAndSend(props.getSymptonCount().getExchange(), props.getSymptonCount().getKey(), content);
	}

	/**
	 * 发{@linkplain Msg 消息}
	 * 
	 * @param msg
	 * 
	 * @author Houkm 2017年5月12日
	 */
	public void msg(MsgDTO msg) {
		template.convertAndSend(props.getMsg().getExchange(), props.getMsg().getKey(), msg);
	}

	/**
	 * 医生日志
	 * 
	 * @param content
	 */
	public void logDoctorMsg(String content) {
		template.convertAndSend(props.getLogDoctor().getExchange(), props.getLogDoctor().getKey(), content);
	}

	/**
	 * 异常报警
	 * 
	 * @param content
	 * @author Houkm 2017年6月9日
	 */
	public void exceptionNotify(ExceptionNotifyDTO exceptionNotifyDTO) {
		template.convertAndSend(props.getExceptionNotify().getExchange(), props.getExceptionNotify().getKey(),
				exceptionNotifyDTO);
	}

	/**
	 * 异常报警记录
	 * 
	 * @param content
	 * @author Houkm 2017年6月9日
	 */
	public void logExceotion(LogExceptionDTO logExceptionDTO) {
		template.convertAndSend(props.getLogException().getExchange(), props.getLogException().getKey(),
				logExceptionDTO);
	}

	private MessageProperties prop(String exchange, String key) {
		MessageProperties prop = new MessageProperties();
		prop.setReceivedExchange(exchange);
		prop.setReceivedRoutingKey(key);
		return prop;
	}

}
