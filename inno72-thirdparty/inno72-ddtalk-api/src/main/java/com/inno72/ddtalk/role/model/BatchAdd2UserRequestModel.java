package com.inno72.ddtalk.role.model;

import com.inno72.ddtalk.ApiUrl.Role;
import com.inno72.ddtalk.model.AbstractRestRequestModel;

import lombok.Data;

@Data

/**
 * 批量为员工增加角色信息请求数据对象
 * 
 * @author Houkm
 *
 *         2017年9月8日
 */
public class BatchAdd2UserRequestModel extends AbstractRestRequestModel {

	@Override
	public String setMethod() {
		return Role.Batch_Add2User.method();
	}

	public BatchAdd2UserRequestModel(String token, int[] rolelid_list, String[] userid_list) {
		super(token);
		this.rolelid_list = rolelid_list;
		this.userid_list = userid_list;
	}

	private int[] rolelid_list;
	private String[] userid_list;

}
