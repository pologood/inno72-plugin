package com.inno72.ddtalk.role.model;

import com.inno72.ddtalk.ApiUrl.Role;
import com.inno72.ddtalk.model.AbstractRestRequestModel;

import lombok.Data;

@Data

/**
 * 删除角色信息请求数据对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class DeleteRoleRequestModel extends AbstractRestRequestModel {

	@Override
	public String setMethod() {
		return Role.Del.method();
	}

	public DeleteRoleRequestModel(String token, int role_id) {
		super(token);
		this.role_id = role_id;
	}

	private int role_id;

}
