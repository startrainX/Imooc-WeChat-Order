package com.imooc.sell.form;

import lombok.Data;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/15 13:54
 */
@Data
public class SellerForm {

    private String sellerId;

    /** 用户名. */
    private String username;

    /** 密码. */
    private String password;

    /** 微信openid. 没有openid，所以注册的时候录入 */
    private String openid;
}
