package com.inno72.alimq;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ProducerBean extends com.aliyun.openservices.ons.api.bean.ProducerBean {

	@PostConstruct
	public void init() {
		super.start();
	}

	@PreDestroy
	public void destroy() {
		super.shutdown();
	}

}
