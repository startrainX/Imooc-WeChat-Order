package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/5 10:32
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    /**
     * 获取所有类目类型
     * @param categoryType
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
