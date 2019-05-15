package com.imooc.sell.service;

import com.imooc.sell.dataobject.SellerInfo;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/15 11:41
 */
public interface SellerInfoService {

    /**
     * 通过openid查询
     * @param openid
     * @return
     */
    SellerInfo findSellerInfoByOpenid(String openid);

    /**
     * 保存用户
     * @param sellerInfo
     * @return
     */
    SellerInfo saveSellerInfo(SellerInfo sellerInfo);
}
