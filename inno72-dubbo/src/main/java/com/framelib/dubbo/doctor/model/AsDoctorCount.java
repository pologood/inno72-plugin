package com.framelib.dubbo.doctor.model;

import java.io.Serializable;

public class AsDoctorCount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3897231437465344880L;

	private String id;

	private String doctorId;

	private Integer dayCounts;

	private Integer counts;

	private Integer dayReceives;

	private Integer receives;
	
	

	public AsDoctorCount(String id, String doctorId, Integer dayCounts, Integer counts, Integer dayReceives,
			Integer receives) {
		super();
		this.id = id;
		this.doctorId = doctorId;
		this.dayCounts = dayCounts;
		this.counts = counts;
		this.dayReceives = dayReceives;
		this.receives = receives;
	}
	
	public AsDoctorCount(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId == null ? null : doctorId.trim();
	}

	public Integer getDayCounts() {
		return dayCounts;
	}

	public void setDayCounts(Integer dayCounts) {
		this.dayCounts = dayCounts;
	}

	public Integer getCounts() {
		return counts;
	}

	public void setCounts(Integer counts) {
		this.counts = counts;
	}

	public Integer getDayReceives() {
		return dayReceives;
	}

	public void setDayReceives(Integer dayReceives) {
		this.dayReceives = dayReceives;
	}

	public Integer getReceives() {
		return receives;
	}

	public void setReceives(Integer receives) {
		this.receives = receives;
	}
}