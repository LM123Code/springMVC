package com.springMVC0204.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1、编写拦截器类，实现HandlerInterceptor接口
 * @author LM_Code
 * @create 2019-04-10-15:00
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 预处理方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("预处理执行了。。。");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return true;
    }

    /**
     * 后处理的方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("后处理执行了。。。");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("最后执行了。。。");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);//加跳转页面会报错，也不会跳转
    }
}