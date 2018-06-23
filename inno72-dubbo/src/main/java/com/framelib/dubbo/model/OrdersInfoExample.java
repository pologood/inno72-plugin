package com.framelib.dubbo.model;

import java.util.ArrayList;
import java.util.List;

public class OrdersInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
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

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(Integer value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(Integer value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(Integer value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(Integer value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(Integer value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<Integer> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<Integer> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(Integer value1, Integer value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIsNull() {
            addCriterion("goods_desc is null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIsNotNull() {
            addCriterion("goods_desc is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsDescEqualTo(String value) {
            addCriterion("goods_desc =", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotEqualTo(String value) {
            addCriterion("goods_desc <>", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescGreaterThan(String value) {
            addCriterion("goods_desc >", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescGreaterThanOrEqualTo(String value) {
            addCriterion("goods_desc >=", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLessThan(String value) {
            addCriterion("goods_desc <", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLessThanOrEqualTo(String value) {
            addCriterion("goods_desc <=", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescLike(String value) {
            addCriterion("goods_desc like", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotLike(String value) {
            addCriterion("goods_desc not like", value, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescIn(List<String> values) {
            addCriterion("goods_desc in", values, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotIn(List<String> values) {
            addCriterion("goods_desc not in", values, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescBetween(String value1, String value2) {
            addCriterion("goods_desc between", value1, value2, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andGoodsDescNotBetween(String value1, String value2) {
            addCriterion("goods_desc not between", value1, value2, "goodsDesc");
            return (Criteria) this;
        }

        public Criteria andInfoIsNull() {
            addCriterion("info is null");
            return (Criteria) this;
        }

        public Criteria andInfoIsNotNull() {
            addCriterion("info is not null");
            return (Criteria) this;
        }

        public Criteria andInfoEqualTo(String value) {
            addCriterion("info =", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotEqualTo(String value) {
            addCriterion("info <>", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThan(String value) {
            addCriterion("info >", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoGreaterThanOrEqualTo(String value) {
            addCriterion("info >=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThan(String value) {
            addCriterion("info <", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLessThanOrEqualTo(String value) {
            addCriterion("info <=", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoLike(String value) {
            addCriterion("info like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotLike(String value) {
            addCriterion("info not like", value, "info");
            return (Criteria) this;
        }

        public Criteria andInfoIn(List<String> values) {
            addCriterion("info in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotIn(List<String> values) {
            addCriterion("info not in", values, "info");
            return (Criteria) this;
        }

        public Criteria andInfoBetween(String value1, String value2) {
            addCriterion("info between", value1, value2, "info");
            return (Criteria) this;
        }

        public Criteria andInfoNotBetween(String value1, String value2) {
            addCriterion("info not between", value1, value2, "info");
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