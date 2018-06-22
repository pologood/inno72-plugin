package com.point72.wechat.boot;

import java.util.HashMap;
import java.util.Map;

import com.point72.wechat.event.CallbackEvent;
import com.point72.wechat.event.WechatServerCallbackAdapter;

public class CallbackHandler {

	private Map<CallbackEvent, WechatServerCallbackAdapter> adapters = new HashMap<>();

	private CallbackHandler() {
	}

	public static class Builder {
		private CallbackHandler callbackHandler;

		public static Builder builder() {
			Builder builder = new Builder();
			builder.callbackHandler = new CallbackHandler();
			return builder;
		}

		public Builder register(CallbackEvent event, WechatServerCallbackAdapter adapter) {
			this.callbackHandler.addAdapter(event, adapter);
			return this;
		}

		public CallbackHandler build() {
			return this.callbackHandler;
		}

		private Builder() {
		}

	}

	void addAdapter(CallbackEvent event, WechatServerCallbackAdapter adapter) {
		adapters.put(event, adapter);
	}

	WechatServerCallbackAdapter get(CallbackEvent event) {
		return adapters.get(event);
	}

	int size() {
		return adapters.size();
	}

	boolean exist(CallbackEvent event) {
		return adapters.containsKey(event);
	}

}
