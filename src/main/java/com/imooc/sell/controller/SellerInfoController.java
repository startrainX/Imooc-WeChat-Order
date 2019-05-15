package com.imooc.sell.controller;

import com.imooc.sell.config.ProjectUrlConfig;
import com.imooc.sell.constant.CookieConstant;
import com.imooc.sell.constant.RedisConstant;
import com.imooc.sell.dataobject.SellerInfo;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.form.SellerForm;
import com.imooc.sell.service.SellerInfoService;
import com.imooc.sell.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author ：zsp
 * @date ：Created in 2019/5/15 11:55
 */
@Controller
@Slf4j
@RequestMapping("/seller")
public class SellerInfoController {

    @Autowired
    private SellerInfoService sellerInfoService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("common/login");
    }

    /**
     * 登录
     * @param openid
     * @param response
     * @param map
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid")String openid,
                              HttpServletResponse response,
                              Map<String , Object> map){

        //1. openid去和数据库里的数据匹配
        SellerInfo sellerInfo = sellerInfoService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error");
        }

        //2. 设置token至redis

        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token), openid, expire, TimeUnit.SECONDS);

        //3. 设置token至cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);

        return new ModelAndView("redirect:/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletResponse response,
                              HttpServletRequest request,
                              Map<String , Object> map){
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null){
            //2. 清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));

            //3. 清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

    /**
     * 登录
     * @return
     */
    @PostMapping("/login")
    public ModelAndView login(@Valid SellerForm sellerForm,
                              BindingResult bindingResult,
                              Map<String, Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/login");
            return new ModelAndView("common/error", map);
        }
        SellerInfo sellerInfo = sellerInfoService.findSellerInfoByOpenid(sellerForm.getOpenid());
        if (sellerInfo.getUsername().equals(sellerForm.getUsername())&&sellerInfo.getPassword().equals(sellerForm.getPassword())){
            map.put("msg", "登录成功");
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/success", map);
        }else {
            map.put("msg", "用户名或密码错误");
            map.put("url", "/sell/seller/login");
            return new ModelAndView("common/error", map);
        }
    }

    /**
     * 注册页面
     * @return
     */
    @GetMapping("/register")
    public ModelAndView register(){

        return new ModelAndView("common/register");
    }

    /**
     * 新增用户
     * @param sellerForm
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView register(@Valid SellerForm sellerForm,
                                 BindingResult bindingResult,
                                 Map<String, Object> map){
        if (bindingResult.hasErrors()){
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        SellerInfo sellerInfo = new SellerInfo();
        if (!StringUtils.isEmpty(sellerForm)){
            BeanUtils.copyProperties(sellerForm, sellerInfo);
            sellerInfoService.saveSellerInfo(sellerInfo);
        }
        map.put("msg", "注册成功");
        map.put("url", "/sell/seller/login");
        return new ModelAndView("common/success", map);
    }
}
