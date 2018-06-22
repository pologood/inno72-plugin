package com.point72.ddtalk.boot;

public class Event {

	public static enum AddressBookEvent {

		/**
		 * 通讯录用户增加
		 */
		USER_ADD("user_add_org"),

		/**
		 * 通讯录用户更改
		 */
		USER_MODIFY("user_modify_org"),

		/**
		 * 通讯录用户被设为管理员
		 */
		ADMIN_ADD("org_admin_add"),

		/**
		 * 通讯录用户被取消设置管理员
		 */
		ADMIN_REMOVE("org_admin_remove"),

		/**
		 * 通讯录企业部门创建
		 */
		DEPT_CREATE("org_dept_create"),

		/**
		 * 通讯录企业部门修改
		 */
		DEPT_MODIFY("org_dept_modify"),

		/**
		 * 通讯录企业部门删除
		 */
		DEPT_REMOVE("org_dept_remove"),

		/**
		 * 企业被解散
		 */
		ORG_REMOVE("org_remove"),

		/**
		 * 企业信息发生变更
		 */
		ORG_CHANGE("org_change"),

		/**
		 * 增加角色或者角色组
		 */
		ROLE_ADD("label_conf_add"),

		/**
		 * 删除角色或者角色组
		 */
		ROLE_REMOVE("label_conf_del"),

		/**
		 * 修改角色或者角色组
		 */
		ROLE_MODIFY("label_conf_modify"),

		;
		private AddressBookEvent(String v) {
			this.v = v;
		}

		private String v;

		@Override
		public String toString() {
			return this.v;
		}
	}

	public static enum ChatEvent {

		/**
		 * 群会话添加人员
		 */
		MEMBER_ADD("chat_add_member"),

		/**
		 * 群会话删除人员
		 */
		MEMBER_REMOVE("chat_remove_member"),

		/**
		 * 群会话用户主动退群
		 */
		MEMBER_QUIT("chat_quit"),

		/**
		 * 群会话更换群主
		 */
		UPDATE_OWNER("chat_update_owner"),

		/**
		 * 群会话更换群名称
		 */
		UPDATE_TITLE("chat_update_title"),

		/**
		 * 群会话解散群
		 */
		DISBAND("chat_disband"),

		/**
		 * 绑定了微应用的群会话，在解散时回调
		 */
		DISBAND_MICROAPP("chat_disband_microapp"),

		;
		private ChatEvent(String v) {
			this.v = v;
		}

		private String v;

		@Override
		public String toString() {
			return this.v;
		}
	}

}
