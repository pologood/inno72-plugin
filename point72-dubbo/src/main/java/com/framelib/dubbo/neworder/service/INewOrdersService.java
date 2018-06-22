package com.framelib.dubbo.neworder.service;

import java.util.List;
import java.util.Map;

import com.framelib.common.Result;
import com.framelib.dubbo.neworder.vo.OrdersVo;

/**
 * 核心订单操作接口
 *
 * Created by zhouzengbao on 04/08/2017.
 */
public interface INewOrdersService {
	
	/**
	 * 保存儿保订单
	 * 
	 * @param orderVos
	 * @param creater
	 * @return
	 * @throws Exception
	 */
	public Result<List<OrdersVo>> saveOrders(List<OrdersVo> orderVos,String creater) throws Exception;
	
	/**
	 * 保存微信订单
	 * 
	 * @param orderVos
	 * @param creater
	 * @return
	 * @throws Exception
	 */
	public Result<List<OrdersVo>> saveWechatOrders(List<OrdersVo> orderVos,String creater) throws Exception;
	
	/**
	 * 保存门诊订单
	 * 
	 * @param orderVos
	 * @param creater
	 * @return
	 * @throws Exception
	 */
	public Result<List<OrdersVo>> saveOutpatientOrders(List<OrdersVo> orderVos,String creater) throws Exception;
	
	/**
	 * 保存车辆订单
	 * 
	 * @param orderVos
	 * @param creater
	 * @return
	 * @throws Exception
	 */
	public Result<OrdersVo> saveCarOrders(OrdersVo orderVos,String creater) throws Exception;

	/**
	 * 保存加项儿保订单
	 *
	 * @param orderVos
	 * @param creater
	 * @return
	 * @throws Exception
	 */
	public Result<List<OrdersVo>> saveAppendOrders(List<OrdersVo> orderVos,String creater) throws Exception;

	/**
	 * 保存康复卡订单
	 * @param orderVos
	 * @param creater
	 * @return
	 * @throws Exception
	 */
	public Result<OrdersVo> saveCardOrder(OrdersVo orderVos,String creater) throws Exception;

	/**
	 * 重置订单状态 为已约定 儿保。。。
	 * @param orderIds
	 * @param creater
	 */
    public void updateResetStatus(List<String> orderIds,String creater);
    
    /**
     * 一键生成儿保订单
     * 
     * @return
     */
    public Result<String> randomCreateOrders();
    
    /**
     * 直接修改订单状态
     * 
     * @param orderId
     * @param status
     * @return
     */
    public Result<String> updateStatus(String orderId, Integer status);
    
    /**
     * 支付订单
     * 
     * @param orderIds 
     * @param payResultXml 微信回调xml
     * @param statementId 账单id
     * @param creater
     * @return
     */
    public Result<String> updatePayStatus(List<String> orderIds,String payResultXml, String statementId ,String creater);
    
    /**
     * 更新订单为待履约状态
     * @param orderId
     * @param creater
     * @return
     */
    public Result<String> updateWaitActionStatus(String orderId,String creater);
    
    /**
     * 取消订单
     * 
     * @param orderIds
     * @param cancelLog
     * @param creater
     * @return
     */
    public Result<String> cancelOrder(List<String> orderIds ,String cancelLog, String creater);

    /**
     * 取消车费订单
     * 
     * @param orderIds
     * @param creater
     * @return
     */
	public Result<String> cancelCarPriceOrder(List<String> orderIds, String creater);
    
	
	public Result<String> updateStatusToAction(List<String> ordersIds,String creater) throws Exception;
	
	/**
	 * 修改为已完成状态
	 * 
	 * @param orderIds
	 * @param creater
	 * @return
	 * @throws Exception 
	 */
	public Result<String> finish(List<String> orderIds, String advice, String creater) throws Exception;
	
	/**
	 * 修改为待接诊状态
	 * 
	 * @param orderIds
	 * @param creater
	 * @return
	 */
	public Result<String> waitReception(List<String> orderIds, String creater) throws Exception;
	
	/**
	 * 医生确认接诊 修改为待回电状态
	 * 
	 * @param orderIds
	 * @param creater
	 * @return
	 */
	public Result<String> affirmReception(List<String> orderIds, String creater) throws Exception;
	
	/**
	 * 医生回电，修改为待填写诊断
	 * 
	 * @param orderIds
	 * @param creater
	 * @return
	 */
	public Result<String> callBack(List<String> orderIds, String creater) throws Exception;
	
	/**
	 * 医生填写诊断并保存发送。修改为待审核状态
	 * 
	 * @param orderId
	 * @param doctorAdvice 诊断建议
	 * @param creater
	 * @return
	 */
	public Result<String> saveDoctorAdvice( String orderId,String doctorAdvice, String creater, Map<String, String> param) throws Exception;

	/**
	 * 门诊支付接口
	 * @param orderIds
	 * @param payResultXml
	 * @param statementId
	 * @param creater
	 * @return
	 */
	Result<String> outpatientPay(List<String> orderIds, String payResultXml, String statementId, String creater);

	public Result<String> offlinePay(List<String> orderIds, String creater);
    
}
