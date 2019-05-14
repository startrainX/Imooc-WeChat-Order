package com.imooc.sell.form;

import lombok.Data;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/14 17:52
 */
@Data
public class CategoryForm {

    private Integer categoryId;

    /** 类目名称 */
    private String categoryName;

    /** 类目类型 */
    private Integer categoryType;
}
