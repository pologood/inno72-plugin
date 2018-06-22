package com.framelib.dubbo.neworder.model;

import java.util.ArrayList;
import java.util.List;

public class ContractsLog {

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
    /** 类型
     * 201 备注 202 班次 203 到达时间 204 合约单号 205 宝宝姓名 206 预约地址
     */
    private String type;
    
    public enum CONTRACTS_LOG_TYPE_ENUM{
    	
    	WAIT_FOR_APPOINT("100","待排班"),
    	WAIT_FOR_ALLO("101","待排班 -> 待履约"),
    	WAIT_FOR_INCAR("102","待履约 -> 待用户上车"),
    	START_ACTION("103","待用户上车 -> 开始履约"),
    	FINISH_ACTION("104","开始履约 -> 履约完成"),
    	WAIT_FOR_UNREAD("105","履约完成 -> 待解读"),
    	FINISH("106","待解读 -> 已完成"),
    	CANCEL_FOR_ALLO("107","取消车辆预约 -> 待履约"),
    	CANCEL("108","取消合约"),
    	
    	FIELD_REAMRK("301","备注"),
		FIELD_CLASSES("302","班次"),
		FIELD_START_TIME("303","到达时间"),
		FIELD_ORDER_NUM("304","合约单号"),
		FIELD_BABY_NAME("305","宝宝姓名"),
		FIELD_ADDRESS("306","预约地址"),
    	;
    	
    	private String type;
    	private String desc;
    	
    	public static List<String> getTypes(String startWith){
    		
    		CONTRACTS_LOG_TYPE_ENUM[] values = CONTRACTS_LOG_TYPE_ENUM.values();
    		
    		 List<String> types = new ArrayList<>();
    		
    		for (CONTRACTS_LOG_TYPE_ENUM contracts_LOG_TYPE : values) {
				if (contracts_LOG_TYPE.getType().startsWith(startWith)) {
					types.add(contracts_LOG_TYPE.getType());
				}
				if (!startWith.equals("1") && contracts_LOG_TYPE.getType().startsWith("3")) {
					types.add(contracts_LOG_TYPE.getType());
				}
			}
    		
    		return types;
    	}
    	
		private CONTRACTS_LOG_TYPE_ENUM(String type, String desc) {
			this.type = type;
			this.desc = desc;
		}
		
		public String getType() {
			return type;
		}
		
		public void setType(String type) {
			this.type = type;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
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
