package com.imooc.sell.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求返回的最外层对象 ViewObject
 * @author ：zsp
 * @date ：Created in 2019/5/5 16:50
 */
@Data
public class ResultVo<T> implements Serializable{

    private static final long serialVersionUID = -5638414267303610471L;
    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;
}
