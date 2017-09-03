package com.ithwong.common.entity;

import java.io.Serializable;

/**
 * @description 用于页面返回结果用
 * Created by Harry on 2017/7/20.
 */
public class Result implements Serializable{
    private static final long serialVersionUID = -1586118647101027089L;
    private int code;   //状态码(一般0是失败,1是成功,也可以使用http状态码来设置)
    private String message; //信息
    private Object object;  //结果
    private boolean success;    //是否成功

    public Result() { }

    public Result(int code, String message, Object object, boolean success) {
        this.code = code;
        this.message = message;
        this.object = object;
        this.success = success;
    }

    public static Result getSuccessResult() {
        return new Result(1,"",null,true);
    }

    public static Result getSuccessResult(int code,String message) {
        return new Result(code,message,null,true);
    }

    public static Result getSuccessResult(Object object) {
        return new Result(1,"",object,true);
    }

    public static Result getSuccessResult(String message,Object object) {
        return new Result(1,message,object,true);
    }

    public static Result getErrorResult(String message) {
        return new Result(0,message,null,false);
    }

    public static Result getErrorResult(int code,String message) {
        return new Result(code,message,null,false);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
