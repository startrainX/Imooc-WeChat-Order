package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/5 10:33
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void save(){
        ProductCategory productCategory = repository.findOne(1);
//        ProductCategory result = new ProductCategory("热销",3);
        productCategory.setCategoryName("优惠");
//        productCategory.setCategoryType(2);
//        repository.save(result);
        repository.save(productCategory);
    }

    @Test
    public void findOne(){
        ProductCategory productCategory = repository.findOne(1);
        System.out.println(productCategory);
    }

    @Test
    public void findByCategoryTypeIn(){
        List<Integer> list = Arrays.asList(2,3,4);

        List<ProductCategory> result = repository.findByCategoryTypeIn(list);

        Assert.assertNotEquals(0, result.size());
    }

}