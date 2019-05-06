package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/6 15:08
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 通过orderId 查询订单详情
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
