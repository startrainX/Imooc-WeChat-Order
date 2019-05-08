package com.imooc.sell.service;

import com.imooc.sell.dto.OrderDTO;

/**
 * 买家
 * @author ：zsp
 * @date ：Created in 2019/5/8 15:54
 */
public interface BuyerService {
    /**
     * 查询订单
     */
    OrderDTO findOrderOne(String openId, String orderId);

    /**
     * 取消订单
     */
    OrderDTO cancelOrder(String openId, String orderId);
}
