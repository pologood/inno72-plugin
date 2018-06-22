package com.point72.wechat.event;

import org.dom4j.Document;

/**
 * 微信消息事件自定义处理
 * 
 * @author Houkm
 *
 *         2017年9月5日
 */
public interface EventProcesser {

	String process(Document document);

}
