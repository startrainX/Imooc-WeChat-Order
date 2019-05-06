package com.imooc.sell.dto;

import lombok.Data;

/**
 * 购物车
 * @author ：zsp
 * @date ：Created in 2019/5/6 17:37
 */
@Data
public class CartDTO {

    /**商品id. */
    private String id;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String id, Integer productQuantity) {
        this.id = id;
        this.productQuantity = productQuantity;
    }
}
