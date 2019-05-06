package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/6 15:04
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 通过买家openid 分页查询
     * @param openId
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String openId, Pageable pageable);
}
