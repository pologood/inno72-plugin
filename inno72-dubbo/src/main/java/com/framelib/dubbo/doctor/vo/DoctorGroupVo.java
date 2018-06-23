package com.framelib.dubbo.doctor.vo;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.framelib.dubbo.doctor.model.DoctorGroup;

public class DoctorGroupVo extends DoctorGroup {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7838642812199217720L;
	private String fatherGroup;// 所属组
	private String headman;// 组长
	private List<DoctorGroup> sonGroups;

	public String getFatherGroup() {
		return fatherGroup;
	}

	public void setFatherGroup(String fatherGroup) {
		this.fatherGroup = fatherGroup;
	}

	public String getHeadman() {
		return headman;
	}

	public void setHeadman(String headman) {
		this.headman = headman;
	}

	public List<DoctorGroup> getSonGroups() {
		return sonGroups;
	}

	public void setSonGroups(List<DoctorGroup> sonGroups) {
		this.sonGroups = sonGroups;
	}

	@Override
    public String toString(){
    	return ToStringBuilder.reflectionToString(DoctorGroup.class,ToStringStyle.DEFAULT_STYLE);
    }
}
