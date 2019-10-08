package com.xhorse.entity.response;


import com.xhorse.common.enums.ResultEnum;

public class Result<T> {

    private String status;

    private String msg;

    private T data;

    public Result() {
    }

    public Result( ResultEnum resultCode, T data) {
        this(resultCode);
        this.data = data;
    }

    public Result( ResultEnum resultCode) {
        this.status = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
