package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/5 11:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryServiceImplTest {

    @Autowired
    private ProductCategoryServiceImpl productCategoryService;

    @Test
    public void findOne() {
        ProductCategory productCategory = productCategoryService.findOne(1);
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void findAll() {
        List<ProductCategory> result = productCategoryService.findAll();
        Assert.assertNotEquals(0,result);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> result = productCategoryService.findByCategoryTypeIn(Arrays.asList(1,2,3));
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("经典",5);
        ProductCategory category = productCategoryService.save(productCategory);
        Assert.assertNotNull(category);
    }
}