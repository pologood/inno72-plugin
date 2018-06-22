package com.framelib.dubbo.neworder.model;

import java.util.ArrayList;
import java.util.List;

public class NewOrdersLog {
	/**
	 * 订单id
	 */
	private String orderId;
	/** 创建时间 */
	private String createTime;

	/** 字段名称 */
	private String fieldName;
	/** 修改描述 */
	private String editDetail;
	/** 创建人 */
	private String created;
	/** 
	 * 类型 {@link NEW_ORDERS_LOG_TYPE_ENUM}
	 */
	private String type;
	
	public enum NEW_ORDERS_LOG_TYPE_ENUM{
		PLACE_ORDER("100","下单"),
		BOOK("101","已预订"),
		WAIT_FOR_ACTION("102","待履约"),
		WAIT_FOR_PAY("103","待支付"),
		FINISH("104","已支付"),
		CANCEL("105","已取消"),
		CLINICAL_RECEPTION("106","待接诊"),
		WAIT_CALL_BACK("107","待回电"),
		DIAGNOSE("108","已填写诊断"),
		WAIT_AUDIT("109","待审核"),
		COMPLETE("110","已完成"),
		WAIT_DIAGNOSE("111","待填写诊断"),
		PAY("112","已支付"),
		WAIT_RECEPTION("113","待接诊"),

		WAIT_FOR_ALLO("201","待分配解读医生"),
		FINISH_ALLO("202","已分配解读医生"),

		FIELD_REAMRK("301","备注"),
		FIELD_CLASSES("302","班次"),
		FIELD_START_TIME("303","到达时间"),
		FIELD_ORDER_NUM("304","合约单号"),
		FIELD_BABY_NAME("305","宝宝姓名"),
		FIELD_UNSCRAMBLE_REPORT("306","生成解读报告"),
		FIELD_UNSCRAMBLE_DOCTOR("307","解读医生"),
		FIELD_SHEET("308","检验单"),
		FIELD_UNSCRAMBLE_ORDER("309","生成解读订单"),

		FIELD_PRODUCT("310","修改productNum"),
		;
		private String key;
		private String v;
		
		public static List<String> getTypes(String startWith){
    		
			NEW_ORDERS_LOG_TYPE_ENUM[] values = NEW_ORDERS_LOG_TYPE_ENUM.values();
    		
    		 List<String> types = new ArrayList<>();
    		
    		for (NEW_ORDERS_LOG_TYPE_ENUM contracts_LOG_TYPE : values) {
				if (contracts_LOG_TYPE.getKey().startsWith(startWith)) {
					types.add(contracts_LOG_TYPE.getKey());
				}
			}
    		
    		return types;
    	}
		
		private NEW_ORDERS_LOG_TYPE_ENUM(String key, String v) {
			this.key = key;
			this.v = v;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getV() {
			return v;
		}

		public void setV(String v) {
			this.v = v;
		}
		
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getEditDetail() {
		return editDetail;
	}

	public void setEditDetail(String editDetail) {
		this.editDetail = editDetail;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
