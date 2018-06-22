package com.point72.xiongzhang.boot;

import java.util.HashMap;
import java.util.Map;

import com.point72.xiongzhang.msg.EventAdapter;
import com.point72.xiongzhang.msg.enums.EventType;

/**
 * 事件消息适配器辅助类
 * 
 * @author Houkm
 *
 *         2018年4月3日
 */
public class EventAdapterHandler {

	private EventAdapterHandler() {
	}

	private Map<EventType, EventAdapter> adapters;

	public static class Builder {
		private EventAdapterHandler handler;

		public static Builder builder() {
			Builder builder = new Builder();
			builder.handler = new EventAdapterHandler();
			builder.handler.adapters = new HashMap<>();
			return builder;
		}

		/**
		 * 注册eventType事件类型的适配器adapter
		 * 
		 * @param eventType
		 * @param adapter
		 * @return
		 * @author Houkm 2018年4月3日
		 */
		public Builder registry(EventType eventType, EventAdapter adapter) {
			this.handler.addProcesser(eventType, adapter);
			return this;
		}

		public EventAdapterHandler build() {
			return this.handler;
		}

		private Builder() {
		}
	}

	void addProcesser(EventType eventType, EventAdapter adapter) {
		adapters.put(eventType, adapter);
	}

	EventAdapter get(EventType eventType) {
		return adapters.get(eventType);
	}

	int size() {
		return adapters.size();
	}

	boolean exist(EventType eventType) {
		return adapters.containsKey(eventType);
	}
}
