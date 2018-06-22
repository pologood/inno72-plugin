package com.point72.ddtalk.role.model;

import com.point72.ddtalk.ApiUrl.Role;
import com.point72.ddtalk.model.AbstractRestRequestModel;

import lombok.Data;

@Data

/**
 * 获取企业角色列表请求数据对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class RoleListRequestModel extends AbstractRestRequestModel {

	@Override
	public String setMethod() {
		return Role.List.method();
	}

	public RoleListRequestModel(String token, int size, int offset) {
		super(token);
		this.size = size;
		this.offset = offset;
	}

	private int size;
	private int offset;

}
