package com.framelib.dubbo.neworder.model;

import java.io.Serializable;

public class ContractsOrdersLink implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5164808504767749092L;

	/***/
    private String id;

    /**合约单id*/
    private String contractOrderId;

    /**预约单id*/
    private String ordersId;

    /**
     * 1：正常
     * 0：生成合约但是已取消
     */
    private Integer status;

    /***/
    public String getId() {
        return id;
    }

    /***/
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**合约单id*/
    public String getContractOrderId() {
        return contractOrderId;
    }

    /**合约单id*/
    public void setContractOrderId(String contractOrderId) {
        this.contractOrderId = contractOrderId == null ? null : contractOrderId.trim();
    }

    /**预约单id*/
    public String getOrdersId() {
        return ordersId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**预约单id*/
    public void setOrdersId(String ordersId) {

        this.ordersId = ordersId == null ? null : ordersId.trim();
    }
}