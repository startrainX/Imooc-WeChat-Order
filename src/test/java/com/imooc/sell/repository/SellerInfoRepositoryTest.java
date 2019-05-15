package com.imooc.sell.repository;

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
 * @date ：Created in 2019/5/15 11:37
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId("123");
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("password");
        sellerInfo.setOpenid("abc");
        SellerInfo result = repository.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findSellerInfoByOpenid() {
        SellerInfo sellerInfo = repository.findByOpenid("abc");
        Assert.assertEquals("admin", sellerInfo.getUsername());
    }
}