package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 商品状态
 * @author ：zsp
 * @date ：Created in 2019/5/5 16:15
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{

    /**
     * 上架商品
     */
    Up(0,"上架"),
    /**
     * 已下架商品
     */
    Down(1,"下架")
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
