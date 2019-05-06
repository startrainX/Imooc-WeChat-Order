package com.imooc.sell.utils;

import java.util.Random;

/**
 * 生成唯一主键
 * @author ：zsp
 * @date ：Created in 2019/5/6 16:57
 */
public class KeyUtil {

    /**
     * 格式：时间 + 随机数
     */
    public static synchronized String genUniqueKey(){

        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
