package com.imooc.sell.handler;

import com.imooc.sell.exception.SellerAuthorizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/15 17:22
 */
@ControllerAdvice
public class SellExceptionHandler {

    /**
     * 拦截登录异常
     * @return
     */
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
        return new ModelAndView("/common/login");
    }
}
