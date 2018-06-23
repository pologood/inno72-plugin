package com.framelib.dubbo.neworder.service;

import java.util.List;

import com.framelib.common.Result;
import com.framelib.dubbo.neworder.exception.PlaceOrderException;
import com.framelib.dubbo.neworder.vo.OrdersVo;

/**
 *
 * 新订单下单接口
 * 支持，重构后所有订单商品一对一接口类型下单.
 *
 * Created by zhouzengbao on 28/11/2017.
 *
 * method:
 * placeOrders： 批量下单接口
 *  param  : ordersVos 订单vo集合，请务在vo中必携带下单类型.如未携带类型。直接返回错误
 *  return : 原param: ordersVos操作后的结果。包含重要订单id num和状态等。
 *
 * placeOrder 单个下单接口
 *
 */
public interface IPlaceOrderService {

    /**
     * 批量下单接口
     *
     * @param ordersVos 参数vos
     *
     * @return 操作后的vos
     *
     * @throws Exception 异常，请打印异常详情。
     */
    public Result<List<OrdersVo>> placeOrder(List<OrdersVo> ordersVos) throws PlaceOrderException;

    /**
     * 单个下单接口
     *
     * @param ordersVo 参数vo
     *
     * @return 操作后的vo
     * @throws PlaceOrderException 
     *
     * @throws Exception 异常，请打印异常详情。
     */
    public Result<OrdersVo> placeOrder(OrdersVo ordersVo) throws PlaceOrderException;

}
