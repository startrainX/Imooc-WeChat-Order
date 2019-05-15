package com.imooc.sell.repository;

import com.imooc.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 卖家端信息
 * @author ：zsp
 * @date ：Created in 2019/5/15 11:35
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    /**
     * 使用openid查询
     * @param openid
     * @return
     */
    SellerInfo findByOpenid(String openid);
}
