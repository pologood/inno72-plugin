package com.framelib.dubbo.order.service;

import java.math.BigDecimal;
import java.util.List;

import com.framelib.common.Result;
import com.framelib.dubbo.model.Orders;
import com.framelib.dubbo.model.Orders.NewBorn_Order_Status;
import com.framelib.dubbo.model.Orders.Pay_Type;
import com.framelib.dubbo.vo.PkgGoodsVo;

public interface INewBornOrderService {

	/**
	 * 下单
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年4月27日下午12:22:19
	 * @param doctorId
	 * @param doctorName
	 * @param goodsPrice
	 * @param performerId
	 * @param performerName
	 * @param userId
	 * @param goodsInfos
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	Result<Orders> saveNewBornOrderOrder(String doctorId, String doctorName, BigDecimal goodsPrice,
			BigDecimal orderPrice, String performerId, String performerName, String userId,
			List<PkgGoodsVo> goodsInfos);

	/**
	 * 支付
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年4月27日下午12:20:19
	 * @param id
	 * @param xml
	 * @param payType
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	public Result<String> pay(String id, String xml, Pay_Type payType);
	
	
	/**
	 * 激活
	 * @param id 订单id
	 * @param status 状态枚举
	 * @return
	 */
	public Result<String> updateStatus(String id,NewBorn_Order_Status status,String optionPeople,String optionID,String remark);
}
