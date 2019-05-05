package com.imooc.sell.dataobject;



import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 类目表
 * @author ：zsp
 * @date ：Created in 2019/5/5 10:26
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    /** 类目id */
    @Id
    @GeneratedValue
    private Integer categoryId;
    /** 类目名称 */
    private String categoryName;
    /** 类目类型 */
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
