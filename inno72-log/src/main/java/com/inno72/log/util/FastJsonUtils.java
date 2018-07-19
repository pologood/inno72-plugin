package com.inno72.log.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Set;

@SuppressWarnings({"unused", "rawtypes", "unchecked"})
public class FastJsonUtils {

	private static final SerializerFeature[] FEATURES = {
			// 输出空置字段
			SerializerFeature.WriteMapNullValue,
			// list字段如果为null，输出为[]，而不是null
			SerializerFeature.WriteNullListAsEmpty,
			// 数值字段如果为null，输出为0，而不是null
			SerializerFeature.WriteNullNumberAsZero,
			// Boolean字段如果为null，输出为false，而不是null
			SerializerFeature.WriteNullBooleanAsFalse,
			// 字符类型字段如果为null，输出为""，而不是null
			SerializerFeature.WriteNullStringAsEmpty,
			//采用默认时间格式输出
			SerializerFeature.WriteDateUseDateFormat};

	public static String getString(String payload, String key) {
		JSONObject payloadJson = JSON.parseObject(payload);
		return getString(payloadJson, key);
	}

	public static String getString(JSONObject payloadJson, String key) {
		Set entrySet = payloadJson.entrySet();

		String result;
		for (Object entry : entrySet) {
			HashMap.Entry entryNode = (HashMap.Entry) entry;

			String innerKey = String.valueOf(entryNode.getKey());

			if (innerKey.equals(key) && !(entryNode.getValue() instanceof JSONObject)) {
				return String.valueOf(entryNode.getValue());

			} else {
				if (entryNode.getValue() instanceof JSONObject) {
					result = getString(String.valueOf(payloadJson.getString(innerKey)), key);
					if (StringUtils.isNotBlank(result)) {
						return result;
					}
				} else if (entryNode.getValue() instanceof JSONArray) {
					JSONArray jarray = (JSONArray) entryNode.getValue();
					for (Object jo : jarray) {
						result = getString(JSON.toJSONString(jo), key);
						if (StringUtils.isNotBlank(result)) {
							return result;
						}
					}
				} else {
					continue;
				}
			}

		}
		return null;
	}


	public static String getStringWithFatherKey(String payload, String fatherKey, String key) {
		JSONObject payloadJson = JSON.parseObject(payload);
		return getStringWithFatherKey(payloadJson, fatherKey, key, fatherKey);
	}

	public static String getStringWithFatherKey(JSONObject payloadJson, String fatherKey, String key,
			String originFatherKey) {
		Set entrySet = payloadJson.entrySet();

		String result;
		for (Object entry : entrySet) {
			HashMap.Entry entryNode = (HashMap.Entry) entry;

			String innerKey = String.valueOf(entryNode.getKey());

			if (innerKey.equals(key) && fatherKey.equals(originFatherKey) && !(entryNode
					.getValue() instanceof JSONObject)) {
				return String.valueOf(entryNode.getValue());
			} else {
				if (entryNode.getValue() instanceof JSONObject) {
					result = getStringWithFatherKey((JSONObject) entryNode.getValue(), innerKey, key, originFatherKey);
					if (StringUtils.isNotBlank(result)) {
						return result;
					}
				} else if (entryNode.getValue() instanceof JSONArray) {
					JSONArray jarray = (JSONArray) entryNode.getValue();
					for (Object jo : jarray) {
						result = getStringWithFatherKey((JSONObject) jo, innerKey, key, originFatherKey);
						if (StringUtils.isNotBlank(result)) {
							return result;
						}
					}
				} else {
					continue;
				}
			}
		}
		return null;
	}


	public static <T> T getValue(String payload, String key, Class<T> clazz) {
		JSONObject payloadJson = JSON.parseObject(payload);
		return getValue(payloadJson, key, clazz);
	}


	public static <T> T getValue(JSONObject payloadJson, String key, Class<T> clazz) {
		Set entrySet = payloadJson.entrySet();

		T result;
		for (Object entry : entrySet) {
			HashMap.Entry entryNode = (HashMap.Entry) entry;

			String innerKey = String.valueOf(entryNode.getKey());

			if (innerKey.equals(key) && clazz.isInstance(entryNode.getValue())) {
				return (T) entryNode.getValue();
			} else {
				if (entryNode.getValue() instanceof JSONObject) {
					result = getValue(payloadJson.getJSONObject(innerKey), key, clazz);
					if (result != null) {
						return result;
					}
				} else if (entryNode.getValue() instanceof JSONArray) {
					JSONArray jarray = (JSONArray) entryNode.getValue();
					for (Object jo : jarray) {
						result = getValue((JSONObject) jo, key, clazz);
						if (result != null) {
							return result;
						}
					}
				} else {
					continue;
				}
			}
		}
		return null;
	}

	public static String toJson(Object object, String dateFormat) {
		return JSON.toJSONStringWithDateFormat(object, dateFormat, SerializerFeature.WriteDateUseDateFormat);

	}

	public static String toJson(Object object) {
		return toJson(object, "yyyy-MM-dd HH:mm:ss");
	}

	public static <T> T toObject(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}


}
