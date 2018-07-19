package com.inno72.log.vo;

/**
 * 系统日志
 */
public class BizLogAll extends AbstractLogAll {
	private String userId = "";
	private String operatorId = "";
	private String activityId = "";

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}
}
