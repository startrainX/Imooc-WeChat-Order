package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/5 16:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() {

        ProductInfo result = productInfoService.findOne("123456");

        Assert.assertEquals("123456", result.getProductId());
    }

    @Test
    public void findUpAll() {

        List<ProductInfo> list = productInfoService.findUpAll();

        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findAll() {

        PageRequest pageRequest = new PageRequest(0,2);

        Page<ProductInfo> productInfoPage = productInfoService.findAll(pageRequest);
        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0, productInfoPage.getTotalElements());
    }

    @Test
    public void save() {

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("豆浆");
        productInfo.setProductPrice(new BigDecimal(2.5));
        productInfo.setProductDescription("又香又甜");
        productInfo.setProductStock(99);
        productInfo.setProductIcon("http://jjjj.jpg");
        productInfo.setProductStatus(ProductStatusEnum.Up.getCode());
        productInfo.setCategoryType(5);

        ProductInfo result = productInfoService.save(productInfo);

        Assert.assertNotNull(result);
    }
}