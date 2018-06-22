package com.point72.wechat.card;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class AdvancedInfo {

	private Use_condition use_condition;
	@JSONField(name = "abstract")
	private Cover cover;
	private List<Text_image_list> text_image_list;
	private List<Time_limit> time_limit;
	private List<String> business_service;

	public void setUse_condition(Use_condition use_condition) {
		this.use_condition = use_condition;
	}

	public Use_condition getUse_condition() {
		return use_condition;
	}

	public Cover getCover() {
		return cover;
	}

	public void setCover(Cover cover) {
		this.cover = cover;
	}

	public void setText_image_list(List<Text_image_list> text_image_list) {
		this.text_image_list = text_image_list;
	}

	public List<Text_image_list> getText_image_list() {
		return text_image_list;
	}

	public void setTime_limit(List<Time_limit> time_limit) {
		this.time_limit = time_limit;
	}

	public List<Time_limit> getTime_limit() {
		return time_limit;
	}

	public void setBusiness_service(List<String> business_service) {
		this.business_service = business_service;
	}

	public List<String> getBusiness_service() {
		return business_service;
	}

}

class Use_condition {

	private String accept_category;
	private String reject_category;
	private boolean can_use_with_other_discount;

	public void setAccept_category(String accept_category) {
		this.accept_category = accept_category;
	}

	public String getAccept_category() {
		return accept_category;
	}

	public void setReject_category(String reject_category) {
		this.reject_category = reject_category;
	}

	public String getReject_category() {
		return reject_category;
	}

	public void setCan_use_with_other_discount(boolean can_use_with_other_discount) {
		this.can_use_with_other_discount = can_use_with_other_discount;
	}

	public boolean getCan_use_with_other_discount() {
		return can_use_with_other_discount;
	}

}

class Cover {

	@JSONField(name = "abstract")
	private String cover;
	private List<String> icon_url_list;

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public void setIcon_url_list(List<String> icon_url_list) {
		this.icon_url_list = icon_url_list;
	}

	public List<String> getIcon_url_list() {
		return icon_url_list;
	}

}

class Text_image_list {

	private String image_url;
	private String text;

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}

class Time_limit {

	private String type;
	private int begin_hour;
	private int end_hour;
	private int begin_minute;
	private int end_minute;

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setBegin_hour(int begin_hour) {
		this.begin_hour = begin_hour;
	}

	public int getBegin_hour() {
		return begin_hour;
	}

	public void setEnd_hour(int end_hour) {
		this.end_hour = end_hour;
	}

	public int getEnd_hour() {
		return end_hour;
	}

	public void setBegin_minute(int begin_minute) {
		this.begin_minute = begin_minute;
	}

	public int getBegin_minute() {
		return begin_minute;
	}

	public void setEnd_minute(int end_minute) {
		this.end_minute = end_minute;
	}

	public int getEnd_minute() {
		return end_minute;
	}

}