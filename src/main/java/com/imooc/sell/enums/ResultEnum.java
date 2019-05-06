package com.imooc.sell.enums;

import lombok.Getter;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/6 16:24
 */
@Getter
public enum ResultEnum {

    /**
     * 商品信息不存在
     */
    PRODUCT_NOT_EXIST(0, "商品不存在"),
    PRODUCT_STOCK_ERROR(-1, "库存不足")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
