package com.inno72.ddtalk.model;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public abstract class AbstractRestRequestModel {

	public AbstractRestRequestModel(String token) {
		this.session = token;
	}

	/**
	 * API接口名称。
	 */
	private String method = this.setMethod();
	/**
	 * 钉钉提供的授权Token
	 */
	private String session;
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	private String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	/**
	 * 响应格式。默认为xml格式，可选值：xml，json。
	 */
	private String format = "json";
	/**
	 * API协议版本，可选值：2.0。
	 */
	private String v = "2.0";
	private String partner_id;

	private boolean simplify = false;

	public abstract String setMethod();

	public Map<String, String> toRequestParam() {
		Map<String, String> param = new HashMap<>();
		Field[] fs = this.getClass().getDeclaredFields();
		Arrays.asList(fs).forEach(field -> {
			try {
				Object value = field.get(this);
				if (value != null) {
					param.put(field.getName(), value.toString());
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});
		Arrays.asList(this.getClass().getSuperclass().getDeclaredFields()).forEach(field -> {
			try {
				Object value = field.get(this);
				if (value != null) {
					param.put(field.getName(), value.toString());
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});
		return param;
	}

}
