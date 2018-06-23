package com.framelib.dubbo.doctor.model;


import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.framelib.dubbo.model.BaseModel;
import com.inno72.common.datetime.CustomLocalDateSerializer;
import com.inno72.common.datetime.CustomLocalDateTimeSerializer;


/**
 * 医生主表 mysql
 *
 */
public class DoctorInfo  extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5209582639811121842L;

	private Integer id;
	/** 展示姓名 */
	private String showName;
	/** 真实姓名 */
	private String trueName;
	/** 登陆名 */
	private String loginName;
	/** 业务类型 */
	private String businessType;
	/** 机构 */
	private String sysAdminAreaCode;
	/** 状态0-账户停用,1-注册用户,2-待认证,3-待审核,4-驳回,5-审核通过 */
	private Integer status;

	public enum StatusEnum{
		//不操作
		NOT(-999,"传值使用","没意义"),


		SUCC(1,"认证医生","通过"),
//		BEFOREHANDAUTH(2,"预认证","预认证"),
		REGIST(3,"自主注册","app注册"),
		STAYAUDIT(4,"待审核","等待审核"),
		REJECT(5,"认证驳回","驳回"),
		STOP(0,"账户停用","已停用"),
		DELETE(-1,"已删除","已删除"),

		DISABLED(10,"已失效","医生所在组失效");


		private Integer key;
		private String value;
		private String desc;

		StatusEnum(Integer key,String value,String desc){
			this.key = key;
			this.value =value;
			this.desc = desc;
		}

		public static StatusEnum getStatusEnumByKey(Integer key){

			for (StatusEnum iterable_element : StatusEnum.values()) {
				Integer key2 = iterable_element.getKey();
				if (key2 == key){
					return iterable_element;
				}
			}
			return null;

		}

		public Integer getKey() { return key; }
		public String getValue() { return value; }
		public String  getDesc(){ return desc;}

	}
	/** 性别 */
	private Integer sex;
	/** 生日 */
	@JsonSerialize(using = CustomLocalDateSerializer.class)
	@DateTimeFormat(iso=ISO.DATE)
	private LocalDate birthday;
	/** 电话 */
	private String mobile;
	/** 邮箱 */
	private String email;
	/** 家庭住址*/
	private String homeAdd;
	/** 学历 */
	private String education;
	/** 身份类型 身份 1：医生/2：护士/3：其他 */
	private String identityType;
	/** 服务类型 1：问答|10：在线问诊  */
	private String serviceType;
	/** 身份证号 */
	private String idNumber;
	/** 创建来源 */
	private String createSource;
	public static enum CreateSourceEnum{
		//1 后台添加  添加医生
		PLANTADD(1,"后台添加"),AUTHED(2,"认证医生"),SELFREGIST(3,"自主注册"),CHILDILLNESS(4,"儿疾注册"),PAASADD(5,"PAAS系统同步");

		private Integer key;
		private String value;

		CreateSourceEnum(Integer key,String value){
			this.key = key;
			this.value =value;
		}

		public Integer getKey() { return key; }
		public String getValue() { return value; }

		public static String getValueFromKey(String key){
			for (CreateSourceEnum e :CreateSourceEnum.values()){
				if (e.getKey().toString().equals(key)){
					return e.getValue();
				}
			}
			return "";
		}
		public static CreateSourceEnum getEnumFromValue(String value){
			if ( StringUtils.isEmpty(value)){
				return null;
			}
			for (CreateSourceEnum e :CreateSourceEnum.values()){
				if (e.getValue().equals(value)){
					return e;
				}
			}
			return null;
		}
	}
	/** 创建日期 */
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime created;
	/** 更新日期 */
	@JsonSerialize(using = CustomLocalDateTimeSerializer.class)
	@DateTimeFormat(iso=ISO.DATE_TIME)
	private LocalDateTime updated;
	/** 自动认证通过 */
	private Integer isAutoAuthOk;
	public enum IsAutoAuthOkEnum{
		OK(1,"是"),FALSE(0,"否");
		private Integer k;
		private String v;
		private IsAutoAuthOkEnum(Integer k, String v) {
			this.k = k;
			this.v = v;
		}
		public Integer getK() {
			return k;
		}
		public String getV() {
			return v;
		}
	}
	/** 专业 */
	private String professional;
	/** 医生资格 临床/中医/口腔/公共卫生 */
	private String qualification;
	/** 擅长领域 */
	private String doctorBetter;
	/** 简介 */
	private String doctorDesc;
	/** 从业医院 */
	private String hospitalName;
	/** 职称 */
	private String professionName;
	/** 头像 */
	private String pic;
	/** 科室id */
	private String deptId;
	/** 科室名称 */
	private String deptName;
	/** 其他科室id */
	private String deptIdOther;
	/** 其他科室名称 */
	private String deptNameOther;
	/** 毕业院校 */
	private String school;
	/** 密码 */
	private String password;
	/** 登陆app权限 */
	private Integer loginAppPermission;
	/** 登陆D+工作站权限 */
	private Integer loginDWordplatPermission;
	/** 销售id */
	private String saleId;
	/** 销售姓名 */
	private String saleName;
	/** 医生备注描述 医生可能很NB，需要个NB的描述或者备注 */
	private String reference;

	private String withdrawDeposit;

	public String getWithdrawDeposit() {
		return withdrawDeposit;
	}

	public void setWithdrawDeposit(String withdrawDeposit) {
		this.withdrawDeposit = withdrawDeposit;
	}

	public String getWithdrawDepositStr() {
		if ( StringUtils.isEmpty(withdrawDeposit)){
			return "";
		}
		String y = "1";
		StringBuilder sb = new StringBuilder();

		String[] ss = this.withdrawDeposit.split("");
		DecimalFormat obj = new DecimalFormat("");

		for (int i = 0; i < ss.length; i++) {
			if( ss[ss.length - (i+1)].equals(y) ){
				String numstr = obj.format(Math.pow(10, i)).replaceAll(",", "");
				sb.append(numstr+",");
			}
		}

		return sb.toString();
	}

	public String getDeptIdOther() {
		return deptIdOther;
	}

	public void setDeptIdOther(String deptIdOther) {
		this.deptIdOther = deptIdOther;
	}
	
	public String getDeptIdOtherStr(){

		if ( StringUtils.isEmpty(deptIdOther) || deptIdOther.length() < 16){
			return "";
		}
		String y = "1";
		StringBuilder sb = new StringBuilder();

		String[] ss = this.deptIdOther.split("");
		DecimalFormat obj = new DecimalFormat("");
		
		for (int i = 0; i < ss.length; i++) {
			if( ss[ss.length - (i+1)].equals(y) ){
				String numstr = obj.format(Math.pow(10, i)).replaceAll(",", "");
				sb.append(numstr+",");
			}
		}

		return sb.toString();
	}

	public String getDeptNameOther() {
		return deptNameOther;
	}

	public void setDeptNameOther(String deptNameOther) {
		this.deptNameOther = deptNameOther;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName == null ? null : showName.trim();
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName == null ? null : trueName.trim();
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getSysAdminAreaCode() {
		return sysAdminAreaCode;
	}

	public void setSysAdminAreaCode(String sysAdminAreaCode) {
		this.sysAdminAreaCode = sysAdminAreaCode == null ? null : sysAdminAreaCode.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getCreateSource() {
		return createSource;
	}

	/** 请使用枚举类 CreateSourceEnum*/
	public void setCreateSource(String createSource) {
		this.createSource = createSource;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public String getDoctorBetter() {
		return doctorBetter;
	}

	public void setDoctorBetter(String doctorBetter) {
		this.doctorBetter = doctorBetter;
	}

	public String getDoctorDesc() {
		return doctorDesc;
	}

	public void setDoctorDesc(String doctorDesc) {
		this.doctorDesc = doctorDesc;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getLoginAppPermission() {
		return loginAppPermission;
	}

	public void setLoginAppPermission(Integer loginAppPermission) {
		this.loginAppPermission = loginAppPermission;
	}

	public Integer getLoginDWordplatPermission() {
		return loginDWordplatPermission;
	}

	public void setLoginDWordplatPermission(Integer loginDWordplatPermission) {
		this.loginDWordplatPermission = loginDWordplatPermission;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public String getSaleName() {
		return saleName;
	}

	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}

	public Integer getIsAutoAuthOk() {
		return isAutoAuthOk;
	}

	public void setIsAutoAuthOk(Integer isAutoAuthOk) {
		this.isAutoAuthOk = isAutoAuthOk;
	}

	public String getHomeAdd() {
		return homeAdd;
	}

	public void setHomeAdd(String homeAdd) {
		this.homeAdd = homeAdd;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getProfessional() {
		return professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	/**
	 *                              app      d+
	 *	int wenzhen = 1;            0        1
	 *	int teyue = 10;             0        2 
	 *	int suzhen = 100;  		  2        0
	 *	int jiedu = 1000;    	      2        0
     *	int quanke = 10000; 	 	  1        0
	 *	int jietingmenzhen = 100000 1        0
	 */
	public String getBusinessTypeCn(){

		if ( StringUtils.isEmpty(businessType) || businessType.length() < 12){
			return "";
		}
		
		String y = "1";
		StringBuilder sb = new StringBuilder();

		String[] ss = this.businessType.split("");
		DecimalFormat obj = new DecimalFormat("");

		for (int i = 0; i < ss.length; i++) {
			if( ss[ss.length - (i+1)].equals(y) ){
				String numstr = obj.format(Math.pow(10, i)).replaceAll(",", "");
				sb.append(numstr+",");
			}
		}

		return sb.toString();
	}
	
	public String getServiceTypeCn(){

		if ( StringUtils.isEmpty(serviceType) || serviceType.length() < 12){
			return "";
		}
		String y = "1";
		StringBuilder sb = new StringBuilder();

		String[] ss = this.serviceType.split("");
		DecimalFormat obj = new DecimalFormat("");
		
		for (int i = 0; i < ss.length; i++) {
			if( ss[ss.length - (i+1)].equals(y) ){
				String numstr = obj.format(Math.pow(10, i)).replaceAll(",", "");
				sb.append(numstr+",");
			}
		}

		return sb.toString();
	}


	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
	}
}