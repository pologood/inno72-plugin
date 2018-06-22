package com.framelib.dubbo.doctor.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.framelib.dubbo.model.BaseModel;

/**
 * Created by zhouzengbao on 28/03/2017. 医生历史操作表 -- mongo
 */

public class DoctorOptionsHis extends BaseModel {

	private static final long serialVersionUID = 9020356805984183513L;

	private String Id;
	/** 医生id */
	private String doctorId;
	/** 医生姓名 */
	private String doctorName;
	/**
	 * 操作类型 http://wiki.nblow.cn/pages/viewpage.action?pageId=7177487
	 */
	private String optionType;
	/** 操作人id */
	private String optionPeopleId;
	/** 操作人 */
	private String optionPeople;
	/** 描述 */
	private String description;
	/** 日期 */
	private String createTime;
	/** 来源 */
	private String source;
	/** 设备号 */
	private String deviceNum;
	/** 设备型号 */
	private String deviceModel;
	/** 设备程序版本 */
	private String deviceProgramVersion;
	/** 程序版本 */
	private String programVersion;
	/** 网络状态 */
	private String netStat;

	// public enum OptionType{
	//
	// DOCTOR_ORDER_NUM("1","被接单"),
	// DOCTOR_SEARCH_NUM("2","被搜索"),
	//
	// DOCTOR_ONLINE("3", "上线"),
	// DOCTOR_OFFLINE("4","下线" ),
	// DOCTOR_ACCEPT_YET("5", "开始接诊"),
	// DOCTOR_ACCEPT_OVER("10","点击完成接诊"),
	// DOCTOR_REGIST("12","医生注册"),
	// DOCTOR_REGIST_ISEXIT("11","注册的用户已存在，返回已经存在信息，并更新新提交的信息。"),
	// DOCTOR_CALL_BACK("17","开始接诊回电"),
	// DOCTOR_CALL_END("18","结束接诊，挂断电话。"),
	// DOCTOR_UPDATE_INFO("20","更新医生信息"),
	//
	//
	// DOCTOR_ACCEPT_NOT("6", "结束接诊，状态被改为未接诊"),
	// DOCTOR_LOCK_TIMEOUT("7","速诊列表中被锁定超时，解除锁定。" ),
	// DOCTOR_LOCK("8","速诊被搜索锁定，5分钟内不可被其他人再次搜索。" ),
	// DOCTOR_ACCEPT_READY("9","被派单，等待接诊。"),
	//
	// DOCTOR_NET_STAT_FG("13","当前网络切换到4G"),
	// DOCTOR_NET_STAT_THG("14","当前网络切换到3G"),
	// DOCTOR_NET_STAT_TG("15","当前网络切换到2G"),
	// DOCTOR_NET_STAT_OFFLINE("16","网络异常导致下线"),
	// DOCTOR_NET_STAT_WIFI("19","当前网络切换到WIFI"),
	//
	// DOCTOR_AUTH_SUCC("22","医生信息被审核通过"),
	// DOCTOR_AUTH_FAIL("23","医生信息被审核为不通过"),
	// DOCTOR_AUTH_DEL("24","医生信息被删除")
	// ;
	//
	// private String key;
	// private String value;
	//
	//
	// OptionType(String key, String value) {
	// this.key = key;
	// this.value = value;
	// }
	//
	// public String getKey(){
	// return this.key;
	// }
	// public String getValue(){
	// return this.value;
	//
	// }
	// }

	public DoctorOptionsHis(String doctorId, String doctorName, String optionType, String optionPeopleId,
			String optionPeople, String description, String source, String deviceNum, String deviceModel,
			String deviceProgramVersion, String programVersion) {
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.optionType = optionType;
		this.optionPeopleId = optionPeopleId;
		this.optionPeople = optionPeople;
		this.description = description;
		this.source = source;
		this.deviceNum = deviceNum;
		this.deviceModel = deviceModel;
		this.deviceProgramVersion = deviceProgramVersion;
		this.programVersion = programVersion;
	}

	public DoctorOptionsHis() {
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public String getOptionPeople() {
		return optionPeople;
	}

	public void setOptionPeople(String optionPeople) {
		this.optionPeople = optionPeople;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getOptionPeopleId() {
		return optionPeopleId;
	}

	public void setOptionPeopleId(String optionPeopleId) {
		this.optionPeopleId = optionPeopleId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDeviceNum() {
		return deviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		this.deviceNum = deviceNum;
	}

	public String getProgramVersion() {
		return programVersion;
	}

	public void setProgramVersion(String programVersion) {
		this.programVersion = programVersion;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public String getDeviceProgramVersion() {
		return deviceProgramVersion;
	}

	public void setDeviceProgramVersion(String deviceProgramVersion) {
		this.deviceProgramVersion = deviceProgramVersion;
	}

	public String getNetStat() {
		return netStat;
	}

	public void setNetStat(String netStat) {
		this.netStat = netStat;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
	}
}
