package com.point72.wechat.poi;

import java.util.ArrayList;
import java.util.List;

import com.point72.wechat.common.BaseModel;

public class Poi extends BaseModel {

	private BaseInfo base_info;

	public class BaseInfo {

		private String poi_id;
		private String sid;
		private String business_name;
		private String branch_name;
		private String province;
		private String city;
		private String district;
		private String address;
		private String telephone;
		private List<String> categories;
		private Integer offset_type;
		private Double longitude;
		private Double latitude;
		private List<Photo> photo_list;
		private String recommend;
		private String special;
		private String introduction;
		private String open_time;
		private Integer avg_price;

		private String update_status;

		public void addCategories(String category) {
			if (categories == null) {
				categories = new ArrayList<>();
			}
			categories.add(category);
		}

		public void addPhoto(String photo) {
			if (photo_list == null) {
				photo_list = new ArrayList<>();
			}
			photo_list.add(new Photo(photo));
		}

		public class Photo {
			private String photo_url;

			public String getPhoto_url() {
				return photo_url;
			}

			public Photo(String url) {
				this.photo_url = url;
			}

		}

		public String getPoi_id() {
			return poi_id;
		}

		public void setPoi_id(String poi_id) {
			this.poi_id = poi_id;
		}

		public String getSid() {
			return sid;
		}

		public void setSid(String sid) {
			this.sid = sid;
		}

		public String getBusiness_name() {
			return business_name;
		}

		public void setBusiness_name(String business_name) {
			this.business_name = business_name;
		}

		public String getBranch_name() {
			return branch_name;
		}

		public void setBranch_name(String branch_name) {
			this.branch_name = branch_name;
		}

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

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

		public List<String> getCategories() {
			return categories;
		}

		public void setCategories(List<String> categories) {
			this.categories = categories;
		}

		public Integer getOffset_type() {
			return offset_type;
		}

		public void setOffset_type(Integer offset_type) {
			this.offset_type = offset_type;
		}

		public Double getLongitude() {
			return longitude;
		}

		public void setLongitude(Double longitude) {
			this.longitude = longitude;
		}

		public Double getLatitude() {
			return latitude;
		}

		public void setLatitude(Double latitude) {
			this.latitude = latitude;
		}

		public List<Photo> getPhoto_list() {
			return photo_list;
		}

		public void setPhoto_list(List<Photo> photo_list) {
			this.photo_list = photo_list;
		}

		public String getRecommend() {
			return recommend;
		}

		public void setRecommend(String recommend) {
			this.recommend = recommend;
		}

		public String getSpecial() {
			return special;
		}

		public void setSpecial(String special) {
			this.special = special;
		}

		public String getIntroduction() {
			return introduction;
		}

		public void setIntroduction(String introduction) {
			this.introduction = introduction;
		}

		public String getOpen_time() {
			return open_time;
		}

		public void setOpen_time(String open_time) {
			this.open_time = open_time;
		}

		public Integer getAvg_price() {
			return avg_price;
		}

		public void setAvg_price(Integer avg_price) {
			this.avg_price = avg_price;
		}

		public String getUpdate_status() {
			return update_status;
		}

		public void setUpdate_status(String update_status) {
			this.update_status = update_status;
		}

	}

	public BaseInfo getBase_info() {
		return base_info;
	}

	public void setBase_info(BaseInfo base_info) {
		this.base_info = base_info;
	}

}
