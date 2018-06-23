package com.framelib.dubbo.doctor.model;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.framelib.dubbo.model.BaseModel;

/**
 * 医生业务信息表 mysql
 */
public class DoctorBusinessProperty extends BaseModel{
    /**
	 * 
	 */
	private static final long serialVersionUID = 977470723710965291L;

	private Integer id;
    private Integer doctorId;
    /** 开关状态 0 关 1 开 */
    private Integer sOpenType;
    public enum OpenType{

		CLOSE(0,"关"),OPEN(1,"开");

		private Integer key;
		private String value;

		OpenType(Integer key,String value){
			this.key = key;
			this.value =value;
		}

		public Integer getKey() { return key; }
		public String getValue() { return value; }
	}
    /** 接诊状态0-未接诊：1 -已接诊  */
    private Integer sAcceptType;
    public enum AcceptType{

		NOT(0,"未接诊"),READY(1,"派单"),YET(2,"接诊中"),OVER(3,"接诊结束");

		private Integer key;
		private String value;

		AcceptType(Integer key,String value){
			this.key = key;
			this.value =value;
		}

		public Integer getKey() { return key; }
		public String getValue() { return value; }
	}
    /** 信用等级（医生信用分组）2白名单（最高）1黄名单（中等）0黑名单（最差） */
    private Integer sCreditLv;
    /** 看诊类型 */
    private String sAdmissionsType;
    /** 门诊价格 */
    private BigDecimal mPrice;
    
    /** 家庭医生在线状态 {@link OpenType}*/
    private Integer homeDoctorOnline;
    
    /**
     * 附近医生在线状态
     */
    private Integer nearbyDoctorOnline;
    
    /**
     * 速诊医生基础价格
     */
    private BigDecimal sBasePrice;
    
    
    private Integer sNetworkStatus;
    
    
    

    public Integer getsNetworkStatus() {
		return sNetworkStatus;
	}

	public void setsNetworkStatus(Integer sNetworkStatus) {
		this.sNetworkStatus = sNetworkStatus;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getsOpenType() {
        return sOpenType;
    }

    public void setsOpenType(Integer sOpenType) {
        this.sOpenType = sOpenType;
    }

    public Integer getsAcceptType() {
        return sAcceptType;
    }

    public void setsAcceptType(Integer sAcceptType) {
        this.sAcceptType = sAcceptType;
    }

    public Integer getsCreditLv() {
        return sCreditLv;
    }

    public void setsCreditLv(Integer sCreditLv) {
        this.sCreditLv = sCreditLv;
    }

    public String getsAdmissionsType() {
        return sAdmissionsType;
    }

    public void setsAdmissionsType(String sAdmissionsType) {
        this.sAdmissionsType = sAdmissionsType;
    }

    public BigDecimal getmPrice() {
        return mPrice;
    }

    public void setmPrice(BigDecimal mPrice) {
        this.mPrice = mPrice;
    }
    

    public Integer getHomeDoctorOnline() {
		return homeDoctorOnline;
	}

	public void setHomeDoctorOnline(Integer homeDoctorOnline) {
		this.homeDoctorOnline = homeDoctorOnline;
	}

	public Integer getNearbyDoctorOnline() {
		return nearbyDoctorOnline;
	}

	public void setNearbyDoctorOnline(Integer nearbyDoctorOnline) {
		this.nearbyDoctorOnline = nearbyDoctorOnline;
	}

	public BigDecimal getsBasePrice() {
		return sBasePrice;
	}

	public void setsBasePrice(BigDecimal sBasePrice) {
		this.sBasePrice = sBasePrice;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,ToStringStyle.DEFAULT_STYLE);
	}
}