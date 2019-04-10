package com.springMVC0204.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1、编写拦截器类，实现HandlerInterceptor接口
 * 2、配置拦截器
 * @author LM_Code
 * @create 2019-04-10-9:45
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        System.out.println("testInterceptor执行了。。。");
        return "success";
    }
}
