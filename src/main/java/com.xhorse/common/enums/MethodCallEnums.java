package com.xhorse.common.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum
MethodCallEnums {
    QUERY_METHOD("queryCopyHistoryByType","com.xhorse.service.impl.CopyHistoryServiceImpl","queryCopyHistoryByType","根据序列号拷贝类型等查询比亚迪历史"),

    UPLOAD_METHOD( "uploadCopyHistory","com.xhorse.service.impl.CopyHistoryServiceImpl", "uploadCopyHistory", "上传比亚迪历史"),

    UPDATE_METHOD("updateCopyHistoryById","com.xhorse.service.impl.CopyHistoryServiceImpl","updateCopyHistoryById","根据id和序列号修改比亚迪历史")
    ;


    private final String method;
    private final String serviceName;
    private final String methodName;
    private final String explain;

    MethodCallEnums(String method, String serviceName, String methodName, String explain) {
        this.method = method;
        this.serviceName = serviceName;
        this.methodName = methodName;
        this.explain = explain;
    }

    public String getmethod() {
        return method;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public String getExplain() {
        return explain;
    }

    /**
     * 通过枚举method获取对应的serviceName
     *
     * @return 取不到时返回null
     */
    public static String getServiceNameByMethod(String method) {
        for (MethodCallEnums _enum : values()) {
            if (_enum.getmethod().equals(method)) {
                return _enum.getServiceName();
            }
        }
        return null;
    }

    /**
     * 通过枚举method获取对应的methodName
     *
     * @return 取不到时返回null
     */
    public static String getMethodNameBymethod(String method) {
        for (MethodCallEnums _enum : values()) {
            if (_enum.getmethod().equals(method)) {
                return _enum.getMethodName();
            }
        }
        return null;
    }

    /**
     * 通过枚举method获取对应的methodName
     *
     * @return 取不到时返回null
     */
    public static String getExplainBymethod(String method) {
        for (MethodCallEnums _enum : values()) {
            if (_enum.getmethod().equals(method)) {
                return _enum.getExplain();
            }
        }
        return null;
    }

    /**
     * 通过枚举method获取枚举对象
     *
     * @return 取不到时返回null
     */
    public static MethodCallEnums getByMethod(String method) {
        for (MethodCallEnums _enum : values()) {
            if (_enum.getmethod().equals(method)) {
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
    public List<MethodCallEnums> getAllEnum() {
        List<MethodCallEnums> list = new ArrayList<>();
        Collections.addAll(list, values());
        return list;
    }

    /**
     * 获取全部枚举method
     *
     * @return 取不到时返回空List=new ArrayList<Integer>()
     */
    public List<String> getAllEnumMethod() {
        List<String> list = new ArrayList<>();
        for (MethodCallEnums _enum : values()) {
            list.add(_enum.getmethod());
        }
        return list;
    }

}

