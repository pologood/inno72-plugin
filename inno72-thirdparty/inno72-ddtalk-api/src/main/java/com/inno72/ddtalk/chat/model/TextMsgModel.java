package com.inno72.ddtalk.chat.model;

public class TextMsgModel extends AbstractModel {

	private Text text;

	@Override
	public void setMsgtype() {
		super.msgtype = "text";
	}

	public TextMsgModel(String text, String chatid) {
		super();
		setChatid(chatid);
		this.text = this.new Text(text);
	}

	public TextMsgModel(String text) {
		super();
		this.text = this.new Text(text);
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	class Text {
		private String content;

		Text(String content) {
			this.content = content;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

	}

}
