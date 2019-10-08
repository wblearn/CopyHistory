package com.xhorse.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.ScanResultPage;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.xhorse.common.constant.DynamodbConstant;
import com.xhorse.entity.model.XhCopyHistory;
import com.xhorse.entity.response.CopyHistoryResponse;
import com.xhorse.service.ICopyHistoryService;

import javax.inject.Singleton;
import java.text.SimpleDateFormat;
import java.util.*;

@Singleton
public class CopyHistoryServiceImpl implements ICopyHistoryService {

    @Override
    public List<XhCopyHistory> queryCopyHistoryByType(String json) {
        List<XhCopyHistory> result = new ArrayList<>();
        JSONObject jo = JSONObject.parseObject(json);
        String sn = jo.getString("sn");
        String customerId = jo.getString("customerId");
        Integer length = jo.getInteger("length");
        String copyType = jo.getString("copyType");

        Map<String,AttributeValue> eav = new HashMap<>();
        eav.put(":v1",new AttributeValue().withS(sn));
        eav.put(":v2",new AttributeValue().withS(customerId));
        eav.put(":v3",new AttributeValue().withN(copyType));

        DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
                .withFilterExpression("Sn = :v1 and CustomerId = :v2 and CopyType = :v3")
                .withExpressionAttributeValues(eav);
        ScanResultPage<XhCopyHistory> scanResultPage = DynamodbConstant.mapper.scanPage(XhCopyHistory.class,scanExpression);

        int pageNum = length / 10 + 1;
        int currentNum = length*pageNum;
        int start=0+length;
        int end = scanResultPage.getCount();
        List<XhCopyHistory> list = new ArrayList<>();
        if(currentNum==0){
            currentNum=10;
        }
        if(currentNum<=end){
            list = scanResultPage.getResults().subList(start,currentNum);
        }else if(currentNum>end&&start<end){
            list = scanResultPage.getResults().subList(start,end);
        }else{
            list = scanResultPage.getResults().subList(0,end);
        }

        List<XhCopyHistory> temp = new ArrayList<>();
        for(XhCopyHistory xhCopyHistory : list){
            xhCopyHistory.setCreate_At(xhCopyHistory.getCreate_At().substring(0,10));
            result.add(xhCopyHistory);
        }
        return result;
    }

    @Override
    public void uploadCopyHistory(String json) {
        SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone gmt = TimeZone.getTimeZone("GMT+8");
        sf.setTimeZone(gmt);
        String create_at =sf.format(new Date());
        CopyHistoryResponse br = new CopyHistoryResponse();
        JSONObject jo = JSONObject.parseObject(json);
        String sn = jo.getString("sn");
        String customerId = jo.getString("customerId");
        String name = jo.getString("name");
        String data = jo.getString("data");
        Integer copyType = jo.getInteger("copyType");
        Integer chipType = jo.getInteger("chipType");
        if(chipType==null){
            chipType=0;
        }
        XhCopyHistory xhCopyHistory = new XhCopyHistory();
        xhCopyHistory.setSn(sn);
        xhCopyHistory.setCustomerId(customerId);
        xhCopyHistory.setName(name);
        xhCopyHistory.setData(data);
        xhCopyHistory.setCreate_At(create_at);
        xhCopyHistory.setChipType(chipType);
        xhCopyHistory.setCopyType(copyType);
        DynamodbConstant.mapper.save(xhCopyHistory);
    }

    @Override
    public void updateCopyHistoryById(String json) {
        SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone gmt = TimeZone.getTimeZone("GMT+8");
        sf.setTimeZone(gmt);
        String create_at =sf.format(new Date());
        CopyHistoryResponse br = new CopyHistoryResponse();
        JSONObject jo = JSONObject.parseObject(json);
        String id = jo.getString("id");
        String sn = jo.getString("sn");
        String name = jo.getString("name");
        XhCopyHistory xhCopyHistory = new XhCopyHistory();
        xhCopyHistory.setId(id);
        xhCopyHistory.setSn(sn);
        xhCopyHistory.setName(name);
        xhCopyHistory.setCreate_At(create_at);
        DynamodbConstant.mapper.save(xhCopyHistory,new DynamoDBMapperConfig(DynamoDBMapperConfig.SaveBehavior.UPDATE_SKIP_NULL_ATTRIBUTES));
    }

}
