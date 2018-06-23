package com.framelib.dubbo.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.framelib.common.Result;
import com.framelib.dubbo.model.Orders;
import com.framelib.dubbo.model.Orders.Pay_Type;

public interface BaseOrderService {

	static Logger logger = LoggerFactory.getLogger(BaseOrderService.class);

	/**
	 * 
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	// default Result<Orders> loadById(String id) {
	// return Results.success(this.getRepository().findById(id));
	// }

	/**
	 * 
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<Orders> loadByOrderNum(String orderNum);

	/**
	 * 根据医生ID获取订单
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<Object> loadOrdersByDoctor(String doctorId, String startTime, String endTime, Integer pageNo,
			Integer pageSize);

	/**
	 * 付款
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<String> pay(String id, String xml, Pay_Type payType, String creator, String info);

}
