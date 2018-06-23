package com.inno72.wechat.menu;

/**
 * click类型的按钮
 * 
 * @author Houkm
 *
 *         2017年6月1日
 */
public class ClickButton extends AbstractButton {

	private String type = "click";

	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getType() {
		return type;
	}

}
