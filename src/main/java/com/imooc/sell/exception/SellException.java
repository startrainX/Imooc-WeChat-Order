package com.imooc.sell.exception;

import com.imooc.sell.enums.ResultEnum;

/**
 * 商品信息异常
 * @author ：zsp
 * @date ：Created in 2019/5/6 16:23
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
}
