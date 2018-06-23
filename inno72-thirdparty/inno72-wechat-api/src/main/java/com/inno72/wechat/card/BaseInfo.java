package com.inno72.wechat.card;

import java.util.List;

public class BaseInfo {

	private String logo_url;
	private String brand_name;
	private String code_type;
	private String title;
	private String color;
	private String notice;
	private String service_phone;
	private String description;
	private Date_info date_info;
	private Sku sku;
	private int use_limit;
	private int get_limit;
	private boolean use_custom_code;
	private boolean bind_openid;
	private boolean can_share;
	private boolean can_give_friend;
	private List<Integer> location_id_list;
	private String center_title;
	private String center_sub_title;
	private String center_url;
	private String custom_url_name;
	private String custom_url;
	private String custom_url_sub_title;
	private String promotion_url_name;
	private String promotion_url;
	private String source;

	public void setLogo_url(String logo_url) {
		this.logo_url = logo_url;
	}

	public String getLogo_url() {
		return logo_url;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setCode_type(String code_type) {
		this.code_type = code_type;
	}

	public String getCode_type() {
		return code_type;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getNotice() {
		return notice;
	}

	public void setService_phone(String service_phone) {
		this.service_phone = service_phone;
	}

	public String getService_phone() {
		return service_phone;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDate_info(Date_info date_info) {
		this.date_info = date_info;
	}

	public Date_info getDate_info() {
		return date_info;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public Sku getSku() {
		return sku;
	}

	public void setUse_limit(int use_limit) {
		this.use_limit = use_limit;
	}

	public int getUse_limit() {
		return use_limit;
	}

	public void setGet_limit(int get_limit) {
		this.get_limit = get_limit;
	}

	public int getGet_limit() {
		return get_limit;
	}

	public void setUse_custom_code(boolean use_custom_code) {
		this.use_custom_code = use_custom_code;
	}

	public boolean getUse_custom_code() {
		return use_custom_code;
	}

	public void setBind_openid(boolean bind_openid) {
		this.bind_openid = bind_openid;
	}

	public boolean getBind_openid() {
		return bind_openid;
	}

	public void setCan_share(boolean can_share) {
		this.can_share = can_share;
	}

	public boolean getCan_share() {
		return can_share;
	}

	public void setCan_give_friend(boolean can_give_friend) {
		this.can_give_friend = can_give_friend;
	}

	public boolean getCan_give_friend() {
		return can_give_friend;
	}

	public void setLocation_id_list(List<Integer> location_id_list) {
		this.location_id_list = location_id_list;
	}

	public List<Integer> getLocation_id_list() {
		return location_id_list;
	}

	public void setCenter_title(String center_title) {
		this.center_title = center_title;
	}

	public String getCenter_title() {
		return center_title;
	}

	public void setCenter_sub_title(String center_sub_title) {
		this.center_sub_title = center_sub_title;
	}

	public String getCenter_sub_title() {
		return center_sub_title;
	}

	public void setCenter_url(String center_url) {
		this.center_url = center_url;
	}

	public String getCenter_url() {
		return center_url;
	}

	public void setCustom_url_name(String custom_url_name) {
		this.custom_url_name = custom_url_name;
	}

	public String getCustom_url_name() {
		return custom_url_name;
	}

	public void setCustom_url(String custom_url) {
		this.custom_url = custom_url;
	}

	public String getCustom_url() {
		return custom_url;
	}

	public void setCustom_url_sub_title(String custom_url_sub_title) {
		this.custom_url_sub_title = custom_url_sub_title;
	}

	public String getCustom_url_sub_title() {
		return custom_url_sub_title;
	}

	public void setPromotion_url_name(String promotion_url_name) {
		this.promotion_url_name = promotion_url_name;
	}

	public String getPromotion_url_name() {
		return promotion_url_name;
	}

	public void setPromotion_url(String promotion_url) {
		this.promotion_url = promotion_url;
	}

	public String getPromotion_url() {
		return promotion_url;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getSource() {
		return source;
	}

}

class Date_info {

	private String type;
	private int begin_timestamp;
	private int end_timestamp;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setBegin_timestamp(int begin_timestamp) {
		this.begin_timestamp = begin_timestamp;
	}

	public int getBegin_timestamp() {
		return begin_timestamp;
	}

	public void setEnd_timestamp(int end_timestamp) {
		this.end_timestamp = end_timestamp;
	}

	public int getEnd_timestamp() {
		return end_timestamp;
	}

}

class Sku {

	private int quantity;

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

}