package com.point72.wechat.msg.model;

import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * 模板消息抽象
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public abstract class AbstractTemplateModel {

	private String touser;
	private String template_id;
	private String url;

	private MiniProgram miniprogram;

	private Map<String, Node> data;

	public String toJson() {
		return JSON.toJSONString(this);
	}

	public class MiniProgram {
		private String appid;
		private String pagepath;

		public String getAppid() {
			return appid;
		}

		public void setAppid(String appid) {
			this.appid = appid;
		}

		public String getPagepath() {
			return pagepath;
		}

		public void setPagepath(String pagepath) {
			this.pagepath = pagepath;
		}

	}

	public class Node {
		private String value;
		private String color = "#173177";

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, Node> getData() {
		return data;
	}

	public void setData(Map<String, Node> data) {
		this.data = data;
	}

	public MiniProgram getMiniprogram() {
		return miniprogram;
	}

	public void setMiniprogram(MiniProgram miniprogram) {
		this.miniprogram = miniprogram;
	}

}
