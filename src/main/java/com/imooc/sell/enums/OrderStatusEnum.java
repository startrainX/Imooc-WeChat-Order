package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 订单状态
 * @author ：zsp
 * @date ：Created in 2019/5/6 14:46
 */
@Getter
public enum  OrderStatusEnum {
    /**
     * 新订单信息
     */
    NEW (0, "新订单"),
    /**
     * 已完成顶单信息
     */
    FINISH(1, "已完成"),
    /**
     * 已取消顶单信息
     */
    CANCEL(2, "已取消")
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
