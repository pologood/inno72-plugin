package com.inno72.wechat.msg.model.reply;

import com.inno72.wechat.msg.model.AbstractModel;

/**
 * 回复文本消息
 * 
 * @author Houkm
 *
 *         2017年6月2日
 */
public class TextMsgModel extends AbstractModel {

	/**
	 * 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	 */
	public String Content;

	@Override
	protected void setMsgType() {
		MsgType = "text";
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
