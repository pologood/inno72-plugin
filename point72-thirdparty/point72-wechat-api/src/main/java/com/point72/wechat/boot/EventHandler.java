package com.point72.wechat.boot;

import java.util.HashMap;
import java.util.Map;

import com.point72.wechat.event.Event;
import com.point72.wechat.event.EventProcesser;

public class EventHandler {

	private Map<Event, EventProcesser> processers = new HashMap<>();

	private EventHandler() {
	}

	public static class Builder {
		private EventHandler eventHandler;

		public static Builder builder() {
			Builder builder = new Builder();
			builder.eventHandler = new EventHandler();
			return builder;
		}

		public Builder register(Event event, EventProcesser processer) {
			this.eventHandler.addProcesser(event, processer);
			return this;
		}

		public EventHandler build() {
			return this.eventHandler;
		}

		private Builder() {
		}

	}

	void addProcesser(Event event, EventProcesser processer) {
		processers.put(event, processer);
	}

	EventProcesser get(Event event) {
		return processers.get(event);
	}

	int size() {
		return processers.size();
	}

	boolean exist(Event event) {
		return processers.containsKey(event);
	}

}
