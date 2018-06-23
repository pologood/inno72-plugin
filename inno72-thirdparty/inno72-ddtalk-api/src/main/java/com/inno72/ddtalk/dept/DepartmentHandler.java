package com.inno72.ddtalk.dept;

import org.springframework.util.StringUtils;

import com.inno72.ddtalk.ApiUrl.Department;
import com.inno72.ddtalk.Invoke;
import com.inno72.plugin.http.HttpClient;

/**
 * 部门接口
 * 
 * @author Houkm
 *
 *         2017年6月27日
 */
public class DepartmentHandler {

	/**
	 * 获取部门列表
	 * 
	 * @param token
	 * @param parentId
	 *            默认1
	 * @author Houkm 2017年9月7日
	 */
	public static String getList(String token, String parentId) {
		return Invoke.get(Department.List.url(), token, StringUtils.isEmpty(parentId) ? "1" : parentId);
	}

	/**
	 * 获取部门详情
	 * 
	 * @param token
	 * @param parentId
	 *            默认1
	 * @author Houkm 2017年9月7日
	 */
	public static String get(String token, String id) {
		return Invoke.get(Department.Detail.url(), token, id);
	}

	/**
	 * 获取部门成员
	 * 
	 * @param token
	 * @param deptId
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String getUser(String token, int deptId) {
		return Invoke.get(Department.Get_User.url(), token, String.valueOf(deptId));
	}

	/**
	 * 获取部门成员（详情）
	 * 
	 * @param token
	 * @param deptId
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String getUserDetail(String token, int deptId) {
		return Invoke.get(Department.Get_User_Detail.url(), token, String.valueOf(deptId));
	}

	/**
	 * 创建部门
	 * 
	 * @param token
	 * @param data
	 *            请求数据json
	 *            (https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.HmjLgA&treeId=385&articleId=106817&docType=1#s2)
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String create(String token, String data) {
		return HttpClient.post(Department.Create.url(), data);
	}

	/**
	 * 更新部门
	 * 
	 * @param token
	 * @param data
	 *            请求数据json
	 * @see (https://open-doc.dingtalk.com/docs/doc.htm?spm=a219a.7629140.0.0.HmjLgA&treeId=385&articleId=106817&docType=1#s2)
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String update(String token, String data) {
		return HttpClient.post(Department.Update.url(), data);
	}

	/**
	 * 删除部门
	 * 
	 * @param token
	 * @param deptId
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String del(String token, int deptId) {
		return Invoke.get(Department.Del.url(), token, String.valueOf(deptId));
	}

	/**
	 * 查询部门的所有上级父部门路径
	 * 
	 * 假设部门的组织结构如下<br>
	 * 1<br>
	 * |->123<br>
	 * |-->456<br>
	 * |--->789<br>
	 * 当传入部门id为789时，返回的结果按顺序依次为其所有父部门的ID，直到根部门，如[456,123,1]。<br>
	 * 
	 * @param token
	 * @param deptId
	 * @return
	 * @author Houkm 2017年9月7日
	 */
	public static String getParentDeptPath(String token, int deptId) {
		return Invoke.get(Department.List_Parent_Depts_By_Dept.url(), token, String.valueOf(deptId));
	}
}
