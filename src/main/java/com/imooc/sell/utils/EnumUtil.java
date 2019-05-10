package com.imooc.sell.utils;

import com.imooc.sell.enums.CodeEnum;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/10 14:20
 */
public class EnumUtil {

    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumClass){

        for (T each : enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
