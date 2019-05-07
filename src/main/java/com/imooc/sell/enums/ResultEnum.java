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
    PRODUCT_STOCK_ERROR(-1, "库存不足"),
    ORDER_MASTER_NOT_EXIST(1, "订单不存在"),
    ORDER_DETAIL_NOT_EXIST(2, "订单详情不存在"),
    ORDER_STATUS_ERROR(3, "订单状态不正确"),
    ORDER_UPDATE_FAIL(4, "订单更新失败"),
    ORDER_PAY_STATUS_ERROR(5, "订单支付状态不正确")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
