package com.point72.ddtalk.role;

import com.point72.ddtalk.Invoke;
import com.point72.ddtalk.role.model.BatchAdd2UserRequestModel;
import com.point72.ddtalk.role.model.BatchDel2UserRequestModel;
import com.point72.ddtalk.role.model.DeleteRoleRequestModel;
import com.point72.ddtalk.role.model.RoleGroupRequestModel;
import com.point72.ddtalk.role.model.RoleListRequestModel;
import com.point72.ddtalk.role.model.SimpleUserListRequestModel;

/**
 * 角色管理接口
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class RoleHandler {

	/**
	 * 获取角色的员工列表
	 * 
	 * @param token
	 * @param roleId
	 * @param size
	 * @param offset
	 * @return
	 * @author Houkm 2017年9月8日
	 */
	public static String getSimpleUserList(String token, int roleId, int size, int offset) {
		SimpleUserListRequestModel model = new SimpleUserListRequestModel(token, roleId, size, offset);
		return Invoke.rest(model);
	}

	/**
	 * 获取企业角色列表
	 * 
	 * @param token
	 * @param size
	 * @param offset
	 * @return
	 * @author Houkm 2017年9月8日
	 */
	public static String getRoleList(String token, int size, int offset) {
		RoleListRequestModel model = new RoleListRequestModel(token, size, offset);
		return Invoke.rest(model);
	}

	/**
	 * 批量为员工增加角色信息
	 * 
	 * @param token
	 * @param roleIds
	 * @param userIds
	 * @return
	 * @author Houkm 2017年9月8日
	 */
	public static String batchAdd2User(String token, int[] roleIds, String... userIds) {
		BatchAdd2UserRequestModel model = new BatchAdd2UserRequestModel(token, roleIds, userIds);
		return Invoke.rest(model);
	}

	/**
	 * 批量为员工删除角色信息
	 * 
	 * @param token
	 * @param roleIds
	 * @param userIds
	 * @return
	 * @author Houkm 2017年9月8日
	 */
	public static String batchDel2User(String token, int[] roleIds, String... userIds) {
		BatchDel2UserRequestModel model = new BatchDel2UserRequestModel(token, roleIds, userIds);
		return Invoke.rest(model);
	}

	/**
	 * 删除角色信息
	 * 
	 * @param token
	 * @param roleId
	 * @return
	 * @author Houkm 2017年9月8日
	 */
	public static String del(String token, int roleId) {
		DeleteRoleRequestModel model = new DeleteRoleRequestModel(token, roleId);
		return Invoke.rest(model);
	}

	/**
	 * 获取角色组信息
	 * 
	 * @param token
	 * @param size
	 * @param offset
	 * @return
	 * @author Houkm 2017年9月8日
	 */
	public static String getRoleGroup(String token, int groupId) {
		RoleGroupRequestModel model = new RoleGroupRequestModel(token, groupId);
		return Invoke.rest(model);
	}

}
