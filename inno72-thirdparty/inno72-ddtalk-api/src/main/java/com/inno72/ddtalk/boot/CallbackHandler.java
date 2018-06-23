package com.inno72.ddtalk.boot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.inno72.ddtalk.ApiUrl;
import com.inno72.ddtalk.Invoke;
import com.inno72.ddtalk.boot.Event.AddressBookEvent;
import com.inno72.ddtalk.boot.Event.ChatEvent;
import com.inno72.ddtalk.model.AddressBookCallbackModel;
import com.inno72.ddtalk.model.ChatCallbackModel;

/**
 * 钉钉回调事件处理器
 * 
 * @author Houkm
 *
 *         2017年9月11日
 */
public class CallbackHandler {

	private Map<AddressBookEvent, AddressBookCallbackListener> addressBookHandler = null;
	private Map<ChatEvent, ChatCallbackListener> chatHandler = null;

	/**
	 * 注册事件回调接口
	 * 
	 * @param accessToken
	 * @param addressBookEvents
	 *            通讯录回话回调事件集
	 * @param chatEvents
	 *            群回话回调事件集
	 * @param token
	 *            加解密需要用到的token，ISV(服务提供商)推荐使用注册套件时填写的token，普通企业可以随机填写
	 * @param aesKey
	 *            数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z,
	 *            0-9共62个字符中选取,您可以随机生成，ISV(服务提供商)推荐使用注册套件时填写的EncodingAESKey
	 * @param url
	 *            接收事件回调的url
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String registryCallback(String accessToken, List<AddressBookEvent> addressBookEvents,
			List<ChatEvent> chatEvents, String token, String aesKey, String url) {
		JSONObject json = new JSONObject();
		List<String> tag = new ArrayList<String>();
		addressBookEvents.forEach(e -> tag.add(e.toString()));
		chatEvents.forEach(e -> tag.add(e.toString()));
		json.put("call_back_tag", tag);
		json.put("token", token);
		json.put("aes_key", aesKey);
		json.put("url", url);
		return Invoke.post(ApiUrl.Callback.Registry.url(), json.toJSONString(), accessToken);
	}

	/**
	 * 更新事件回调接口
	 * 
	 * @param accessToken
	 * @param addressBookEvents
	 *            通讯录回话回调事件集
	 * @param chatEvents
	 *            群回话回调事件集
	 * @param token
	 *            加解密需要用到的token，ISV(服务提供商)推荐使用注册套件时填写的token，普通企业可以随机填写
	 * @param aesKey
	 *            数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z,
	 *            0-9共62个字符中选取,您可以随机生成，ISV(服务提供商)推荐使用注册套件时填写的EncodingAESKey
	 * @param url
	 *            接收事件回调的url
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String updateCallback(String accessToken, List<AddressBookEvent> addressBookEvents,
			List<ChatEvent> chatEvents, String token, String aesKey, String url) {
		JSONObject json = new JSONObject();
		List<String> tag = new ArrayList<String>();
		addressBookEvents.forEach(e -> tag.add(e.toString()));
		chatEvents.forEach(e -> tag.add(e.toString()));
		json.put("call_back_tag", tag);
		json.put("token", token);
		json.put("aes_key", aesKey);
		json.put("url", url);
		return Invoke.post(ApiUrl.Callback.Update.url(), json.toJSONString(), accessToken);
	}

	/**
	 * 查询事件回调接口
	 * 
	 * @param token
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String get(String token) {
		return Invoke.get(ApiUrl.Callback.Get.url(), token);
	}

	/**
	 * 获取回调失败的结果<br>
	 * 钉钉服务器给回调接口推送 通讯录变更事件的时候，有可能因为各种原因推送失败(比如网络异常)，此时钉钉服务器将保留此次变更事件。
	 * 
	 * @param token
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String getFailed(String token) {
		return Invoke.get(ApiUrl.Callback.Get_Failed.url(), token);
	}

	/**
	 * 删除事件回调接口
	 * 
	 * @param token
	 * @return
	 * @author Houkm 2017年9月11日
	 */
	public static String delete(String token) {
		return Invoke.get(ApiUrl.Callback.Delete.url(), token);
	}

	private CallbackHandler() {
	}

	private void init() {
		addressBookHandler = new HashMap<>();
		chatHandler = new HashMap<>();
	}

	/**
	 * 解析数据并处理事件
	 * 
	 * @param data
	 * @author Houkm 2017年9月11日
	 */
	public void process(String data) {
		JSONObject obj = JSON.parseObject(data);
		String eventType = obj.getString("EventType");
		if (eventType.equals("check_url")) {
			return;
		}
		if (eventType.startsWith("chat")) {
			ChatCallbackModel model = JSON.parseObject(data, ChatCallbackModel.class);
			chatHandler.get(ChatEvent.valueOf(eventType)).process(model);
		} else {
			AddressBookCallbackModel model = JSON.parseObject(data, AddressBookCallbackModel.class);
			addressBookHandler.get(AddressBookEvent.valueOf(eventType)).process(model);
		}
	}

	public static class Builder {
		CallbackHandler handler = null;

		public static Builder builder() {
			Builder builder = new Builder();
			builder.handler = new CallbackHandler();
			builder.handler.init();
			return builder;
		}

		/**
		 * 注册通讯录回调事件处理器
		 * 
		 * @param event
		 * @param listener
		 * @author Houkm 2017年9月11日
		 */
		public Builder registerAddressBookCallbackListener(AddressBookEvent event,
				AddressBookCallbackListener listener) {
			this.handler.addressBookHandler.put(event, listener);
			return this;
		}

		/**
		 * 注册群会话回调事件处理器
		 * 
		 * @param event
		 * @param listener
		 * @author Houkm 2017年9月11日
		 */
		public Builder registerChatCallbackListener(ChatEvent event, ChatCallbackListener listener) {
			this.handler.chatHandler.put(event, listener);
			return this;
		}

		public CallbackHandler build() {
			return handler;
		}

		private Builder() {
		}

	}
}
