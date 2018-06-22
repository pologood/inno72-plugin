package com.framelib.dubbo.neworder.model;

import java.io.Serializable;

/**
 * 待生成合约单 备注
 * 
 * @author zhouzengbao
 *
 */
public class NewOrderMongoRemark implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6950044239062235368L;

	private String userId;
	
	private String userName;
	
	private String reamrk;
	
	private String createTime;
	
	private String updateTime;
	
	private String createdId;
	
	private String createdName;
	
	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getReamrk() {
		return reamrk;
	}

	public void setReamrk(String reamrk) {
		this.reamrk = reamrk;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	public String getCreatedName() {
		return createdName;
	}

	public void setCreatedName(String createdName) {
		this.createdName = createdName;
	}
	
	
}
