package com.inno72.ddtalk.chat.model;

import java.util.List;

public class ActionCardMsgModel extends AbstractModel {

	ActionCard action_card;

	@Override
	public void setMsgtype() {
		msgtype = "action_card";
	}

	public ActionCard getAction_card() {
		return action_card;
	}

	public void setAction_card(ActionCard action_card) {
		this.action_card = action_card;
	}

	public class ActionCard {

		/**
		 * 透出到会话列表和通知的文案
		 */
		private String title;

		/**
		 * 消息内容，支持markdown，语法参考标准markdown语法。图片举例：![alt text](mediaId)
		 */
		private String markdown;

		/**
		 * 使用单一Action样式时的标题，必须与single_url同时设置
		 */
		private String single_title;

		/**
		 * 使用单一Action样式时的链接url，必须与single_title同时设置
		 */
		private String single_url;

		/**
		 * 使用多Action样式时的按钮排列方式，竖直排列(0)，横向排列(1)；必须与btn_json_list同时设置
		 */
		private String btn_orientation;

		/**
		 * 可选，微应用agentid。默认在角标处显示企业的名称和图标，如果传入agentid则在角标处显示微应用的名称和图标
		 */
		private String agentid;

		/**
		 * 使用多Action样式时的按钮列表；必须与btn_orientation同时设置
		 */
		private List<Button> btn_json_list;

		public class Button {

			/**
			 * 使用多Action样式时的按钮的标题
			 */
			private String title;

			/**
			 * 使用多Action样式时的按钮的链接url
			 */
			private String action_url;

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public String getAction_url() {
				return action_url;
			}

			public void setAction_url(String action_url) {
				this.action_url = action_url;
			}
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getMarkdown() {
			return markdown;
		}

		public void setMarkdown(String markdown) {
			this.markdown = markdown;
		}

		public String getSingle_title() {
			return single_title;
		}

		public void setSingle_title(String single_title) {
			this.single_title = single_title;
		}

		public String getSingle_url() {
			return single_url;
		}

		public void setSingle_url(String single_url) {
			this.single_url = single_url;
		}

		public String getBtn_orientation() {
			return btn_orientation;
		}

		public void setBtn_orientation(String btn_orientation) {
			this.btn_orientation = btn_orientation;
		}

		public String getAgentid() {
			return agentid;
		}

		public void setAgentid(String agentid) {
			this.agentid = agentid;
		}

		public List<Button> getBtn_json_list() {
			return btn_json_list;
		}

		public void setBtn_json_list(List<Button> btn_json_list) {
			this.btn_json_list = btn_json_list;
		}

	}

}
