package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 商品状态
 * @author ：zsp
 * @date ：Created in 2019/5/5 16:15
 */
@Getter
public enum ProductStatusEnum {

    Up(0,"上架"),
    Down(1,"下架")
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
