package com.framelib.dubbo.order.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.framelib.common.Result;
import com.framelib.dubbo.model.Orders;
import com.framelib.dubbo.model.Orders.Pay_Type;
import com.framelib.dubbo.vo.PkgOrderVo;

/**
 * 新儿保订单
 * 
 * @author gavin
 *
 */
public interface IPkgOrderService {
	/**
	 * 生成合约单
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年3月2日上午10:29:09
	 * @param vo
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	Result<Orders> savePkgOrder(PkgOrderVo vo);

	/**
	 * 取消订单
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年3月2日下午3:30:40
	 * @param orderId
	 * @param creator
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	Result<String> cancle(String orderId, String creator);

	/**
	 * 开始检查
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年3月2日下午3:38:02
	 * @param orderId
	 * @param creator
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	Result<String> beginService(String orderId, String creator);

	/**
	 * 完成履约
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年3月2日下午3:39:16
	 * @param orderId
	 * @param creator
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	Result<String> finishService(String orderId, String creator);

	/**
	 * 驳回
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年3月2日下午3:39:26
	 * @param orderId
	 * @param creator
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	Result<String> reject(String orderId, String creator);

	/**
	 * 发送医助
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年3月2日下午3:39:35
	 * @param orderId
	 * @param creator
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	Result<String> sendToAssistant(String orderId, String creator);

	/**
	 * 发送给专科医生
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年3月2日下午3:39:56
	 * @param orderId
	 * @param creator
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	Result<String> sendToDoctor(String orderId, String creator);

	/**
	 * 发送给全科医生
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年3月2日下午3:40:04
	 * @param orderId
	 * @param creator
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	Result<String> sendToSelfDoctor(String orderId, String creator);

	/**
	 * 全科医生解读完毕
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年3月2日下午5:30:59
	 * @param orderId
	 * @param creator
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	Result<String> selfDoctorEaxplanationFinish(String orderId, String creator);

	/**
	 * 全科医生完成解读
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年3月2日下午3:40:12
	 * @param orderId
	 * @param creator
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	Result<String> finsh(String orderId, String creator);

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
	public Result<String> pay(String id, String xml, Pay_Type payType);

	/**
	 * 变更订单
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年3月2日下午5:52:52
	 * @param id
	 * @param beginTime
	 * @param endTime
	 * @param address
	 * @param creator
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	public Result<String> change(String id, LocalDateTime beginTime, LocalDateTime endTime, String address,
			String creator);

	/**
	 * 更改价格
	 * 
	 * @Create_by:lizh
	 * @Create_date:2017年6月14日下午2:35:16
	 * @param id
	 * @param payPrice
	 * @param creator
	 * @return
	 * @Last_Edit_By:
	 * @Edit_Description:
	 * @Create_Version:framelib
	 */
	public Result<String> updatePayPrice(String id, BigDecimal discountPrice, String creator);

	/**
	 * 修改车费
	 * 
	 * @Create_time:2017年8月17日下午4:53:38
	 * @Create_by:lzh
	 * @param id
	 * @param discountPrice
	 * @param creator
	 * @return
	 */
	public Result<String> updateCarPrice(String id, BigDecimal discountPrice, String creator);

	/**
	 * 备注
	 * 
	 * @Create_time:2017年8月7日下午2:41:32
	 * @Create_by:lzh
	 * @param orderId
	 * @param remark
	 * @param creator
	 * @return
	 */
	public Result<String> remark(String orderId, String remark, String creator);
}
