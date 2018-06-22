package com.point72.ddtalk.user;

import java.text.MessageFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.point72.ddtalk.ApiUrl;
import com.point72.ddtalk.ApiUrl.Department;
import com.point72.ddtalk.Invoke;
import com.point72.ddtalk.ResultHandler;
import com.point72.ddtalk.user.model.User;
import com.point72.plugin.http.HttpClient;

/**
 * 钉钉用户接口
 * 
 * @author Houkm
 *
 *         2017年6月27日
 */
public class UserHandler {

	private static Logger logger = LoggerFactory.getLogger(UserHandler.class);

	/**
	 * 获取用户详情
	 * 
	 * @param token
	 * @param userid
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static User get(String token, String userid) {
		String result = Invoke.get(ApiUrl.User.Detail.url(), token, userid);
		ResultHandler handler = new ResultHandler(result);
		User user = null;
		if (handler.isSuccess()) {
			user = JSON.parseObject(result, User.class);
		}
		return user;
	}

	/**
	 * 创建成员
	 * 
	 * @param token
	 * @param user
	 * @author Houkm 2017年9月7日
	 */
	public static String create(String token, User user) {
		return HttpClient.post(MessageFormat.format(ApiUrl.User.Create.url(), token), JSON.toJSONString(user));
	}

	/**
	 * 更新成员
	 * 
	 * @param token
	 * @param user
	 * @author Houkm 2017年9月7日
	 */
	public static String update(String token, User user) {
		return HttpClient.post(MessageFormat.format(ApiUrl.User.Update.url(), token), JSON.toJSONString(user));
	}

	/**
	 * 删除成员
	 * 
	 * @param token
	 * @param userid
	 * @author Houkm 2017年9月7日
	 */
	public static String del(String token, String userid) {
		return Invoke.get(ApiUrl.User.Del.url(), token, userid);
	}

	/**
	 * 删除成员
	 * 
	 * @param token
	 * @param userIds
	 * @author Houkm 2017年9月7日
	 */
	public static String del(String token, List<String> userIds) {
		JSONObject json = new JSONObject();
		json.put("useridlist", userIds);
		return HttpClient.post(MessageFormat.format(ApiUrl.User.Batch_Del.url(), token), json.toString());
	}

	/**
	 * 获取管理员列表
	 * 
	 * @param token
	 * @author Houkm 2017年9月7日
	 */
	public static String getAdminList(String token) {
		return Invoke.get(ApiUrl.User.Get_Admin.url(), token);
	}

	/**
	 * 根据unionid获取成员的userid
	 * 
	 * @param token
	 * @author Houkm 2017年9月7日
	 */
	public static String unionId2UserId(String token, String unionId) {
		return Invoke.get(ApiUrl.User.UnionId2UserId.url(), token, unionId);
	}

	/**
	 * 查询指定用户的所有上级父部门路径
	 * 
	 * 假设用户所属部门的组织结构如下<br>
	 * 1<br>
	 * |->123<br>
	 * |--->456 ->员工A<br>
	 * |->789 ->员工A<br>
	 * 当传入员工A的userId时，返回的结果按顺序依次为其所有父部门的ID，直到根部门，如[[456,123,1],[789,1]]。。<br>
	 * 
	 * @see https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.HmjLgA&treeId=385&articleId=106817&docType=1#s3
	 * 
	 * @param token
	 * @param userId
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String getParentDeptPath(String token, String userId) {
		return Invoke.get(Department.List_Parent_Depts_By_User.url(), token, userId);
	}

	/**
	 * 获取企业员工人数
	 * 
	 * @param token
	 * @author Houkm 2017年9月7日
	 */
	public static int count(String token, boolean onlyActive) {
		String result = Invoke.get(ApiUrl.User.Count.url(), token, onlyActive ? "1" : "0");
		ResultHandler handler = new ResultHandler(result);
		if (handler.isSuccess()) {
			return handler.getInteger("count");
		} else {
			logger.error("获取企业员工人数失败：{} --- {}", handler.getErrcode(), handler.getErrmsg());
			return 0;
		}
	}

}
