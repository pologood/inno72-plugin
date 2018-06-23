package com.inno72.xiongzhang.boot;

import java.util.HashMap;
import java.util.Map;

import com.inno72.xiongzhang.msg.CallbackAdapter;

/**
 * 事件消息适配器辅助类
 * 
 * @author Houkm
 *
 *         2018年4月3日
 */
public class CallbackAdapterHandler {

	private CallbackAdapterHandler() {
	}

	private Map<CallbackAdapter.Type, CallbackAdapter> adapters;

	public static class Builder {
		private CallbackAdapterHandler handler;

		public static Builder builder() {
			Builder builder = new Builder();
			builder.handler = new CallbackAdapterHandler();
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
		public Builder registry(CallbackAdapter.Type eventType, CallbackAdapter adapter) {
			this.handler.addProcesser(eventType, adapter);
			return this;
		}

		public CallbackAdapterHandler build() {
			return this.handler;
		}

		private Builder() {
		}
	}

	void addProcesser(CallbackAdapter.Type eventType, CallbackAdapter adapter) {
		adapters.put(eventType, adapter);
	}

	CallbackAdapter get(CallbackAdapter.Type eventType) {
		return adapters.get(eventType);
	}

	int size() {
		return adapters.size();
	}

	boolean exist(CallbackAdapter.Type eventType) {
		return adapters.containsKey(eventType);
	}
}
