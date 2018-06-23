package com.framelib.dubbo.model;

public class Address extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8475966312955288362L;

	private String province;
	private String city;
	private String district;
	private String address;
	private double longitude;
	private double latitude;
	private String poi;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getPoi() {
		return poi;
	}

	public void setPoi(String poi) {
		this.poi = poi;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
