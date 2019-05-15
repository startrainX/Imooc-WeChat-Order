package com.imooc.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 卖家信息
 * @author ：zsp
 * @date ：Created in 2019/5/15 11:32
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    /** 用户名. */
    private String username;

    /** 密码. */
    private String password;

    /** 微信openid. 没有openid，所以注册的时候录入 */
    private String openid;
}
