package com.imooc.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/14 16:52
 */
@Data
public class ProductForm {

    /** 商品id. */
    private String productId;

    /** 商品名称 */
    private String productName;

    /** 商品单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 类目编号 */
    private Integer categoryType;
}
