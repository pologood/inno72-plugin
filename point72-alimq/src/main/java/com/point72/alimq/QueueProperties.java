package com.point72.alimq;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "yyxk.alimq")
public class QueueProperties {

	private String keyId;
	private String keySecret;

	private String addr;

	private Queue doctorAnalysis;
	private Queue doctorSearchAnalysis;
	private Queue log;
	private Queue qyhmsg;
	private Queue wechatTpl;
	private Queue pushMsg;
	private Queue logDoctor;

	public static class Queue {
		private String topic;
		private String consumerId;
		private String providerId;

		public String getTopic() {
			return topic;
		}

		public void setTopic(String topic) {
			this.topic = topic;
		}

		public String getConsumerId() {
			return consumerId;
		}

		public void setConsumerId(String consumerId) {
			this.consumerId = consumerId;
		}

		public String getProviderId() {
			return providerId;
		}

		public void setProviderId(String providerId) {
			this.providerId = providerId;
		}

	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Queue getDoctorAnalysis() {
		return doctorAnalysis;
	}

	public void setDoctorAnalysis(Queue doctorAnalysis) {
		this.doctorAnalysis = doctorAnalysis;
	}

	public Queue getDoctorSearchAnalysis() {
		return doctorSearchAnalysis;
	}

	public void setDoctorSearchAnalysis(Queue doctorSearchAnalysis) {
		this.doctorSearchAnalysis = doctorSearchAnalysis;
	}

	public Queue getLog() {
		return log;
	}

	public void setLog(Queue log) {
		this.log = log;
	}

	public Queue getQyhmsg() {
		return qyhmsg;
	}

	public void setQyhmsg(Queue qyhmsg) {
		this.qyhmsg = qyhmsg;
	}

	public Queue getWechatTpl() {
		return wechatTpl;
	}

	public void setWechatTpl(Queue wechatTpl) {
		this.wechatTpl = wechatTpl;
	}

	public Queue getPushMsg() {
		return pushMsg;
	}

	public void setPushMsg(Queue pushMsg) {
		this.pushMsg = pushMsg;
	}

	public Queue getLogDoctor() {
		return logDoctor;
	}

	public void setLogDoctor(Queue logDoctor) {
		this.logDoctor = logDoctor;
	}

	public String getKeyId() {
		return keyId;
	}

	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}

	public String getKeySecret() {
		return keySecret;
	}

	public void setKeySecret(String keySecret) {
		this.keySecret = keySecret;
	}

}
