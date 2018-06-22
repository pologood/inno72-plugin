package com.framelib.dubbo.doctor.vo;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.framelib.dubbo.doctor.model.DoctorBusinessProperty;
import com.framelib.dubbo.doctor.model.DoctorInfo;
import com.framelib.dubbo.doctor.model.DoctorInfoAdd;
import com.framelib.dubbo.doctor.model.DoctorSaleBinding;

/**
 * 医生信息集合 医生附加信息 包含：医生主信息、医生业务属性
 * 
 * @author zhouzengbao
 *
 */
public class DoctorVo extends DoctorInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4787553711942307355L;

	private DoctorInfoAdd doctorInfoAdd;

	private DoctorBusinessProperty doctorBusinessProperty;

	private DoctorSaleBinding doctorSaleBinding;

	private String optionPeopleId;

	private String optionPeopleName;

	private List<Integer> doctorSkillIds;
	/**
	 * 是否锁定
	 */
	private boolean isLock;
	/**
	 * 锁定时间
	 */
	private String lockTime;
	/**
	 * 是否接诊
	 */
	private boolean isAccept;
	/**
	 * 是否离线
	 */
	private boolean isOffline;
	/**
	 * 是否下线保护
	 */
	private boolean isAbn;
	/**
	 * 下线时间
	 */
	private String offLineTime;
	/**
	 * 锁定医生的用户id
	 */
	private Integer userId;
	/**
	 * 锁定医生的用户名
	 */
	private String userName;
	/**
	 * 展示字段：医生组中-展示上级医生；医生价格系数中-展示例外名称；
	 */
	private String fatherDoctor;
	
	
	private Integer sNetWorkOnline;
	
	private List<Integer> deptLinks;
	

	public DoctorVo(DoctorInfoAdd doctorInfoAdd, DoctorBusinessProperty doctorBusinessProperty) {
		this.doctorInfoAdd = doctorInfoAdd;
		this.doctorBusinessProperty = doctorBusinessProperty;
	}

	public DoctorVo() {
	}
	

	public Integer getsNetWorkOnline() {
		return sNetWorkOnline;
	}

	public void setsNetWorkOnline(Integer sNetWorkOnline) {
		this.sNetWorkOnline = sNetWorkOnline;
	}

	public String getOptionPeopleId() {
		if (StringUtils.isEmpty(optionPeopleId)) {
			return "";
		}
		return optionPeopleId;
	}

	public void setOptionPeopleId(String optionPeopleId) {
		this.optionPeopleId = optionPeopleId;
	}

	public String getOptionPeopleName() {
		if (StringUtils.isEmpty(optionPeopleName)) {
			return "";
		}
		return optionPeopleName;
	}

	public void setOptionPeopleName(String optionPeopleName) {
		this.optionPeopleName = optionPeopleName;
	}

	public DoctorInfoAdd getDoctorInfoAdd() {
		return doctorInfoAdd;
	}

	public void setDoctorInfoAdd(DoctorInfoAdd doctorInfoAdd) {
		this.doctorInfoAdd = doctorInfoAdd;
	}

	public DoctorBusinessProperty getDoctorBusinessProperty() {
		return doctorBusinessProperty;
	}

	public void setDoctorBusinessProperty(DoctorBusinessProperty doctorBusinessProperty) {
		this.doctorBusinessProperty = doctorBusinessProperty;
	}

	public DoctorSaleBinding getDoctorSaleBinding() {
		return doctorSaleBinding;
	}

	public void setDoctorSaleBinding(DoctorSaleBinding doctorSaleBinding) {
		this.doctorSaleBinding = doctorSaleBinding;
	}

	public boolean isLock() {
		return isLock;
	}

	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}

	public String getLockTime() {
		return lockTime;
	}

	public void setLockTime(String lockTime) {
		this.lockTime = lockTime;
	}

	public boolean isAccept() {
		return isAccept;
	}

	public void setAccept(boolean isAccept) {
		this.isAccept = isAccept;
	}

	public boolean isOffline() {
		return isOffline;
	}

	public void setOffline(boolean isOffline) {
		this.isOffline = isOffline;
	}

	public String getOffLineTime() {
		return offLineTime;
	}

	public void setOffLineTime(String offLineTime) {
		this.offLineTime = offLineTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean isAbn() {
		return isAbn;
	}

	public void setAbn(boolean isAbn) {
		this.isAbn = isAbn;
	}
	
	public String getOutTime() throws ParseException{
		
//		if (super.getUpdated() != null && super.getStatus() .equals(StatusEnum.BEFOREHANDAUTH.getKey())){
//			LocalDateTime updated2 = super.getUpdated();
//			LocalDateTime now = LocalDateTime.now();
//			String nowformat = now.format(DateUtil.DF_ONLY_YMDHMS_S2);
//			String updated2format = updated2.format(DateUtil.DF_ONLY_YMDHMS_S2);
//			
//			Date nowDate = DateUtil.parseDate(nowformat, DateUtil.getDatePattern());
//			Date updated2Date = DateUtil.parseDate(updated2format, DateUtil.getDatePattern());
//			
//			Long outTime = nowDate.getTime()-updated2Date.getTime();
//			
//			return outTime/(24 * 60 * 60 * 1000)+"";
//		}
		return "";
	}
	
	
	
	public List<Integer> getDoctorSkillIds() {
		return doctorSkillIds;
	}

	public void setDoctorSkillIds(List<Integer> doctorSkillIds) {
		this.doctorSkillIds = doctorSkillIds;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}

	public String getFatherDoctor() {
		return fatherDoctor;
	}

	public void setFatherDoctor(String fatherDoctor) {
		this.fatherDoctor = fatherDoctor;
	}

	public List<Integer> getDeptLinks() {
		return deptLinks;
	}

	public void setDeptLinks(List<Integer> deptLinks) {
		this.deptLinks = deptLinks;
	}

	
}
