package com.xhorse.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.xhorse.common.constant.DynamodbConstant;
import com.xhorse.common.enums.MethodCallEnums;
import com.xhorse.common.enums.ResultEnum;
import com.xhorse.common.util.ResultUtil;
import com.xhorse.entity.model.XhCopyHistory;
import com.xhorse.entity.response.GatewayResponse;
import com.xhorse.entity.response.Result;

import java.util.HashMap;
import java.util.Map;


public class LambdaFunctionHandler implements RequestHandler<Object,Object > {

    int warmNum = 0;
    public GatewayResponse handleRequest(Object input, Context context) {
        Object data = null;
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");
        try {
            // 获取传入数据
            Object body = JSON.parseObject(JSONObject.toJSONString(input)).get("body");

            if(body.toString().equals("<body><action>WARMUP</action></body>")){
                this.timingTask();
                warmNum++;
                context.getLogger().log("启动次数："+warmNum);
                return new GatewayResponse("{}",headers,200);
            }

            JSONObject requestDTO = JSON.parseObject(body.toString());
            String requestMethod = requestDTO.getString("requestMethod");
            String requestData = requestDTO.getString("requestData");

            // 调用对应的方法
            String serviceName = MethodCallEnums.getServiceNameByMethod(requestMethod);
            String methodNameBymethod = MethodCallEnums.getMethodNameBymethod(requestMethod);
            Class aClass = Class.forName(serviceName);
            if (null == requestData || requestData.isEmpty()) {
                try {
                    data = aClass.getMethod(methodNameBymethod).invoke(aClass.newInstance());
                    Result result = ResultUtil.success(data);
                    return new GatewayResponse(JSON.toJSONString(result),headers,200);
                } catch (Exception e) {
                    e.printStackTrace();
                    Result result = ResultUtil.warn(ResultEnum.FAILED);
                    return new GatewayResponse(JSON.toJSONString(result),headers,500);                }
            } else {
                try {
                    data = aClass.getMethod(methodNameBymethod, String.class).invoke(aClass.newInstance(), requestData);
                    Result result = ResultUtil.success(data);
                    return new GatewayResponse(JSON.toJSONString(result),headers,200);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    Result result = ResultUtil.warn(ResultEnum.FAILED);
                    return new GatewayResponse(JSON.toJSONString(result),headers,500);                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Result result = ResultUtil.warn(ResultEnum.FAILED);
            return new GatewayResponse(JSON.toJSONString(result),headers,500);
        }

    }
    public void timingTask(){
        DynamodbConstant.mapper.load(XhCopyHistory.class,"1","1");
    }

}
