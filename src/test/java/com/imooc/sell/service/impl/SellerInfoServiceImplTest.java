package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.SellerInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/15 11:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoServiceImplTest {

    @Autowired
    private SellerInfoServiceImpl sellerInfoService;

    @Test
    public void findSellerInfoByOpenid() {
        SellerInfo result = sellerInfoService.findSellerInfoByOpenid("abc");
        Assert.assertEquals("password", result.getPassword());
    }
}