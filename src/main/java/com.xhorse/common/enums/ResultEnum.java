package com.xhorse.common.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum  ResultEnum {

    SUCCESS("1001", "SUCCESS"),
    FAILED("1002", "FAILURE");




    private final String code;
    private final String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 通过枚举code获取对应的msg
     *
     * @return 取不到时返回null
     */
    public static String getMsgByCode(String code) {
        for (ResultEnum _enum : values()) {
            if (_enum.getCode()==code) {
                return _enum.getMsg();
            }
        }
        return null;
    }

    /**
     * 通过枚举code获取枚举对象
     *
     * @return 取不到时返回null
     */
    public static ResultEnum getByCode(String code) {
        for (ResultEnum _enum : values()) {
            if (_enum.getCode()==code) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return 取不到时返回空List=new ArrayList<>()
     */
    public List<ResultEnum> getAllEnum() {
        List<ResultEnum> list = new ArrayList<>();
        Collections.addAll(list, values());
        return list;
    }


}
