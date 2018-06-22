package com.point72.wechat.menu;

/**
 * View按钮
 * 
 * @author Houkm
 *
 *         2017年6月1日
 */
public class ViewButton extends AbstractButton {

	private String url;
	private String type = "view";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

}
