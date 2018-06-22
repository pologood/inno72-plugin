package com.point72.ddtalk.role.model;

import com.point72.ddtalk.ApiUrl.Role;
import com.point72.ddtalk.model.AbstractRestRequestModel;

import lombok.Data;

@Data

/**
 * 获取角色组信息请求数据对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class RoleGroupRequestModel extends AbstractRestRequestModel {

	@Override
	public String setMethod() {
		return Role.Group.method();
	}

	public RoleGroupRequestModel(String token, int group_id) {
		super(token);
		this.group_id = group_id;
	}

	private int group_id;

}
