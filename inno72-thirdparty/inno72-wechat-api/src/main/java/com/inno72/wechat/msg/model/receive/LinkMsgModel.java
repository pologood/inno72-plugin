package com.inno72.wechat.msg.model.receive;

import com.inno72.wechat.msg.model.AbstractModel;

/**
 * 接收到的链接消息
 * 
 * @author Houkm
 *
 *         2017年6月1日
 */
public class LinkMsgModel extends AbstractModel {

	public String MsgId;
	/**
	 * 消息标题
	 */
	public String Title;
	/**
	 * 消息描述
	 */
	public String Description;
	public String Url;

	@Override
	protected void setMsgType() {
		MsgType = "link";
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
