package com.test.demo.entity;

public class CollectResult<T> {
    private String msg;
    //数据是否正常请求
    private boolean success;
    //具体返回的数据
    private T detail;

    public java.lang.String getMsg() {
        return msg;
    }

    public void setMsg(java.lang.String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }
}
