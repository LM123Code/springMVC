package com.springMVC0203.exceprion;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 2、编写异常处理器
 * @author LM_Code
 * @create 2019-04-10-9:03
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常的逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        SysException sysException = null;
        if(e instanceof SysException){
            sysException = (SysException)e;
        }else {
            sysException = new SysException("系统正在维护....");
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", sysException);
        mv.setViewName("error");
        return mv;
    }
}
