package com.yangmiemie.ele.common.utils;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-04-18 14:39
 * Description:
 */
public enum MessageType {

    M10000(10000, "操作成功"),
    //10*** 基本功能相关
    M10001(10001, "登陆成功"),
    M10002(10002, "登录失败"),
    M10003(10003, "注册成功"),

    M99999(99999, "占个位子");

    private int status;
    private String msg;

    private MessageType(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
