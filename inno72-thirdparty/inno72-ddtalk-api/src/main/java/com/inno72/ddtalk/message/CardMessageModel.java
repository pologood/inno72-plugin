package com.inno72.ddtalk.message;

import java.util.ArrayList;
import java.util.List;

import com.inno72.ddtalk.MessageType;

import lombok.Data;

@Data

/**
 * 卡片消息对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class CardMessageModel extends AbstractMessageModel {

	private CardMessageModel() {
		super(MessageType.card);
	}

	private String chatid;
	private Card action_card;

	public static class Builder {
		protected Card card;
		protected CardMessageModel model = new CardMessageModel();

		public static Builder builderNoAction(String chatid) {
			Builder builder = new Builder();
			builder.card = builder.model.new Card();
			builder.model.setChatid(chatid);
			builder.model.setAction_card(builder.card);
			return builder;
		}

		public static SignleBuilder builderSingleAction(String chatid) {
			SignleBuilder builder = new SignleBuilder();
			builder.card = builder.model.new SignleBtnCard();
			builder.model.setChatid(chatid);
			builder.model.setAction_card(builder.card);
			return builder;
		}

		public static MultiBuilder builderMultiAction(String chatid) {
			MultiBuilder builder = new MultiBuilder();
			builder.card = builder.model.new MultiBtnCard();
			builder.model.setChatid(chatid);
			builder.model.setAction_card(builder.card);
			return builder;
		}

		public CardMessageModel build() {
			return this.model;
		}

		public Builder title(String title) {
			this.card.setTitle(title);
			return this;
		}

		public Builder markdown(String markdown) {
			this.card.setMarkdown(markdown);
			return this;
		}

		public Builder agentid(String agentid) {
			this.card.setAgentid(agentid);
			return this;
		}

	}

	public static class SignleBuilder extends Builder {

		public SignleBuilder singleTitle(String singleTitle) {
			((SignleBtnCard) super.card).setSingle_title(singleTitle);
			return this;
		}

		public SignleBuilder singleUrl(String singleUrl) {
			((SignleBtnCard) super.card).setSingle_url(singleUrl);
			return this;
		}
	}

	public static class MultiBuilder extends Builder {

		public MultiBuilder addButton(String title, String url) {
			((MultiBtnCard) super.card).getBtn_json_list().add(this.model.new Button(title, url));
			return this;
		}

		public MultiBuilder btnOrientation(String btnOrientation) {
			((MultiBtnCard) super.card).setBtn_orientation(btnOrientation);
			return this;
		}
	}

	@Data
	private class Card {
		private String title;
		private String markdown;
		private String agentid;
	}

	@Data
	private class SignleBtnCard extends Card {
		private String single_title;
		private String single_url;
	}

	@Data
	private class MultiBtnCard extends Card {
		private List<Button> btn_json_list = new ArrayList<>();
		private String btn_orientation;
	}

	@Data
	private class Button {
		private String title;
		private String action_url;

		@SuppressWarnings("unused")
		protected Button(String title, String url) {
			this.title = title;
			this.action_url = url;
		}
	}
}
