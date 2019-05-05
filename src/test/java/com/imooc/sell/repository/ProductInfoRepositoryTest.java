package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/5 15:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("油条");
        productInfo.setProductPrice(new BigDecimal(1.5));
        productInfo.setProductDescription("又香又脆");
        productInfo.setProductStock(99);
        productInfo.setProductIcon("http://jjjj.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(5);

        ProductInfo result = repository.save(productInfo);
        Assert.assertNotNull(result);

    }

    @Test
    public void findByProductStatus() {

        List<ProductInfo> list = repository.findByProductStatus(0);
        Assert.assertNotEquals(0, list.size());
    }
}