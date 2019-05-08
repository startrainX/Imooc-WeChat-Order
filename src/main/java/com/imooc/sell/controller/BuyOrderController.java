package com.imooc.sell.controller;

import com.imooc.sell.converter.OrderFormToOrderDtoConverter;
import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDTO;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.form.OrderForm;
import com.imooc.sell.service.BuyerService;
import com.imooc.sell.service.OrderService;
import com.imooc.sell.utils.ResultVoUtil;
import com.imooc.sell.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 买家订单
 * @author ：zsp
 * @date ：Created in 2019/5/8 14:29
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;

    //1. 创建订单

    @PostMapping("/create")
    public ResultVo<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            log.error("【创建订单】 错误 orderForm = {}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderFormToOrderDtoConverter.converter(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();

        map.put("orderId", result.getOrderId());

        return ResultVoUtil.success(map);
    }

    //2. 查看订单
    // 订单列表

    @GetMapping("/list")
    public ResultVo<OrderDTO> list(@RequestParam("openId") String openId,
                                   @RequestParam(value = "page", defaultValue = "0") Integer page,
                                   @RequestParam(value = "size", defaultValue = "0") Integer size){
        if (StringUtils.isEmpty(openId)){
            log.error("【查询订单列表】 openId为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }

        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openId, request);

        return ResultVoUtil.success(orderDTOPage.getContent());
    }

    // 订单详情

    @GetMapping("/detail")
    public ResultVo<OrderDTO> detail(@RequestParam("openId") String openId,
                                     @RequestParam("orderId") String orderId){
        OrderDTO orderDTO = buyerService.findOrderOne(openId, orderId);
        return ResultVoUtil.success(orderDTO);
    }

    //3. 取消订单

    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam("openId") String openId,
                           @RequestParam("orderId") String orderId){
        buyerService.cancelOrder(openId, orderId);
        return ResultVoUtil.success();
    }

}
