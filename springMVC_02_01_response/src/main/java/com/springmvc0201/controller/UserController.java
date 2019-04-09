package com.springmvc0201.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springmvc0201.domain.User;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author LM_Code
 * @create 2019-04-08-9:21
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回一个字符串
     * @param model 用来向request中存储键值对，不直接用httpServletRequest，防止未导入http相关包，产生的紧耦合
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(30);
        //使用model对象将数据存入request域
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 无返回值，进行跳转页面
     */
    @RequestMapping("testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过原生api进行请求转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);
        //通过原生api进行重定向,需要加上项目名
        response.sendRedirect(request.getContextPath() + "/index.jsp");
        //直接进行相应
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html；charset=UTF-8");
//        response.getWriter().print("hello,你好");
//        return;
    }

    /**
     * 返回ModelAndView对象
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("美美");
        user.setPassword("123");
        user.setAge(18);
        mv.addObject("user",user);
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字进行转发或重定向
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        //转发
//        return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:" + "/index.jsp";//不需要项目名
    }

    /**
     * 模拟ajax异步请求和响应
     */

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){//请求体的内容存入data，请求体为json对象，需要导入相关包，自动转化为user对象
        System.out.println("testAjax执行了。。。。");
        System.out.println(user);
        user.setUsername("haha");
        user.setAge(40);
        //相应json
        return user;
    }
}
