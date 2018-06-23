package com.inno72.ddtalk;

/**
 * 钉钉接口地址统一管理
 * 
 * @author Houkm
 *
 *         2017年9月7日
 */
public class ApiUrl {

	public final static String Rest_Url = "https://eco.taobao.com/router/rest";

	/**
	 * 重要接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月5日
	 */
	public static enum Core {
		//@formatter:off
		
		/**
		 * 获取AccessToken
		 */
		Access_Token("https://oapi.dingtalk.com/gettoken?corpid={0}&corpsecret={1}"), 
		
		/**
		 * 获取jsapi_ticket
		 */
		JsApi_Ticket("https://oapi.dingtalk.com/get_jsapi_ticket?access_token={0}&type=jsapi"),
		
		;
		//@formatter:on

		private String v;

		private Core(String v) {
			this.v = v;
		}

		public String url() {
			return this.v;
		}
	}

	/**
	 * 免登授权接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月7日
	 */
	public static enum Login {
		//@formatter:off
		
		/**
		 * 通过CODE换取用户身份
		 */
		Code2UserInfo("https://oapi.dingtalk.com/user/getuserinfo?access_token={0}&code={1}"), 
		
		/**
		 * 普通钉钉用户账号开放及免登 获取accesstoken
		 */
		Login_Access_Token("https://oapi.dingtalk.com/sns/gettoken?appid={0}&appsecret={1}"), 
		
		/**
		 * 获取用户授权的持久授权码
		 */
		Get_Persistent_Code("https://oapi.dingtalk.com/sns/get_persistent_code?access_token={0}"), 
		
		
		/**
		 * 获取用户授权的SNS_TOKEN
		 */
		Get_Sns_Token("https://oapi.dingtalk.com/sns/get_sns_token?access_token={0}"),
		
		/**
		 * 获取用户授权的个人信息
		 */
		Get_UserInfo("https://oapi.dingtalk.com/sns/getuserinfo?sns_token={0}"),
		
		
		/**
		 * 微应用管理后台免登token
		 */
		Sso_Token("https://oapi.dingtalk.com/sso/gettoken?corpid={0}&corpsecret={1}"),
		
		/**
		 * 通过CODE换取微应用管理员的身份信息
		 */
		Code2AdminInfo("https://oapi.dingtalk.com/sso/getuserinfo?access_token={0}&code={1}"), 
		
		;
		//@formatter:on

		private String v;

		private Login(String v) {
			this.v = v;
		}

		public String url() {
			return this.v;
		}
	}

	/**
	 * 用户接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月5日
	 */
	public static enum User {
		//@formatter:off
		
		/**
		 * 获取成员详情
		 */
		Detail("https://oapi.dingtalk.com/user/get?access_token={0}&userid={1}"), 
		
		/**
		 * 创建成员
		 */
		Create("https://oapi.dingtalk.com/user/create?access_token={0}"),
		
		/**
		 * 更新成员
		 */
		Update("https://oapi.dingtalk.com/user/update?access_token={0}"),
		
		/**
		 * 删除成员
		 */
		Del("https://oapi.dingtalk.com/user/delete?access_token={0}&userid={1}"),
		
		/**
		 * 批量删除成员
		 */
		Batch_Del("https://oapi.dingtalk.com/user/batchdelete?access_token=ACCESS_TOKEN"),
		
		/**
		 * 获取管理员列表
		 */
		Get_Admin("https://oapi.dingtalk.com/user/get_admin?access_token={0}"),
		
		
		/**
		 * 获取管理员列表
		 */
		UnionId2UserId("https://oapi.dingtalk.com/user/getUseridByUnionid?access_token={0}&unionid={1}"),
		
		
		/**
		 * 获取管理员列表
		 */
		Count("https://oapi.dingtalk.com/user/get_org_user_count?access_token={0}&onlyActive={1}"),
		
		;
		//@formatter:on

		private String v;

		private User(String v) {
			this.v = v;
		}

		public String url() {
			return this.v;
		}
	}

	/**
	 * 部门接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月5日
	 */
	public static enum Department {
		//@formatter:off
		
		/**
		 * 获取部门成员
		 */
		Get_User("https://oapi.dingtalk.com/user/simplelist?access_token={0}&department_id={1}"), 
		
		
		/**
		 * 获取部门成员（详情）
		 */
		Get_User_Detail("https://oapi.dingtalk.com/user/list?access_token={0}&department_id={1}"), 
		
		
		/**
		 * 获取部门列表
		 */
		List("https://oapi.dingtalk.com/department/list?access_token={0}&id={1}"), 
		
		/**
		 * 获取部门详情
		 */
		Detail("https://oapi.dingtalk.com/department/get?access_token={0}&id={1}"), 
		
		
		/**
		 * 创建部门
		 */
		Create("https://oapi.dingtalk.com/department/create?access_token={0}"), 

		
		/**
		 * 更新部门
		 */
		Update("https://oapi.dingtalk.com/department/update?access_token={0}"), 
		
		
		/**
		 * 删除部门
		 */
		Del("https://oapi.dingtalk.com/department/delete?access_token={0}&id={1}"), 
		
		
		/**
		 * 查询部门的所有上级父部门路径
		 */
		List_Parent_Depts_By_Dept("https://oapi.dingtalk.com/department/list_parent_depts_by_dept?access_token={0}&id={1}"), 
		
		
		/**
		 * 查询部门的所有上级父部门路径
		 */
		List_Parent_Depts_By_User("https://oapi.dingtalk.com/department/list_parent_depts?access_token={0}&id={1}"), 
		
		
		
		
		;
		//@formatter:on

		private String v;

		private Department(String v) {
			this.v = v;
		}

		public String url() {
			return this.v;
		}
	}

	/**
	 * 权限管理接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月5日
	 */
	public static enum Auth {
		//@formatter:off
		
		/**
		 * 获取通讯录权限
		 */
		Get_Scopes("https://oapi.dingtalk.com/auth/scopes?access_token={0}"), 
		
		
		;
		//@formatter:on

		private String v;

		private Auth(String v) {
			this.v = v;
		}

		public String url() {
			return this.v;
		}
	}

	/**
	 * 角色管理
	 * 
	 * @author Houkm
	 *
	 *         2017年9月5日
	 */
	public static enum Role {
		//@formatter:off
			
			/**
			 * 获取角色的员工列表
			 */
			Get_SimpleList("dingtalk.corp.role.simplelist"), 
			
			/**
			 * 获取企业角色列表
			 */
			List("dingtalk.corp.role.list"), 
			
			
			/**
			 * 批量为员工增加角色信息
			 */
			Batch_Add2User("dingtalk.corp.role.addrolesforemps"),
			
			
			/**
			 * 批量为员工删除角色信息
			 */
			Batch_Del2User("dingtalk.corp.role.removerolesforemps"),
			
			
			/**
			 * 删除角色
			 */
			Del("dingtalk.corp.role.deleterole"),
			
			
			/**
			 * 获取角色组信息
			 */
			Group("dingtalk.corp.role.getrolegroup"),
			
			
			
			
			;
			//@formatter:on

		private String requestKey;

		private Role(String requestKey) {
			this.requestKey = requestKey;
		}

		public String method() {
			return this.requestKey;
		}

	}

	/**
	 * 微应用接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月5日
	 */
	public static enum MiniAPP {
		//@formatter:off
		
		/**
		 * 获取AccessToken
		 */
		Create("https://oapi.dingtalk.com/microapp/create?access_token={0}"), 
		
		/**
		 * 获取企业设置的微应用可见范围
		 */
		Get_Visible_Scopes("https://oapi.dingtalk.com/microapp/visible_scopes?access_token={0}"), 
		
		/**
		 * 设置微应用的可见范围
		 */
		Set_Visible_Scopes("https://oapi.dingtalk.com/microapp/set_visible_scopes?access_token={0}"), 
		
		
		;
		//@formatter:on

		private String v;

		private MiniAPP(String v) {
			this.v = v;
		}

		public String url() {
			return this.v;
		}
	}

	/**
	 * 消息接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月5日
	 */
	public static enum Message {
		//@formatter:off
		
		/**
		 * 发送群消息
		 */
		Send_Chat("https://oapi.dingtalk.com/chat/send?access_token={0}", ""), 
		
		/**
		 * 发送普通消息
		 */
		Send_User("https://oapi.dingtalk.com/message/send_to_conversation?access_token={0}", ""), 
		
		/**
		 * 通过自定义机器人发送群消息
		 */
		Send_User_By_Robot("https://oapi.dingtalk.com/robot/send?access_token={0}", ""), 
		
		/**
		 * 企业会话消息异步发送
		 */
		Send_Agent("", "dingtalk.corp.message.corpconversation.asyncsend"), 
		
		/**
		 * 通过用户授权码异步向企业会话发送消息
		 */
		Send_AgentByCode("", "dingtalk.corp.message.corpconversation.asyncsendbycode"), 
		
		
		/**
		 * 获取异步发送企业会话消息的发送进度
		 */
		Get_Send_Progress("", "dingtalk.corp.message.corpconversation.getsendprogress"), 
		
		/**
		 * 获取异步向企业会话发送消息的结果
		 */
		Get_Send_Result("", "dingtalk.corp.message.corpconversation.getsendresult"), 
		
		
		;
		//@formatter:on

		private String url;
		private String method;

		private Message(String url, String method) {
			this.url = url;
			this.method = method;
		}

		public String url() {
			return this.url;
		}

		public String method() {
			return this.method;
		}
	}

	/**
	 * 文件管理接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月5日
	 */
	public static enum File {
		//@formatter:off
		
		/**
		 * 上传媒体文件
		 */
		Upload("https://oapi.dingtalk.com/media/upload?access_token={0}&type={1}"), 
		
		/**
		 * 获取媒体文件
		 */
		Download("https://oapi.dingtalk.com/media/downloadFile?access_token={0}&media_id={1}"),
		
		;
		//@formatter:on

		private String v;

		private File(String v) {
			this.v = v;
		}

		public String url() {
			return this.v;
		}
	}

	/**
	 * 钉盘接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月5日
	 */
	public static enum CSpace {
		//@formatter:off
		
		/**
		 * 发送文件给指定用户
		 */
		Send_File2User("https://oapi.dingtalk.com/cspace/add_to_single_chat?access_token={0}&agent_id={1}&userid={2}&media_id={3}&file_name={4}"), 
		
		/**
		 * 新增文件到用户钉盘
		 */
		Add_File2User("https://oapi.dingtalk.com/cspace/add?access_token={0}&agent_id={1}&code={2}&media_id={3}&space_id={4}&folder_id={5}&name={6}&overwrite={7}"), 
		
		/**
		 * 获取企业下的自定义空间
		 */
		Get_Custom_Space("https://oapi.dingtalk.com/cspace/get_custom_space?access_token={0}&domain={1}&agent_id={2}"), 
		
		
		/**
		 * 授权用户访问企业下的自定义空间
		 */
		Grant_Custom_Space("https://oapi.dingtalk.com/cspace/grant_custom_space?access_token={0}&domain={1}&agent_id={2}&type={3}&userid={4}&path={5}&fileids={6}&duration={7}"), 
		
		
		/**
		 * 单步上传
		 */
		Upload("https://oapi.dingtalk.com/file/upload/single?access_token={0}&agent_id={1}&file_size={2}"),
		
		;
		//@formatter:on

		private String v;

		private CSpace(String v) {
			this.v = v;
		}

		public String url() {
			return this.v;
		}
	}

	/**
	 * 回调接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月5日
	 */
	public static enum Callback {
		//@formatter:off
		
		/**
		 * 注册事件回调接口
		 */
		Registry("https://oapi.dingtalk.com/call_back/register_call_back?access_token={0}"), 
		
		/**
		 * 更新事件回调接口
		 */
		Update("https://oapi.dingtalk.com/call_back/update_call_back?access_token={0}"), 
		
		
		/**
		 * 查询事件回调接口
		 */
		Get("https://oapi.dingtalk.com/call_back/get_call_back?access_token={0}"),
		
		/**
		 * 查询事件回调接口
		 */
		Delete("https://oapi.dingtalk.com/call_back/delete_call_back?access_token={0}"),
		
		/**
		 * 查询事件回调接口
		 */
		Get_Failed("https://oapi.dingtalk.com/call_back/get_call_back_failed_result?access_token={0}"),
		
		
		;
		//@formatter:on

		private String v;

		private Callback(String v) {
			this.v = v;
		}

		public String url() {
			return this.v;
		}
	}

	/**
	 * 统计数据接口
	 * 
	 * @author Houkm
	 *
	 *         2017年9月5日
	 */
	public static enum Data {
		//@formatter:off
		
		/**
		 * 记录统计数据
		 */
		Record("https://oapi.dingtalk.com/data/record?access_token={0}"), 
		
		/**
		 * 更新统计数据
		 */
		Update("https://oapi.dingtalk.com/data/update?access_token={0}"), 
		
		
		;
		//@formatter:on

		private String v;

		private Data(String v) {
			this.v = v;
		}

		public String url() {
			return this.v;
		}
	}

}
