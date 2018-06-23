package com.inno72.ddtalk.user.model;

import java.util.List;

import lombok.Data;

/**
 * 钉钉用户
 * 
 * @author Houkm
 *
 *         2017年6月27日
 */

@Data
public class User {

	private String userid;
	private String name;
	private String tel;
	private String workPlace;
	private String remark;
	private String mobile;
	private String email;
	private boolean active;
	private String orderInDepts;
	private boolean isAdmin;
	private boolean isBoss;
	private String dingId;
	private String unionid;
	private String isLeaderInDepts;
	private boolean isHide;
	private List<Integer> department;
	private String position;
	private String avatar;
	private String jobnumber;

}