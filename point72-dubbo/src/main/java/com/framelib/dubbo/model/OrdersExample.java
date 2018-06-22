package com.framelib.dubbo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Integer startLine;
	protected Integer dataSize;

	public OrdersExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public Integer getStartLine() {
		return startLine;
	}

	public void setStartLine(Integer startLine) {
		this.startLine = startLine;
	}

	public Integer getDataSize() {
		return dataSize;
	}

	public void setDataSize(Integer dataSize) {
		this.dataSize = dataSize;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andIdIsNull() {
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(String value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(String value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(String value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(String value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(String value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(String value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLike(String value) {
			addCriterion("id like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotLike(String value) {
			addCriterion("id not like", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<String> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<String> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(String value1, String value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(String value1, String value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andOrderNumIsNull() {
			addCriterion("order_num is null");
			return (Criteria) this;
		}

		public Criteria andOrderNumIsNotNull() {
			addCriterion("order_num is not null");
			return (Criteria) this;
		}

		public Criteria andOrderNumEqualTo(String value) {
			addCriterion("order_num =", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumNotEqualTo(String value) {
			addCriterion("order_num <>", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumGreaterThan(String value) {
			addCriterion("order_num >", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumGreaterThanOrEqualTo(String value) {
			addCriterion("order_num >=", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumLessThan(String value) {
			addCriterion("order_num <", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumLessThanOrEqualTo(String value) {
			addCriterion("order_num <=", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumLike(String value) {
			addCriterion("order_num like", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumNotLike(String value) {
			addCriterion("order_num not like", value, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumIn(List<String> values) {
			addCriterion("order_num in", values, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumNotIn(List<String> values) {
			addCriterion("order_num not in", values, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumBetween(String value1, String value2) {
			addCriterion("order_num between", value1, value2, "orderNum");
			return (Criteria) this;
		}

		public Criteria andOrderNumNotBetween(String value1, String value2) {
			addCriterion("order_num not between", value1, value2, "orderNum");
			return (Criteria) this;
		}

		public Criteria andUserTelnoIsNull() {
			addCriterion("user_telno is null");
			return (Criteria) this;
		}

		public Criteria andUserTelnoIsNotNull() {
			addCriterion("user_telno is not null");
			return (Criteria) this;
		}

		public Criteria andUserTelnoEqualTo(String value) {
			addCriterion("user_telno =", value, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserTelnoNotEqualTo(String value) {
			addCriterion("user_telno <>", value, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserTelnoGreaterThan(String value) {
			addCriterion("user_telno >", value, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserTelnoGreaterThanOrEqualTo(String value) {
			addCriterion("user_telno >=", value, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserTelnoLessThan(String value) {
			addCriterion("user_telno <", value, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserTelnoLessThanOrEqualTo(String value) {
			addCriterion("user_telno <=", value, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserTelnoLike(String value) {
			addCriterion("user_telno like", value, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserTelnoNotLike(String value) {
			addCriterion("user_telno not like", value, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserTelnoIn(List<String> values) {
			addCriterion("user_telno in", values, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserTelnoNotIn(List<String> values) {
			addCriterion("user_telno not in", values, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserTelnoBetween(String value1, String value2) {
			addCriterion("user_telno between", value1, value2, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserTelnoNotBetween(String value1, String value2) {
			addCriterion("user_telno not between", value1, value2, "userTelno");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(String value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(String value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(String value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(String value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(String value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLike(String value) {
			addCriterion("user_id like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotLike(String value) {
			addCriterion("user_id not like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<String> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<String> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(String value1, String value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(String value1, String value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdIsNull() {
			addCriterion("performer_id is null");
			return (Criteria) this;
		}

		public Criteria andPerformerIdIsNotNull() {
			addCriterion("performer_id is not null");
			return (Criteria) this;
		}

		public Criteria andPerformerIdEqualTo(String value) {
			addCriterion("performer_id =", value, "performerId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdNotEqualTo(String value) {
			addCriterion("performer_id <>", value, "performerId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdGreaterThan(String value) {
			addCriterion("performer_id >", value, "performerId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdGreaterThanOrEqualTo(String value) {
			addCriterion("performer_id >=", value, "performerId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdLessThan(String value) {
			addCriterion("performer_id <", value, "performerId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdLessThanOrEqualTo(String value) {
			addCriterion("performer_id <=", value, "performerId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdLike(String value) {
			addCriterion("performer_id like", value, "performerId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdNotLike(String value) {
			addCriterion("performer_id not like", value, "performerId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdIn(List<String> values) {
			addCriterion("performer_id in", values, "performerId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdNotIn(List<String> values) {
			addCriterion("performer_id not in", values, "performerId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdBetween(String value1, String value2) {
			addCriterion("performer_id between", value1, value2, "performerId");
			return (Criteria) this;
		}

		public Criteria andPerformerIdNotBetween(String value1, String value2) {
			addCriterion("performer_id not between", value1, value2, "performerId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdIsNull() {
			addCriterion("doctor_id is null");
			return (Criteria) this;
		}

		public Criteria andDoctorIdIsNotNull() {
			addCriterion("doctor_id is not null");
			return (Criteria) this;
		}

		public Criteria andDoctorIdEqualTo(String value) {
			addCriterion("doctor_id =", value, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdNotEqualTo(String value) {
			addCriterion("doctor_id <>", value, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdGreaterThan(String value) {
			addCriterion("doctor_id >", value, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdGreaterThanOrEqualTo(String value) {
			addCriterion("doctor_id >=", value, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdLessThan(String value) {
			addCriterion("doctor_id <", value, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdLessThanOrEqualTo(String value) {
			addCriterion("doctor_id <=", value, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdLike(String value) {
			addCriterion("doctor_id like", value, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdNotLike(String value) {
			addCriterion("doctor_id not like", value, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdIn(List<String> values) {
			addCriterion("doctor_id in", values, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdNotIn(List<String> values) {
			addCriterion("doctor_id not in", values, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdBetween(String value1, String value2) {
			addCriterion("doctor_id between", value1, value2, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorIdNotBetween(String value1, String value2) {
			addCriterion("doctor_id not between", value1, value2, "doctorId");
			return (Criteria) this;
		}

		public Criteria andDoctorNameIsNull() {
			addCriterion("doctor_name is null");
			return (Criteria) this;
		}

		public Criteria andDoctorNameIsNotNull() {
			addCriterion("doctor_name is not null");
			return (Criteria) this;
		}

		public Criteria andDoctorNameEqualTo(String value) {
			addCriterion("doctor_name =", value, "doctorName");
			return (Criteria) this;
		}

		public Criteria andDoctorNameNotEqualTo(String value) {
			addCriterion("doctor_name <>", value, "doctorName");
			return (Criteria) this;
		}

		public Criteria andDoctorNameGreaterThan(String value) {
			addCriterion("doctor_name >", value, "doctorName");
			return (Criteria) this;
		}

		public Criteria andDoctorNameGreaterThanOrEqualTo(String value) {
			addCriterion("doctor_name >=", value, "doctorName");
			return (Criteria) this;
		}

		public Criteria andDoctorNameLessThan(String value) {
			addCriterion("doctor_name <", value, "doctorName");
			return (Criteria) this;
		}

		public Criteria andDoctorNameLessThanOrEqualTo(String value) {
			addCriterion("doctor_name <=", value, "doctorName");
			return (Criteria) this;
		}

		public Criteria andDoctorNameLike(String value) {
			addCriterion("doctor_name like", value, "doctorName");
			return (Criteria) this;
		}

		public Criteria andDoctorNameNotLike(String value) {
			addCriterion("doctor_name not like", value, "doctorName");
			return (Criteria) this;
		}

		public Criteria andDoctorNameIn(List<String> values) {
			addCriterion("doctor_name in", values, "doctorName");
			return (Criteria) this;
		}

		public Criteria andDoctorNameNotIn(List<String> values) {
			addCriterion("doctor_name not in", values, "doctorName");
			return (Criteria) this;
		}

		public Criteria andDoctorNameBetween(String value1, String value2) {
			addCriterion("doctor_name between", value1, value2, "doctorName");
			return (Criteria) this;
		}

		public Criteria andDoctorNameNotBetween(String value1, String value2) {
			addCriterion("doctor_name not between", value1, value2, "doctorName");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIsNull() {
			addCriterion("goods_price is null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIsNotNull() {
			addCriterion("goods_price is not null");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceEqualTo(Long value) {
			addCriterion("goods_price =", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotEqualTo(Long value) {
			addCriterion("goods_price <>", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThan(Long value) {
			addCriterion("goods_price >", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceGreaterThanOrEqualTo(Long value) {
			addCriterion("goods_price >=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThan(Long value) {
			addCriterion("goods_price <", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceLessThanOrEqualTo(Long value) {
			addCriterion("goods_price <=", value, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceIn(List<Long> values) {
			addCriterion("goods_price in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotIn(List<Long> values) {
			addCriterion("goods_price not in", values, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceBetween(Long value1, Long value2) {
			addCriterion("goods_price between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andGoodsPriceNotBetween(Long value1, Long value2) {
			addCriterion("goods_price not between", value1, value2, "goodsPrice");
			return (Criteria) this;
		}

		public Criteria andOrderPriceIsNull() {
			addCriterion("order_price is null");
			return (Criteria) this;
		}

		public Criteria andOrderPriceIsNotNull() {
			addCriterion("order_price is not null");
			return (Criteria) this;
		}

		public Criteria andOrderPriceEqualTo(Long value) {
			addCriterion("order_price =", value, "orderPrice");
			return (Criteria) this;
		}

		public Criteria andOrderPriceNotEqualTo(Long value) {
			addCriterion("order_price <>", value, "orderPrice");
			return (Criteria) this;
		}

		public Criteria andOrderPriceGreaterThan(Long value) {
			addCriterion("order_price >", value, "orderPrice");
			return (Criteria) this;
		}

		public Criteria andOrderPriceGreaterThanOrEqualTo(Long value) {
			addCriterion("order_price >=", value, "orderPrice");
			return (Criteria) this;
		}

		public Criteria andOrderPriceLessThan(Long value) {
			addCriterion("order_price <", value, "orderPrice");
			return (Criteria) this;
		}

		public Criteria andOrderPriceLessThanOrEqualTo(Long value) {
			addCriterion("order_price <=", value, "orderPrice");
			return (Criteria) this;
		}

		public Criteria andOrderPriceIn(List<Long> values) {
			addCriterion("order_price in", values, "orderPrice");
			return (Criteria) this;
		}

		public Criteria andOrderPriceNotIn(List<Long> values) {
			addCriterion("order_price not in", values, "orderPrice");
			return (Criteria) this;
		}

		public Criteria andOrderPriceBetween(Long value1, Long value2) {
			addCriterion("order_price between", value1, value2, "orderPrice");
			return (Criteria) this;
		}

		public Criteria andOrderPriceNotBetween(Long value1, Long value2) {
			addCriterion("order_price not between", value1, value2, "orderPrice");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceIsNull() {
			addCriterion("discount_price is null");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceIsNotNull() {
			addCriterion("discount_price is not null");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceEqualTo(Long value) {
			addCriterion("discount_price =", value, "discountPrice");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceNotEqualTo(Long value) {
			addCriterion("discount_price <>", value, "discountPrice");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceGreaterThan(Long value) {
			addCriterion("discount_price >", value, "discountPrice");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceGreaterThanOrEqualTo(Long value) {
			addCriterion("discount_price >=", value, "discountPrice");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceLessThan(Long value) {
			addCriterion("discount_price <", value, "discountPrice");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceLessThanOrEqualTo(Long value) {
			addCriterion("discount_price <=", value, "discountPrice");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceIn(List<Long> values) {
			addCriterion("discount_price in", values, "discountPrice");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceNotIn(List<Long> values) {
			addCriterion("discount_price not in", values, "discountPrice");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceBetween(Long value1, Long value2) {
			addCriterion("discount_price between", value1, value2, "discountPrice");
			return (Criteria) this;
		}

		public Criteria andDiscountPriceNotBetween(Long value1, Long value2) {
			addCriterion("discount_price not between", value1, value2, "discountPrice");
			return (Criteria) this;
		}

		public Criteria andPayPriceIsNull() {
			addCriterion("pay_price is null");
			return (Criteria) this;
		}

		public Criteria andPayPriceIsNotNull() {
			addCriterion("pay_price is not null");
			return (Criteria) this;
		}

		public Criteria andPayPriceEqualTo(Long value) {
			addCriterion("pay_price =", value, "payPrice");
			return (Criteria) this;
		}

		public Criteria andPayPriceNotEqualTo(Long value) {
			addCriterion("pay_price <>", value, "payPrice");
			return (Criteria) this;
		}

		public Criteria andPayPriceGreaterThan(Long value) {
			addCriterion("pay_price >", value, "payPrice");
			return (Criteria) this;
		}

		public Criteria andPayPriceGreaterThanOrEqualTo(Long value) {
			addCriterion("pay_price >=", value, "payPrice");
			return (Criteria) this;
		}

		public Criteria andPayPriceLessThan(Long value) {
			addCriterion("pay_price <", value, "payPrice");
			return (Criteria) this;
		}

		public Criteria andPayPriceLessThanOrEqualTo(Long value) {
			addCriterion("pay_price <=", value, "payPrice");
			return (Criteria) this;
		}

		public Criteria andPayPriceIn(List<Long> values) {
			addCriterion("pay_price in", values, "payPrice");
			return (Criteria) this;
		}

		public Criteria andPayPriceNotIn(List<Long> values) {
			addCriterion("pay_price not in", values, "payPrice");
			return (Criteria) this;
		}

		public Criteria andPayPriceBetween(Long value1, Long value2) {
			addCriterion("pay_price between", value1, value2, "payPrice");
			return (Criteria) this;
		}

		public Criteria andPayPriceNotBetween(Long value1, Long value2) {
			addCriterion("pay_price not between", value1, value2, "payPrice");
			return (Criteria) this;
		}

		public Criteria andExt1PriceIsNull() {
			addCriterion("ext1_price is null");
			return (Criteria) this;
		}

		public Criteria andExt1PriceIsNotNull() {
			addCriterion("ext1_price is not null");
			return (Criteria) this;
		}

		public Criteria andExt1PriceEqualTo(Long value) {
			addCriterion("ext1_price =", value, "ext1Price");
			return (Criteria) this;
		}

		public Criteria andExt1PriceNotEqualTo(Long value) {
			addCriterion("ext1_price <>", value, "ext1Price");
			return (Criteria) this;
		}

		public Criteria andExt1PriceGreaterThan(Long value) {
			addCriterion("ext1_price >", value, "ext1Price");
			return (Criteria) this;
		}

		public Criteria andExt1PriceGreaterThanOrEqualTo(Long value) {
			addCriterion("ext1_price >=", value, "ext1Price");
			return (Criteria) this;
		}

		public Criteria andExt1PriceLessThan(Long value) {
			addCriterion("ext1_price <", value, "ext1Price");
			return (Criteria) this;
		}

		public Criteria andExt1PriceLessThanOrEqualTo(Long value) {
			addCriterion("ext1_price <=", value, "ext1Price");
			return (Criteria) this;
		}

		public Criteria andExt1PriceIn(List<Long> values) {
			addCriterion("ext1_price in", values, "ext1Price");
			return (Criteria) this;
		}

		public Criteria andExt1PriceNotIn(List<Long> values) {
			addCriterion("ext1_price not in", values, "ext1Price");
			return (Criteria) this;
		}

		public Criteria andExt1PriceBetween(Long value1, Long value2) {
			addCriterion("ext1_price between", value1, value2, "ext1Price");
			return (Criteria) this;
		}

		public Criteria andExt1PriceNotBetween(Long value1, Long value2) {
			addCriterion("ext1_price not between", value1, value2, "ext1Price");
			return (Criteria) this;
		}

		public Criteria andExt2PriceIsNull() {
			addCriterion("ext2_price is null");
			return (Criteria) this;
		}

		public Criteria andExt2PriceIsNotNull() {
			addCriterion("ext2_price is not null");
			return (Criteria) this;
		}

		public Criteria andExt2PriceEqualTo(Long value) {
			addCriterion("ext2_price =", value, "ext2Price");
			return (Criteria) this;
		}

		public Criteria andExt2PriceNotEqualTo(Long value) {
			addCriterion("ext2_price <>", value, "ext2Price");
			return (Criteria) this;
		}

		public Criteria andExt2PriceGreaterThan(Long value) {
			addCriterion("ext2_price >", value, "ext2Price");
			return (Criteria) this;
		}

		public Criteria andExt2PriceGreaterThanOrEqualTo(Long value) {
			addCriterion("ext2_price >=", value, "ext2Price");
			return (Criteria) this;
		}

		public Criteria andExt2PriceLessThan(Long value) {
			addCriterion("ext2_price <", value, "ext2Price");
			return (Criteria) this;
		}

		public Criteria andExt2PriceLessThanOrEqualTo(Long value) {
			addCriterion("ext2_price <=", value, "ext2Price");
			return (Criteria) this;
		}

		public Criteria andExt2PriceIn(List<Long> values) {
			addCriterion("ext2_price in", values, "ext2Price");
			return (Criteria) this;
		}

		public Criteria andExt2PriceNotIn(List<Long> values) {
			addCriterion("ext2_price not in", values, "ext2Price");
			return (Criteria) this;
		}

		public Criteria andExt2PriceBetween(Long value1, Long value2) {
			addCriterion("ext2_price between", value1, value2, "ext2Price");
			return (Criteria) this;
		}

		public Criteria andExt2PriceNotBetween(Long value1, Long value2) {
			addCriterion("ext2_price not between", value1, value2, "ext2Price");
			return (Criteria) this;
		}

		public Criteria andExt3PriceIsNull() {
			addCriterion("ext3_price is null");
			return (Criteria) this;
		}

		public Criteria andExt3PriceIsNotNull() {
			addCriterion("ext3_price is not null");
			return (Criteria) this;
		}

		public Criteria andExt3PriceEqualTo(Long value) {
			addCriterion("ext3_price =", value, "ext3Price");
			return (Criteria) this;
		}

		public Criteria andExt3PriceNotEqualTo(Long value) {
			addCriterion("ext3_price <>", value, "ext3Price");
			return (Criteria) this;
		}

		public Criteria andExt3PriceGreaterThan(Long value) {
			addCriterion("ext3_price >", value, "ext3Price");
			return (Criteria) this;
		}

		public Criteria andExt3PriceGreaterThanOrEqualTo(Long value) {
			addCriterion("ext3_price >=", value, "ext3Price");
			return (Criteria) this;
		}

		public Criteria andExt3PriceLessThan(Long value) {
			addCriterion("ext3_price <", value, "ext3Price");
			return (Criteria) this;
		}

		public Criteria andExt3PriceLessThanOrEqualTo(Long value) {
			addCriterion("ext3_price <=", value, "ext3Price");
			return (Criteria) this;
		}

		public Criteria andExt3PriceIn(List<Long> values) {
			addCriterion("ext3_price in", values, "ext3Price");
			return (Criteria) this;
		}

		public Criteria andExt3PriceNotIn(List<Long> values) {
			addCriterion("ext3_price not in", values, "ext3Price");
			return (Criteria) this;
		}

		public Criteria andExt3PriceBetween(Long value1, Long value2) {
			addCriterion("ext3_price between", value1, value2, "ext3Price");
			return (Criteria) this;
		}

		public Criteria andExt3PriceNotBetween(Long value1, Long value2) {
			addCriterion("ext3_price not between", value1, value2, "ext3Price");
			return (Criteria) this;
		}

		public Criteria andExt4PriceIsNull() {
			addCriterion("ext4_price is null");
			return (Criteria) this;
		}

		public Criteria andExt4PriceIsNotNull() {
			addCriterion("ext4_price is not null");
			return (Criteria) this;
		}

		public Criteria andExt4PriceEqualTo(Long value) {
			addCriterion("ext4_price =", value, "ext4Price");
			return (Criteria) this;
		}

		public Criteria andExt4PriceNotEqualTo(Long value) {
			addCriterion("ext4_price <>", value, "ext4Price");
			return (Criteria) this;
		}

		public Criteria andExt4PriceGreaterThan(Long value) {
			addCriterion("ext4_price >", value, "ext4Price");
			return (Criteria) this;
		}

		public Criteria andExt4PriceGreaterThanOrEqualTo(Long value) {
			addCriterion("ext4_price >=", value, "ext4Price");
			return (Criteria) this;
		}

		public Criteria andExt4PriceLessThan(Long value) {
			addCriterion("ext4_price <", value, "ext4Price");
			return (Criteria) this;
		}

		public Criteria andExt4PriceLessThanOrEqualTo(Long value) {
			addCriterion("ext4_price <=", value, "ext4Price");
			return (Criteria) this;
		}

		public Criteria andExt4PriceIn(List<Long> values) {
			addCriterion("ext4_price in", values, "ext4Price");
			return (Criteria) this;
		}

		public Criteria andExt4PriceNotIn(List<Long> values) {
			addCriterion("ext4_price not in", values, "ext4Price");
			return (Criteria) this;
		}

		public Criteria andExt4PriceBetween(Long value1, Long value2) {
			addCriterion("ext4_price between", value1, value2, "ext4Price");
			return (Criteria) this;
		}

		public Criteria andExt4PriceNotBetween(Long value1, Long value2) {
			addCriterion("ext4_price not between", value1, value2, "ext4Price");
			return (Criteria) this;
		}

		public Criteria andExt5PriceIsNull() {
			addCriterion("ext5_price is null");
			return (Criteria) this;
		}

		public Criteria andExt5PriceIsNotNull() {
			addCriterion("ext5_price is not null");
			return (Criteria) this;
		}

		public Criteria andExt5PriceEqualTo(Long value) {
			addCriterion("ext5_price =", value, "ext5Price");
			return (Criteria) this;
		}

		public Criteria andExt5PriceNotEqualTo(Long value) {
			addCriterion("ext5_price <>", value, "ext5Price");
			return (Criteria) this;
		}

		public Criteria andExt5PriceGreaterThan(Long value) {
			addCriterion("ext5_price >", value, "ext5Price");
			return (Criteria) this;
		}

		public Criteria andExt5PriceGreaterThanOrEqualTo(Long value) {
			addCriterion("ext5_price >=", value, "ext5Price");
			return (Criteria) this;
		}

		public Criteria andExt5PriceLessThan(Long value) {
			addCriterion("ext5_price <", value, "ext5Price");
			return (Criteria) this;
		}

		public Criteria andExt5PriceLessThanOrEqualTo(Long value) {
			addCriterion("ext5_price <=", value, "ext5Price");
			return (Criteria) this;
		}

		public Criteria andExt5PriceIn(List<Long> values) {
			addCriterion("ext5_price in", values, "ext5Price");
			return (Criteria) this;
		}

		public Criteria andExt5PriceNotIn(List<Long> values) {
			addCriterion("ext5_price not in", values, "ext5Price");
			return (Criteria) this;
		}

		public Criteria andExt5PriceBetween(Long value1, Long value2) {
			addCriterion("ext5_price between", value1, value2, "ext5Price");
			return (Criteria) this;
		}

		public Criteria andExt5PriceNotBetween(Long value1, Long value2) {
			addCriterion("ext5_price not between", value1, value2, "ext5Price");
			return (Criteria) this;
		}

		public Criteria andPayTypeIsNull() {
			addCriterion("pay_type is null");
			return (Criteria) this;
		}

		public Criteria andPayTypeIsNotNull() {
			addCriterion("pay_type is not null");
			return (Criteria) this;
		}

		public Criteria andPayTypeEqualTo(String value) {
			addCriterion("pay_type =", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotEqualTo(String value) {
			addCriterion("pay_type <>", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThan(String value) {
			addCriterion("pay_type >", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
			addCriterion("pay_type >=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThan(String value) {
			addCriterion("pay_type <", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLessThanOrEqualTo(String value) {
			addCriterion("pay_type <=", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeLike(String value) {
			addCriterion("pay_type like", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotLike(String value) {
			addCriterion("pay_type not like", value, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeIn(List<String> values) {
			addCriterion("pay_type in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotIn(List<String> values) {
			addCriterion("pay_type not in", values, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeBetween(String value1, String value2) {
			addCriterion("pay_type between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andPayTypeNotBetween(String value1, String value2) {
			addCriterion("pay_type not between", value1, value2, "payType");
			return (Criteria) this;
		}

		public Criteria andOrderTimeIsNull() {
			addCriterion("order_time is null");
			return (Criteria) this;
		}

		public Criteria andOrderTimeIsNotNull() {
			addCriterion("order_time is not null");
			return (Criteria) this;
		}

		public Criteria andOrderTimeEqualTo(Date value) {
			addCriterion("order_time =", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeNotEqualTo(Date value) {
			addCriterion("order_time <>", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeGreaterThan(Date value) {
			addCriterion("order_time >", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("order_time >=", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeLessThan(Date value) {
			addCriterion("order_time <", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeLessThanOrEqualTo(Date value) {
			addCriterion("order_time <=", value, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeIn(List<Date> values) {
			addCriterion("order_time in", values, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeNotIn(List<Date> values) {
			addCriterion("order_time not in", values, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeBetween(Date value1, Date value2) {
			addCriterion("order_time between", value1, value2, "orderTime");
			return (Criteria) this;
		}

		public Criteria andOrderTimeNotBetween(Date value1, Date value2) {
			addCriterion("order_time not between", value1, value2, "orderTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeIsNull() {
			addCriterion("pay_time is null");
			return (Criteria) this;
		}

		public Criteria andPayTimeIsNotNull() {
			addCriterion("pay_time is not null");
			return (Criteria) this;
		}

		public Criteria andPayTimeEqualTo(Date value) {
			addCriterion("pay_time =", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotEqualTo(Date value) {
			addCriterion("pay_time <>", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeGreaterThan(Date value) {
			addCriterion("pay_time >", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("pay_time >=", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeLessThan(Date value) {
			addCriterion("pay_time <", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeLessThanOrEqualTo(Date value) {
			addCriterion("pay_time <=", value, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeIn(List<Date> values) {
			addCriterion("pay_time in", values, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotIn(List<Date> values) {
			addCriterion("pay_time not in", values, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeBetween(Date value1, Date value2) {
			addCriterion("pay_time between", value1, value2, "payTime");
			return (Criteria) this;
		}

		public Criteria andPayTimeNotBetween(Date value1, Date value2) {
			addCriterion("pay_time not between", value1, value2, "payTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeIsNull() {
			addCriterion("finish_time is null");
			return (Criteria) this;
		}

		public Criteria andFinishTimeIsNotNull() {
			addCriterion("finish_time is not null");
			return (Criteria) this;
		}

		public Criteria andFinishTimeEqualTo(Date value) {
			addCriterion("finish_time =", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotEqualTo(Date value) {
			addCriterion("finish_time <>", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeGreaterThan(Date value) {
			addCriterion("finish_time >", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("finish_time >=", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeLessThan(Date value) {
			addCriterion("finish_time <", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
			addCriterion("finish_time <=", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeIn(List<Date> values) {
			addCriterion("finish_time in", values, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotIn(List<Date> values) {
			addCriterion("finish_time not in", values, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeBetween(Date value1, Date value2) {
			addCriterion("finish_time between", value1, value2, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
			addCriterion("finish_time not between", value1, value2, "finishTime");
			return (Criteria) this;
		}

		public Criteria andRefundTimeIsNull() {
			addCriterion("refund_time is null");
			return (Criteria) this;
		}

		public Criteria andRefundTimeIsNotNull() {
			addCriterion("refund_time is not null");
			return (Criteria) this;
		}

		public Criteria andRefundTimeEqualTo(Date value) {
			addCriterion("refund_time =", value, "refundTime");
			return (Criteria) this;
		}

		public Criteria andRefundTimeNotEqualTo(Date value) {
			addCriterion("refund_time <>", value, "refundTime");
			return (Criteria) this;
		}

		public Criteria andRefundTimeGreaterThan(Date value) {
			addCriterion("refund_time >", value, "refundTime");
			return (Criteria) this;
		}

		public Criteria andRefundTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("refund_time >=", value, "refundTime");
			return (Criteria) this;
		}

		public Criteria andRefundTimeLessThan(Date value) {
			addCriterion("refund_time <", value, "refundTime");
			return (Criteria) this;
		}

		public Criteria andRefundTimeLessThanOrEqualTo(Date value) {
			addCriterion("refund_time <=", value, "refundTime");
			return (Criteria) this;
		}

		public Criteria andRefundTimeIn(List<Date> values) {
			addCriterion("refund_time in", values, "refundTime");
			return (Criteria) this;
		}

		public Criteria andRefundTimeNotIn(List<Date> values) {
			addCriterion("refund_time not in", values, "refundTime");
			return (Criteria) this;
		}

		public Criteria andRefundTimeBetween(Date value1, Date value2) {
			addCriterion("refund_time between", value1, value2, "refundTime");
			return (Criteria) this;
		}

		public Criteria andRefundTimeNotBetween(Date value1, Date value2) {
			addCriterion("refund_time not between", value1, value2, "refundTime");
			return (Criteria) this;
		}

		public Criteria andExt1TimeIsNull() {
			addCriterion("ext1_time is null");
			return (Criteria) this;
		}

		public Criteria andExt1TimeIsNotNull() {
			addCriterion("ext1_time is not null");
			return (Criteria) this;
		}

		public Criteria andExt1TimeEqualTo(Date value) {
			addCriterion("ext1_time =", value, "ext1Time");
			return (Criteria) this;
		}

		public Criteria andExt1TimeNotEqualTo(Date value) {
			addCriterion("ext1_time <>", value, "ext1Time");
			return (Criteria) this;
		}

		public Criteria andExt1TimeGreaterThan(Date value) {
			addCriterion("ext1_time >", value, "ext1Time");
			return (Criteria) this;
		}

		public Criteria andExt1TimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ext1_time >=", value, "ext1Time");
			return (Criteria) this;
		}

		public Criteria andExt1TimeLessThan(Date value) {
			addCriterion("ext1_time <", value, "ext1Time");
			return (Criteria) this;
		}

		public Criteria andExt1TimeLessThanOrEqualTo(Date value) {
			addCriterion("ext1_time <=", value, "ext1Time");
			return (Criteria) this;
		}

		public Criteria andExt1TimeIn(List<Date> values) {
			addCriterion("ext1_time in", values, "ext1Time");
			return (Criteria) this;
		}

		public Criteria andExt1TimeNotIn(List<Date> values) {
			addCriterion("ext1_time not in", values, "ext1Time");
			return (Criteria) this;
		}

		public Criteria andExt1TimeBetween(Date value1, Date value2) {
			addCriterion("ext1_time between", value1, value2, "ext1Time");
			return (Criteria) this;
		}

		public Criteria andExt1TimeNotBetween(Date value1, Date value2) {
			addCriterion("ext1_time not between", value1, value2, "ext1Time");
			return (Criteria) this;
		}

		public Criteria andExt2TimeIsNull() {
			addCriterion("ext2_time is null");
			return (Criteria) this;
		}

		public Criteria andExt2TimeIsNotNull() {
			addCriterion("ext2_time is not null");
			return (Criteria) this;
		}

		public Criteria andExt2TimeEqualTo(Date value) {
			addCriterion("ext2_time =", value, "ext2Time");
			return (Criteria) this;
		}

		public Criteria andExt2TimeNotEqualTo(Date value) {
			addCriterion("ext2_time <>", value, "ext2Time");
			return (Criteria) this;
		}

		public Criteria andExt2TimeGreaterThan(Date value) {
			addCriterion("ext2_time >", value, "ext2Time");
			return (Criteria) this;
		}

		public Criteria andExt2TimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ext2_time >=", value, "ext2Time");
			return (Criteria) this;
		}

		public Criteria andExt2TimeLessThan(Date value) {
			addCriterion("ext2_time <", value, "ext2Time");
			return (Criteria) this;
		}

		public Criteria andExt2TimeLessThanOrEqualTo(Date value) {
			addCriterion("ext2_time <=", value, "ext2Time");
			return (Criteria) this;
		}

		public Criteria andExt2TimeIn(List<Date> values) {
			addCriterion("ext2_time in", values, "ext2Time");
			return (Criteria) this;
		}

		public Criteria andExt2TimeNotIn(List<Date> values) {
			addCriterion("ext2_time not in", values, "ext2Time");
			return (Criteria) this;
		}

		public Criteria andExt2TimeBetween(Date value1, Date value2) {
			addCriterion("ext2_time between", value1, value2, "ext2Time");
			return (Criteria) this;
		}

		public Criteria andExt2TimeNotBetween(Date value1, Date value2) {
			addCriterion("ext2_time not between", value1, value2, "ext2Time");
			return (Criteria) this;
		}

		public Criteria andExt3TimeIsNull() {
			addCriterion("ext3_time is null");
			return (Criteria) this;
		}

		public Criteria andExt3TimeIsNotNull() {
			addCriterion("ext3_time is not null");
			return (Criteria) this;
		}

		public Criteria andExt3TimeEqualTo(Date value) {
			addCriterion("ext3_time =", value, "ext3Time");
			return (Criteria) this;
		}

		public Criteria andExt3TimeNotEqualTo(Date value) {
			addCriterion("ext3_time <>", value, "ext3Time");
			return (Criteria) this;
		}

		public Criteria andExt3TimeGreaterThan(Date value) {
			addCriterion("ext3_time >", value, "ext3Time");
			return (Criteria) this;
		}

		public Criteria andExt3TimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ext3_time >=", value, "ext3Time");
			return (Criteria) this;
		}

		public Criteria andExt3TimeLessThan(Date value) {
			addCriterion("ext3_time <", value, "ext3Time");
			return (Criteria) this;
		}

		public Criteria andExt3TimeLessThanOrEqualTo(Date value) {
			addCriterion("ext3_time <=", value, "ext3Time");
			return (Criteria) this;
		}

		public Criteria andExt3TimeIn(List<Date> values) {
			addCriterion("ext3_time in", values, "ext3Time");
			return (Criteria) this;
		}

		public Criteria andExt3TimeNotIn(List<Date> values) {
			addCriterion("ext3_time not in", values, "ext3Time");
			return (Criteria) this;
		}

		public Criteria andExt3TimeBetween(Date value1, Date value2) {
			addCriterion("ext3_time between", value1, value2, "ext3Time");
			return (Criteria) this;
		}

		public Criteria andExt3TimeNotBetween(Date value1, Date value2) {
			addCriterion("ext3_time not between", value1, value2, "ext3Time");
			return (Criteria) this;
		}

		public Criteria andExt4TimeIsNull() {
			addCriterion("ext4_time is null");
			return (Criteria) this;
		}

		public Criteria andExt4TimeIsNotNull() {
			addCriterion("ext4_time is not null");
			return (Criteria) this;
		}

		public Criteria andExt4TimeEqualTo(Date value) {
			addCriterion("ext4_time =", value, "ext4Time");
			return (Criteria) this;
		}

		public Criteria andExt4TimeNotEqualTo(Date value) {
			addCriterion("ext4_time <>", value, "ext4Time");
			return (Criteria) this;
		}

		public Criteria andExt4TimeGreaterThan(Date value) {
			addCriterion("ext4_time >", value, "ext4Time");
			return (Criteria) this;
		}

		public Criteria andExt4TimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ext4_time >=", value, "ext4Time");
			return (Criteria) this;
		}

		public Criteria andExt4TimeLessThan(Date value) {
			addCriterion("ext4_time <", value, "ext4Time");
			return (Criteria) this;
		}

		public Criteria andExt4TimeLessThanOrEqualTo(Date value) {
			addCriterion("ext4_time <=", value, "ext4Time");
			return (Criteria) this;
		}

		public Criteria andExt4TimeIn(List<Date> values) {
			addCriterion("ext4_time in", values, "ext4Time");
			return (Criteria) this;
		}

		public Criteria andExt4TimeNotIn(List<Date> values) {
			addCriterion("ext4_time not in", values, "ext4Time");
			return (Criteria) this;
		}

		public Criteria andExt4TimeBetween(Date value1, Date value2) {
			addCriterion("ext4_time between", value1, value2, "ext4Time");
			return (Criteria) this;
		}

		public Criteria andExt4TimeNotBetween(Date value1, Date value2) {
			addCriterion("ext4_time not between", value1, value2, "ext4Time");
			return (Criteria) this;
		}

		public Criteria andExt5TimeIsNull() {
			addCriterion("ext5_time is null");
			return (Criteria) this;
		}

		public Criteria andExt5TimeIsNotNull() {
			addCriterion("ext5_time is not null");
			return (Criteria) this;
		}

		public Criteria andExt5TimeEqualTo(Date value) {
			addCriterion("ext5_time =", value, "ext5Time");
			return (Criteria) this;
		}

		public Criteria andExt5TimeNotEqualTo(Date value) {
			addCriterion("ext5_time <>", value, "ext5Time");
			return (Criteria) this;
		}

		public Criteria andExt5TimeGreaterThan(Date value) {
			addCriterion("ext5_time >", value, "ext5Time");
			return (Criteria) this;
		}

		public Criteria andExt5TimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ext5_time >=", value, "ext5Time");
			return (Criteria) this;
		}

		public Criteria andExt5TimeLessThan(Date value) {
			addCriterion("ext5_time <", value, "ext5Time");
			return (Criteria) this;
		}

		public Criteria andExt5TimeLessThanOrEqualTo(Date value) {
			addCriterion("ext5_time <=", value, "ext5Time");
			return (Criteria) this;
		}

		public Criteria andExt5TimeIn(List<Date> values) {
			addCriterion("ext5_time in", values, "ext5Time");
			return (Criteria) this;
		}

		public Criteria andExt5TimeNotIn(List<Date> values) {
			addCriterion("ext5_time not in", values, "ext5Time");
			return (Criteria) this;
		}

		public Criteria andExt5TimeBetween(Date value1, Date value2) {
			addCriterion("ext5_time between", value1, value2, "ext5Time");
			return (Criteria) this;
		}

		public Criteria andExt5TimeNotBetween(Date value1, Date value2) {
			addCriterion("ext5_time not between", value1, value2, "ext5Time");
			return (Criteria) this;
		}

		public Criteria andOrderStatusIsNull() {
			addCriterion("order_status is null");
			return (Criteria) this;
		}

		public Criteria andOrderStatusIsNotNull() {
			addCriterion("order_status is not null");
			return (Criteria) this;
		}

		public Criteria andOrderStatusEqualTo(Integer value) {
			addCriterion("order_status =", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotEqualTo(Integer value) {
			addCriterion("order_status <>", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusGreaterThan(Integer value) {
			addCriterion("order_status >", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_status >=", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusLessThan(Integer value) {
			addCriterion("order_status <", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusLessThanOrEqualTo(Integer value) {
			addCriterion("order_status <=", value, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusIn(List<Integer> values) {
			addCriterion("order_status in", values, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotIn(List<Integer> values) {
			addCriterion("order_status not in", values, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusBetween(Integer value1, Integer value2) {
			addCriterion("order_status between", value1, value2, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andOrderStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("order_status not between", value1, value2, "orderStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusIsNull() {
			addCriterion("business_status is null");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusIsNotNull() {
			addCriterion("business_status is not null");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusEqualTo(Integer value) {
			addCriterion("business_status =", value, "businessStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusNotEqualTo(Integer value) {
			addCriterion("business_status <>", value, "businessStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusGreaterThan(Integer value) {
			addCriterion("business_status >", value, "businessStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("business_status >=", value, "businessStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusLessThan(Integer value) {
			addCriterion("business_status <", value, "businessStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusLessThanOrEqualTo(Integer value) {
			addCriterion("business_status <=", value, "businessStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusIn(List<Integer> values) {
			addCriterion("business_status in", values, "businessStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusNotIn(List<Integer> values) {
			addCriterion("business_status not in", values, "businessStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusBetween(Integer value1, Integer value2) {
			addCriterion("business_status between", value1, value2, "businessStatus");
			return (Criteria) this;
		}

		public Criteria andBusinessStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("business_status not between", value1, value2, "businessStatus");
			return (Criteria) this;
		}

		public Criteria andHoldStatusIsNull() {
			addCriterion("hold_status is null");
			return (Criteria) this;
		}

		public Criteria andHoldStatusIsNotNull() {
			addCriterion("hold_status is not null");
			return (Criteria) this;
		}

		public Criteria andHoldStatusEqualTo(Integer value) {
			addCriterion("hold_status =", value, "holdStatus");
			return (Criteria) this;
		}

		public Criteria andHoldStatusNotEqualTo(Integer value) {
			addCriterion("hold_status <>", value, "holdStatus");
			return (Criteria) this;
		}

		public Criteria andHoldStatusGreaterThan(Integer value) {
			addCriterion("hold_status >", value, "holdStatus");
			return (Criteria) this;
		}

		public Criteria andHoldStatusGreaterThanOrEqualTo(Integer value) {
			addCriterion("hold_status >=", value, "holdStatus");
			return (Criteria) this;
		}

		public Criteria andHoldStatusLessThan(Integer value) {
			addCriterion("hold_status <", value, "holdStatus");
			return (Criteria) this;
		}

		public Criteria andHoldStatusLessThanOrEqualTo(Integer value) {
			addCriterion("hold_status <=", value, "holdStatus");
			return (Criteria) this;
		}

		public Criteria andHoldStatusIn(List<Integer> values) {
			addCriterion("hold_status in", values, "holdStatus");
			return (Criteria) this;
		}

		public Criteria andHoldStatusNotIn(List<Integer> values) {
			addCriterion("hold_status not in", values, "holdStatus");
			return (Criteria) this;
		}

		public Criteria andHoldStatusBetween(Integer value1, Integer value2) {
			addCriterion("hold_status between", value1, value2, "holdStatus");
			return (Criteria) this;
		}

		public Criteria andHoldStatusNotBetween(Integer value1, Integer value2) {
			addCriterion("hold_status not between", value1, value2, "holdStatus");
			return (Criteria) this;
		}

		public Criteria andChannelIsNull() {
			addCriterion("channel is null");
			return (Criteria) this;
		}

		public Criteria andChannelIsNotNull() {
			addCriterion("channel is not null");
			return (Criteria) this;
		}

		public Criteria andChannelEqualTo(Integer value) {
			addCriterion("channel =", value, "channel");
			return (Criteria) this;
		}

		public Criteria andChannelNotEqualTo(Integer value) {
			addCriterion("channel <>", value, "channel");
			return (Criteria) this;
		}

		public Criteria andChannelGreaterThan(Integer value) {
			addCriterion("channel >", value, "channel");
			return (Criteria) this;
		}

		public Criteria andChannelGreaterThanOrEqualTo(Integer value) {
			addCriterion("channel >=", value, "channel");
			return (Criteria) this;
		}

		public Criteria andChannelLessThan(Integer value) {
			addCriterion("channel <", value, "channel");
			return (Criteria) this;
		}

		public Criteria andChannelLessThanOrEqualTo(Integer value) {
			addCriterion("channel <=", value, "channel");
			return (Criteria) this;
		}

		public Criteria andChannelIn(List<Integer> values) {
			addCriterion("channel in", values, "channel");
			return (Criteria) this;
		}

		public Criteria andChannelNotIn(List<Integer> values) {
			addCriterion("channel not in", values, "channel");
			return (Criteria) this;
		}

		public Criteria andChannelBetween(Integer value1, Integer value2) {
			addCriterion("channel between", value1, value2, "channel");
			return (Criteria) this;
		}

		public Criteria andChannelNotBetween(Integer value1, Integer value2) {
			addCriterion("channel not between", value1, value2, "channel");
			return (Criteria) this;
		}

		public Criteria andOrderTypeIsNull() {
			addCriterion("order_type is null");
			return (Criteria) this;
		}

		public Criteria andOrderTypeIsNotNull() {
			addCriterion("order_type is not null");
			return (Criteria) this;
		}

		public Criteria andOrderTypeEqualTo(Integer value) {
			addCriterion("order_type =", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotEqualTo(Integer value) {
			addCriterion("order_type <>", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeGreaterThan(Integer value) {
			addCriterion("order_type >", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("order_type >=", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeLessThan(Integer value) {
			addCriterion("order_type <", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeLessThanOrEqualTo(Integer value) {
			addCriterion("order_type <=", value, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeIn(List<Integer> values) {
			addCriterion("order_type in", values, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotIn(List<Integer> values) {
			addCriterion("order_type not in", values, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeBetween(Integer value1, Integer value2) {
			addCriterion("order_type between", value1, value2, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("order_type not between", value1, value2, "orderType");
			return (Criteria) this;
		}

		public Criteria andOrderPidIsNull() {
			addCriterion("order_pid is null");
			return (Criteria) this;
		}

		public Criteria andOrderPidIsNotNull() {
			addCriterion("order_pid is not null");
			return (Criteria) this;
		}

		public Criteria andOrderPidEqualTo(String value) {
			addCriterion("order_pid =", value, "orderPid");
			return (Criteria) this;
		}

		public Criteria andOrderPidNotEqualTo(String value) {
			addCriterion("order_pid <>", value, "orderPid");
			return (Criteria) this;
		}

		public Criteria andOrderPidGreaterThan(String value) {
			addCriterion("order_pid >", value, "orderPid");
			return (Criteria) this;
		}

		public Criteria andOrderPidGreaterThanOrEqualTo(String value) {
			addCriterion("order_pid >=", value, "orderPid");
			return (Criteria) this;
		}

		public Criteria andOrderPidLessThan(String value) {
			addCriterion("order_pid <", value, "orderPid");
			return (Criteria) this;
		}

		public Criteria andOrderPidLessThanOrEqualTo(String value) {
			addCriterion("order_pid <=", value, "orderPid");
			return (Criteria) this;
		}

		public Criteria andOrderPidLike(String value) {
			addCriterion("order_pid like", value, "orderPid");
			return (Criteria) this;
		}

		public Criteria andOrderPidNotLike(String value) {
			addCriterion("order_pid not like", value, "orderPid");
			return (Criteria) this;
		}

		public Criteria andOrderPidIn(List<String> values) {
			addCriterion("order_pid in", values, "orderPid");
			return (Criteria) this;
		}

		public Criteria andOrderPidNotIn(List<String> values) {
			addCriterion("order_pid not in", values, "orderPid");
			return (Criteria) this;
		}

		public Criteria andOrderPidBetween(String value1, String value2) {
			addCriterion("order_pid between", value1, value2, "orderPid");
			return (Criteria) this;
		}

		public Criteria andOrderPidNotBetween(String value1, String value2) {
			addCriterion("order_pid not between", value1, value2, "orderPid");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNull() {
			addCriterion("is_del is null");
			return (Criteria) this;
		}

		public Criteria andIsDelIsNotNull() {
			addCriterion("is_del is not null");
			return (Criteria) this;
		}

		public Criteria andIsDelEqualTo(Integer value) {
			addCriterion("is_del =", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotEqualTo(Integer value) {
			addCriterion("is_del <>", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThan(Integer value) {
			addCriterion("is_del >", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_del >=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThan(Integer value) {
			addCriterion("is_del <", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelLessThanOrEqualTo(Integer value) {
			addCriterion("is_del <=", value, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelIn(List<Integer> values) {
			addCriterion("is_del in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotIn(List<Integer> values) {
			addCriterion("is_del not in", values, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelBetween(Integer value1, Integer value2) {
			addCriterion("is_del between", value1, value2, "isDel");
			return (Criteria) this;
		}

		public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
			addCriterion("is_del not between", value1, value2, "isDel");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public static class Criterion {
		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
}