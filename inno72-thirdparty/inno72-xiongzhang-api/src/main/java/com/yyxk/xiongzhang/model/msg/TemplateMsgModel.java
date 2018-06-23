package com.inno72.xiongzhang.model.msg;

import java.util.Map;

/**
 * 熊掌号模板消息
 * 
 * @author Houkm
 *
 *         2018年4月2日
 */
@lombok.Data
public class TemplateMsgModel {

	private String touser;
	private String template_id;
	private String url;
	private Map<String, Node> data;

	@lombok.Data
	public static class Node {
		protected String value;
		protected String color = "#173177";

		public Node(String value, String color) {
			this.value = value;
			if (color != null && !"".equals(color)) {
				this.color = color;
			}
		}

	}

	// @lombok.Data
	// public static class Data {
	//
	// private Node first;
	// private Node remark;
	// private Map<String, Node> data = new HashMap<>();
	//
	// public static class Node {
	// protected String value;
	// protected String color = "#173177";
	// }
	//
	// public Data addNode(String key, String value) {
	// Node node = new Node();
	// node.value = value;
	// this.data.put(key, node);
	// return this;
	// }
	//
	// public Data addNode(String key, String value, String color) {
	// Node node = new Node();
	// node.value = value;
	// node.color = color;
	// this.data.put(key, node);
	// return this;
	// }
	//
	// public Data setFirst(String value) {
	// return addNode("first", value);
	// }
	//
	// public Data setFirst(String value, String color) {
	// return addNode("first", value, color);
	// }
	//
	// public Data setRemark(String value) {
	// return addNode("remark", value);
	// }
	//
	// public Data setRemark(String value, String color) {
	// return addNode("remark", value, color);
	// }
	//
	// }

}
