package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.repository.SellerInfoRepository;
import com.imooc.sell.service.SellerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/15 11:43
 */
@Service
public class SellerInfoServiceImpl implements SellerInfoService {

    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }

    @Override
    public SellerInfo saveSellerInfo(SellerInfo sellerInfo) {
        return repository.save(sellerInfo);
    }
}
