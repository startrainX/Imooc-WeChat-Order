package com.imooc.sell.enums;

import lombok.Getter;

/**
 * 支付状态
 * @author ：zsp
 * @date ：Created in 2019/5/6 14:52
 */
@Getter
public enum PayStatusEnum {

    /**
     * 未支付
     */
    WAIT(0, "未支付"),
    /**
     * 已支付
     */
    SUCCESS(1, "支付成功")

    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
