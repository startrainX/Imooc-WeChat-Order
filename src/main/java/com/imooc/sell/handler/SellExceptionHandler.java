package com.imooc.sell.handler;

import com.imooc.sell.exception.SellException;
import com.imooc.sell.exception.SellerAuthorizeException;
import com.imooc.sell.utils.ResultVoUtil;
import com.imooc.sell.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @ExceptionHandler(SellException.class)
    @ResponseBody
    public ResultVo handlerSellException(SellException e){
        return ResultVoUtil.error(e.getCode(), e.getMessage());
    }
}
