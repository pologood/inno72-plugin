package com.framelib.dubbo.order.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.framelib.common.Result;
import com.framelib.dubbo.model.Orders;
import com.framelib.dubbo.model.Orders.FAST_Business_Status;
import com.framelib.dubbo.model.Orders.Fast_Order_Status;
import com.framelib.dubbo.model.Orders.Hold_Status;
import com.framelib.dubbo.model.Orders.Order_Source;
import com.framelib.dubbo.model.Orders.Order_Type;
import com.framelib.dubbo.model.Orders.Pay_Type;
import com.framelib.dubbo.model.OrdersFile;

/**
 * 订单Service Title: Description:
 * 
 * @Create_by: Houkemian
 * @Create_date: 2016年11月15日
 * @Last_Edit_By: Edit_description:
 * @version: PMP
 */
public interface IOrderService {

	/**
	 * 下单速诊
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param {@link
	 * 			Order_Type}
	 * @param {@link
	 * 			Pay_Type}
	 * @param {@link
	 * 			Order_Source}
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<Orders> orderFast(String telNo, String userId, String performerId, String performerName,
			String doctorId, String doctorName, BigDecimal goodsPrice, BigDecimal orderPrice, BigDecimal discountPrice,
			Orders.Order_Source orderSource, Map<String, Object> goodInfos, String creator, String info,
			Map<String, OrdersFile.File_Type> files);

	/**
	 * 速诊追问三次后付费追问
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param orderId,速诊订单ID
	 * @param {@link
	 * 			Order_Type}
	 * @param {@link
	 * 			Pay_Type}
	 * @param {@link
	 * 			Order_Source}
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<Orders> orderFastAppend(String orderId, BigDecimal goodsPrice, BigDecimal orderPrice,
			BigDecimal discountPrice, Order_Source orderSource, String desp, String creator, String info,
			Map<String, OrdersFile.File_Type> files);

	/**
	 * 根据医生ID获取挂起或者改派的订单
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<Object> loadHoldOrTransferOrdersByDoctor(String doctorId);

	/**
	 * 根据二级状态获取订单
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param businessStatus
	 * @return
	 */
	public Result<Object> loadByStatus(String startTime, String endTime, Integer pageNo, Integer pageSize,
			String doctorId, FAST_Business_Status... businessStatus);

	/**
	 * 根据订单类型获取订单
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param businessStatus
	 * @return
	 */
	public Result<Object> loadByOrderType(Integer pageNo, Integer pageSize, String startTime, String endTime,
			Order_Type orderType);

	/**
	 * 获取所有订单
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param businessStatus
	 * @return
	 */
	public Result<Object> loadAll(Integer pageNo, Integer pageSize, String startTime, String endTime);

	/**
	 * 根据订单号和状态查询订单
	 * 
	 * @Create_by:lizh
	 * @Create_date:2016年11月22日下午4:17:54
	 * @param pageNo
	 * @param pageSize
	 * @param startTime
	 * @param endTime
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	public Result<Object> loadByStatusAndOrderNumAndOrderType(Integer pageNo, Integer pageSize, String startTime,
			String endTime, Order_Type orderType, String orderNum, Orders.Fast_Order_Status orderStatus);

	/**
	 * 根据参数查询订单详情，包括订单、订单商品、订单附件
	 * 
	 * @Create_by:lizh
	 * @Create_date:2016年11月22日下午4:17:54
	 * @param pageNo
	 * @param pageSize
	 * @param startTime
	 * @param endTime
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	public Result<List<Orders>> loadFullOrderByParam(String id, Fast_Order_Status orderStatus, String doctorId,
			String orderNum, String performerId, String userId, String userTelno, Pay_Type payType, Order_Source source,
			Hold_Status holdStatus, String pid);

	/**
	 * 接诊
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<String> receive(String id, String creator, String info);

	/**
	 * 待付款
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<String> waitToPay(String id, String creator, String info);

	/**
	 * 通话
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<String> call(String id, String creator, String info);

	/**
	 * 转发医助
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<String> toAssistant(String id, String creator, String info);

	/**
	 * 医助录入完成
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<String> assistantFinish(String id, String creator, String info);

	/**
	 * 挂起
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<String> hold(String id, String creator, String info);

	/**
	 * 取消挂起
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<String> unhold(String id, String creator, String info);

	/**
	 * 医生审核
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<String> review(String id, String creator, String info);

	/**
	 * 改派
	 * 
	 * @Create_by: Houkemian
	 * @Create_date:2016年11月15日
	 * @param
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:PMP
	 */
	public Result<Orders> transfer(String id, String doctorId, String doctorName, String creator, String info);

	/**
	 * 查询医生改派次数
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年1月11日下午3:45:29
	 * @param startTime
	 * @param endTime
	 * @param doctorId
	 * @param businessStatus
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	public Result<Long> queryTransferOrderCount(String startTime, String endTime, String doctorId,
			FAST_Business_Status businessStatus);

	/******
	 * ABS ?
	 * 
	 * 
	 * /**
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

	public Result<Orders> loadById(String id);
}
