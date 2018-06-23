package com.inno72.ddtalk.role.model;

import com.inno72.ddtalk.ApiUrl.Role;
import com.inno72.ddtalk.model.AbstractRestRequestModel;

import lombok.Data;

@Data

/**
 * 获取角色的员工列表请求数据对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class SimpleUserListRequestModel extends AbstractRestRequestModel {

	@Override
	public String setMethod() {
		return Role.Get_SimpleList.method();
	}

	public SimpleUserListRequestModel(String token, int roleId, int size, int offset) {
		super(token);
		this.role_id = roleId;
		this.size = size;
		this.offset = offset;
	}

	private int role_id;
	private int size;
	private int offset;

}
