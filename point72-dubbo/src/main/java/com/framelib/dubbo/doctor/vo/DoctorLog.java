package com.framelib.dubbo.doctor.vo;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 医生在线时长
 * 
 * @author zhouzengbao
 *
 */
public class DoctorLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 363397680259279974L;
	/** 医生id */
	private String doctorId;
	/** 医生姓名 */
	private String doctorName;
	/** 开始日期时间 */
	private String startTime;
	/** 结束日期时间 */
	private String endTime;
	/** 时长 */
	private String countTime;
	/** 总计时长 */
	private String totleCountTime;
	
	/** 集合 */
	private List<DoctorLog> DoctorLogs;

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getCountTime() {
		return countTime;
	}

	public void setCountTime(String countTime) {
		this.countTime = countTime;
	}

	public String getTotleCountTime() {
		return totleCountTime;
	}

	public void setTotleCountTime(String totleCountTime) {
		this.totleCountTime = totleCountTime;
	}

	public List<DoctorLog> getDoctorLogs() {
		return DoctorLogs;
	}

	public void setDoctorLogs(List<DoctorLog> doctorLogs) {
		DoctorLogs = doctorLogs;
	}
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
	}

}
