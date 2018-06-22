package com.framelib.dubbo.order.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

import com.framelib.common.Result;
import com.framelib.dubbo.model.Orders;
import com.framelib.dubbo.model.Orders.Order_Type;
import com.framelib.dubbo.model.Orders.Pay_Type;
import com.framelib.dubbo.model.OrdersFile;

public interface IFamilyOrderService {

	/**
	 * 家庭医生下单
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年5月24日下午3:01:32
	 * @param telNo
	 * @param userId
	 * @param performerId
	 * @param performerName
	 * @param doctorId
	 * @param doctorName
	 * @param price
	 * @param orderSource
	 * @param goodInfos
	 * @param files
	 * @param orderType
	 * @param appTime
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	public Result<Orders> orderFamilyDoctor(String telNo, String userId, String performerId, String performerName,
			String doctorId, String doctorName, BigDecimal payPrice, Orders.Order_Source orderSource,
			Map<String, Object> goodInfos, Map<String, OrdersFile.File_Type> files, Order_Type orderType,
			LocalDateTime appTime, BigDecimal orderPrice);

	/**
	 * 接诊
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年5月24日下午3:07:43
	 * @param orderId
	 * @param receiveTime
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	public Result<String> receive(String orderId, LocalDateTime receiveTime);

	/**
	 * 通话
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年5月24日下午3:07:51
	 * @param orderId
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	public Result<String> call(String orderId);

	/**
	 * 填写诊断
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年5月24日下午3:07:57
	 * @param orderId
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	public Result<String> saveDiagnose(String orderId);

	/**
	 * 支付
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年5月24日下午3:08:21
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
	 * 备注
	 * 
	 * @Create_time:2017年6月29日下午2:18:23
	 * @Create_by:lzh
	 * @param orderId
	 * @param remark
	 * @return
	 */
	public Result<String> remark(String orderId, String remark, String creator);

	/**
	 * 取消订单
	 * 
	 * @Create_time:2017年7月4日上午11:34:40
	 * @Create_by:lzh
	 * @param orderId
	 * @param remark
	 * @param creator
	 * @return
	 */
	public Result<String> cancle(String orderId, String creator);

}
