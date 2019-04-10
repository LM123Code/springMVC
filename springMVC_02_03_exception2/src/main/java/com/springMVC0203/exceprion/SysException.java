package com.springMVC0203.exceprion;

/**
 * 1、编写自定义异常类
 * @author LM_Code
 * @create 2019-04-10-8:58
 */
public class SysException extends Exception {
    private String message;

    public SysException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
