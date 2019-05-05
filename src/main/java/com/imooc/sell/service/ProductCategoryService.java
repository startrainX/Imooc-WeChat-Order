package com.imooc.sell.service;

import com.imooc.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * 类目
 * @author ：zsp
 * @date ：Created in 2019/5/5 11:28
 */
public interface ProductCategoryService {

    /**
     * 查询单个
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 查询所有类目
     * @param categoryType
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);

    /**
     * 新增和更新
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
