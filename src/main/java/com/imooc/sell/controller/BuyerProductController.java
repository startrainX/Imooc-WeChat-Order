package com.imooc.sell.controller;

import com.imooc.sell.vo.ProductInfoVo;
import com.imooc.sell.vo.ProductVo;
import com.imooc.sell.vo.ResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 买家商品
 * @author ：zsp
 * @date ：Created in 2019/5/5 16:45
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @GetMapping("/list")
    public ResultVo list(){

        ResultVo resultVo = new ResultVo();
        ProductVo productVo = new ProductVo();
        ProductInfoVo productInfoVo = new ProductInfoVo();

        resultVo.setCode(0);
        resultVo.setMsg("成功");

        productVo.setProductInfoVoList(Arrays.asList(productInfoVo));
        resultVo.setData(Arrays.asList(productVo));

        return resultVo;
    }
}
