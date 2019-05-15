package com.imooc.sell.constant;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * redis 常量
 * @author ：zsp
 * @date ：Created in 2019/5/15 16:04
 */
public interface RedisConstant {

    String TOKEN_PREFIX = "token_%s";

    //两小时

    Integer EXPIRE = 7200;
}
