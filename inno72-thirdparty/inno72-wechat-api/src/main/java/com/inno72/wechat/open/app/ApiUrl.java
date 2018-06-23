package com.inno72.wechat.open.app;

public class ApiUrl {

	/**
	 * 开放平台相关接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月7日
	 */
	public static enum Open {

		/**
		 * 获取预授权码pre_auth_code
		 */
		Pre_Auth_Code("https://api.weixin.qq.com/cgi-bin/component/api_create_preauthcode?component_access_token={0}"),

		/**
		 * 获取第三方平台component_access_token
		 */
		Component_Access_Token("https://api.weixin.qq.com/cgi-bin/component/api_component_token"),

		/**
		 * 使用授权码换取公众号或小程序的接口调用凭据和授权信息
		 */
		Authorizer_Access_Token("https://api.weixin.qq.com/cgi-bin/component/api_query_auth?component_access_token={0}"),

		/**
		 * 获取（刷新）授权公众号或小程序的接口调用凭据（令牌）
		 */
		Refresh_Authorizer_Access_Token("https:// api.weixin.qq.com /cgi-bin/component/api_authorizer_token?component_access_token={0}"),

		/**
		 * 获取授权方的帐号基本信息
		 */
		Get_Account_Info("https://api.weixin.qq.com/cgi-bin/component/api_get_authorizer_info?component_access_token={0}"),

		/**
		 * 获取授权方的选项设置信息
		 */
		Get_Account_Option("https://api.weixin.qq.com/cgi-bin/component/ api_get_authorizer_option?component_access_token={0}"),

		/**
		 * 设置授权方的选项信息
		 */
		Set_Account_Option("https://api.weixin.qq.com/cgi-bin/component/ api_set_authorizer_option?component_access_token={0}"),;

		private Open(String v) {
			this.v = v;
		}

		private String v;

		public String url() {
			return this.v;
		}
	}

	/**
	 * 移动应用相关接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月7日
	 */
	public static enum App {

		/**
		 * 通过code获取access_token
		 */
		Access_Token("https://api.weixin.qq.com/sns/oauth2/access_token?appid={0}&secret={1}&code={2}&grant_type=authorization_code"),

		/**
		 * 刷新access_token有效期
		 */
		REFRESH_TOKEN("https://api.weixin.qq.com/sns/oauth2/refresh_token?appid={0}&grant_type=refresh_token&refresh_token={1}"),

		/**
		 * 检验授权凭证（access_token）是否有效
		 */
		Access_Token_Check("https://api.weixin.qq.com/sns/auth?access_token={0}&openid={1}"),

		/**
		 * 获取用户个人信息（UnionID机制）
		 */
		Userinfo("https://api.weixin.qq.com/sns/userinfo?access_token={0}&openid={1}"),

		;
		private App(String v) {
			this.v = v;
		}

		private String v;

		public String url() {
			return this.v;
		}
	}

}
