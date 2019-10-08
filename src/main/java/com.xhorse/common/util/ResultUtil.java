package com.xhorse.common.util;

import com.xhorse.common.enums.ResultEnum;
import com.xhorse.entity.response.Result;

import java.io.Serializable;

public class ResultUtil implements Serializable {

    public static Result success(Object data) {
        return new Result<>(ResultEnum.SUCCESS, data);
    }

    public static Result success() {
        return new Result<>(ResultEnum.SUCCESS);
    }

    public static Result warn( ResultEnum resultCode, String msg) {
        Result<Object> result = new Result<>(resultCode);
        result.setMsg(msg);
        return result;
    }

    public static Result warn(ResultEnum resultCode) {
        return new Result(resultCode);
    }

}