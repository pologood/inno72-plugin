package com.inno72.xiongzhang;

public class ApiUrl {

	// 熊掌域名
	private static XiongZhangDomain domain = XiongZhangDomain.COMMON;

	/**
	 * 凭证接口
	 * 
	 * @author Houkm
	 *
	 *         2018年4月2日
	 */
	public enum Core {
		//@formatter:off
		Access_token("/oauth/2.0/token?grant_type=client_credentials&client_id={0}&client_secret={1}"), 
		Jsapi_ticket("/rest/2.0/cambrian/jssdk/getticket?access_token={0}"),
		;
		//@formatter:on

		private String v;

		private Core(String v) {
			this.v = v;
		}

		public String url() {
			return domain + this.v;
		}
	}

	/**
	 * 商户接口
	 * 
	 * @author Houkm
	 *
	 *         2018年4月2日
	 */
	public enum Mch {
		//@formatter:off
		/**
		 * 调起收银台
		 */
		Cashierurl("/rest/2.0/mch/se/cashierurl"), 
		
		/**
		 * 服务商发起核销
		 */
		Settle("/rest/2.0/mch/se/settle"),
		
		/**
		 * 服务商申请退款
		 */
		Apprefund("/rest/2.0/mch/se/apprefund"),
		;
		//@formatter:on

		private String v;

		private Mch(String v) {
			this.v = v;
		}

		public String url() {
			return domain + this.v;
		}
	}

	/**
	 * 消息接口
	 * 
	 * @author Houkm
	 *
	 *         2018年4月2日
	 */
	public enum Message {
		//@formatter:off
		/**
		 * 客服消息
		 */
		Custom_Service("/rest/2.0/cambrian/message/custom_send?access_token={0}"), 
		Template("/rest/2.0/cambrian/template/send?access_token={0}"),
		;
		//@formatter:on

		private String v;

		private Message(String v) {
			this.v = v;
		}

		public String url() {
			return domain + this.v;
		}
	}

}
