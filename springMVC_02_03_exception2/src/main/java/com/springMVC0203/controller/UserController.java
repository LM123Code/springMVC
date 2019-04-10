package com.springMVC0203.controller;

import com.springMVC0203.exceprion.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1、编写自定义异常类
 * 2、编写异常处理器
 * @author LM_Code
 * @create 2019-04-10-8:22
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/testException")
    public String testException() throws SysException{
        System.out.println("testException......");
        try {
            //模拟异常
            int a = 10/0;
        } catch (Exception e) {
            //控制台打印异常
            e.printStackTrace();
            throw new SysException("查询所有的用户出现了错误。。。。。。");
        }
        return "success";
    }
}
