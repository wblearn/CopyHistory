import com.alibaba.fastjson.JSON;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.xhorse.common.constant.DynamodbConstant;
import com.xhorse.entity.model.XhCopyHistory;
import com.xhorse.entity.response.GatewayResponse;
import com.xhorse.handler.LambdaFunctionHandler;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

import static com.xhorse.common.constant.DynamodbConstant.dynamoDB;

public class Test {

    @org.junit.Test
    public void test1(){
        XhCopyHistory xh = new XhCopyHistory();
        SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TimeZone gmt = TimeZone.getTimeZone("GMT+8");
        sf.setTimeZone(gmt);
        String create_at =sf.format(new Date());
        xh.setSn("33fd3");
        xh.setCustomerId("33232");
        xh.setName("测试");
        xh.setData("djdjs");
        xh.setCopyType(2);
        xh.setChipType(1);
        xh.setCreate_At(create_at);
        DynamodbConstant.mapper.save(xh);
//        DynamodbConstant.mapper.delete(xh);
    }

    @org.junit.Test
    public void test2(){
        String json = "{\"body\":\"{\\\"requestData\\\":{\\\"Sn\\\":\\\"123\\\",\\\"CustomerId\\\":\\\"1\\\",\\\"Length\\\":\\\"10\\\"},\\\"requestMethod\\\":\\\"queryBydHistoryBySn\\\"}\",\"resource\":\"/{proxy+}\",\"path\":\"/path/to/resource\",\"httpMethod\":\"POST\",\"isBase64Encoded\":true,\"queryStringParameters\":{\"foo\":\"bar\"},\"pathParameters\":{\"proxy\":\"/async/end\"},\"stageVariables\":{\"baz\":\"qux\"},\"headers\":{\"Accept\":\"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\",\"Accept-Encoding\":\"gzip, deflate, sdch\",\"Accept-Language\":\"en-US,en;q=0.8\",\"Cache-Control\":\"max-age=0\",\"CloudFront-Forwarded-Proto\":\"https\",\"CloudFront-Is-Desktop-Viewer\":\"true\",\"CloudFront-Is-Mobile-Viewer\":\"false\",\"CloudFront-Is-SmartTV-Viewer\":\"false\",\"CloudFront-Is-Tablet-Viewer\":\"false\",\"CloudFront-Viewer-Country\":\"US\",\"Host\":\"1234567890.execute-api.cn-northwest-1.amazonaws.com.cn\",\"Upgrade-Insecure-Requests\":\"1\",\"User-Agent\":\"Custom User Agent String\",\"Via\":\"1.1 08f323deadbeefa7af34d5feb414ce27.cloudfront.net (CloudFront)\",\"X-Amz-Cf-Id\":\"cDehVQoZnx43VYQb9j2-nvCh-9z396Uhbp027Y2JvkCPNLmGJHqlaA==\",\"X-Forwarded-For\":\"127.0.0.1, 127.0.0.2\",\"X-Forwarded-Port\":\"443\",\"X-Forwarded-Proto\":\"https\"},\"requestContext\":{\"accountId\":\"123456789012\",\"resourceId\":\"123456\",\"stage\":\"prod\",\"requestId\":\"c6af9ac6-7b61-11e6-9a41-93e8deadbe23\",\"requestTime\":\"09/Apr/2015:12:34:56 +0000\",\"requestTimeEpoch\":1428582896000,\"identity\":{\"cognitoIdentityPoolId\":null,\"accountId\":null,\"cognitoIdentityId\":null,\"caller\":null,\"accessKey\":null,\"sourceIp\":\"127.0.0.1\",\"cognitoAuthenticationType\":null,\"cognitoAuthenticationProvider\":null,\"userArn\":null,\"userAgent\":\"Custom User Agent String\",\"user\":null},\"path\":\"/prod/path/to/resource\",\"resourcePath\":\"/{proxy+}\",\"httpMethod\":\"POST\",\"apiId\":\"1234567890\",\"protocol\":\"HTTP/1.1\"}}";
        LambdaFunctionHandler lambdaFunctionHandler = new LambdaFunctionHandler();
        GatewayResponse result = lambdaFunctionHandler.handleRequest(JSON.parseObject(json), null);
        System.out.println(result.getBody());
    }

    @org.junit.Test
    public void test3(){
        String json = "{\"body\":\"{\\\"requestData\\\":{\\\"Sn\\\":\\\"123457\\\",\\\"CustomerId\\\":\\\"2\\\",\\\"Name\\\":\\\"jackson\\\",\\\"Data\\\":\\\"i like got7!\\\"},\\\"requestMethod\\\":\\\"uploadBydHistory\\\"}\",\"resource\":\"/{proxy+}\",\"path\":\"/path/to/resource\",\"httpMethod\":\"POST\",\"isBase64Encoded\":true,\"queryStringParameters\":{\"foo\":\"bar\"},\"pathParameters\":{\"proxy\":\"/async/end\"},\"stageVariables\":{\"baz\":\"qux\"},\"headers\":{\"Accept\":\"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\",\"Accept-Encoding\":\"gzip, deflate, sdch\",\"Accept-Language\":\"en-US,en;q=0.8\",\"Cache-Control\":\"max-age=0\",\"CloudFront-Forwarded-Proto\":\"https\",\"CloudFront-Is-Desktop-Viewer\":\"true\",\"CloudFront-Is-Mobile-Viewer\":\"false\",\"CloudFront-Is-SmartTV-Viewer\":\"false\",\"CloudFront-Is-Tablet-Viewer\":\"false\",\"CloudFront-Viewer-Country\":\"US\",\"Host\":\"1234567890.execute-api.cn-northwest-1.amazonaws.com.cn\",\"Upgrade-Insecure-Requests\":\"1\",\"User-Agent\":\"Custom User Agent String\",\"Via\":\"1.1 08f323deadbeefa7af34d5feb414ce27.cloudfront.net (CloudFront)\",\"X-Amz-Cf-Id\":\"cDehVQoZnx43VYQb9j2-nvCh-9z396Uhbp027Y2JvkCPNLmGJHqlaA==\",\"X-Forwarded-For\":\"127.0.0.1, 127.0.0.2\",\"X-Forwarded-Port\":\"443\",\"X-Forwarded-Proto\":\"https\"},\"requestContext\":{\"accountId\":\"123456789012\",\"resourceId\":\"123456\",\"stage\":\"prod\",\"requestId\":\"c6af9ac6-7b61-11e6-9a41-93e8deadbe23\",\"requestTime\":\"09/Apr/2015:12:34:56 +0000\",\"requestTimeEpoch\":1428582896000,\"identity\":{\"cognitoIdentityPoolId\":null,\"accountId\":null,\"cognitoIdentityId\":null,\"caller\":null,\"accessKey\":null,\"sourceIp\":\"127.0.0.1\",\"cognitoAuthenticationType\":null,\"cognitoAuthenticationProvider\":null,\"userArn\":null,\"userAgent\":\"Custom User Agent String\",\"user\":null},\"path\":\"/prod/path/to/resource\",\"resourcePath\":\"/{proxy+}\",\"httpMethod\":\"POST\",\"apiId\":\"1234567890\",\"protocol\":\"HTTP/1.1\"}}";
        LambdaFunctionHandler lambdaFunctionHandler = new LambdaFunctionHandler();
        GatewayResponse result = lambdaFunctionHandler.handleRequest(JSON.parseObject(json), null);
        System.out.println(result.getBody());
    }

    @org.junit.Test
    public void test4(){
        String json = "{\"body\":\"{\\\"requestData\\\":{\\\"Sn\\\":\\\"123457\\\",\\\"CustomerId\\\":\\\"2\\\",\\\"Name\\\":\\\"learnfor\\\",\\\"Data\\\":\\\"i like got7!\\\"},\\\"requestMethod\\\":\\\"updateBydHistoryBysn\\\"}\",\"resource\":\"/{proxy+}\",\"path\":\"/path/to/resource\",\"httpMethod\":\"POST\",\"isBase64Encoded\":true,\"queryStringParameters\":{\"foo\":\"bar\"},\"pathParameters\":{\"proxy\":\"/async/end\"},\"stageVariables\":{\"baz\":\"qux\"},\"headers\":{\"Accept\":\"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\",\"Accept-Encoding\":\"gzip, deflate, sdch\",\"Accept-Language\":\"en-US,en;q=0.8\",\"Cache-Control\":\"max-age=0\",\"CloudFront-Forwarded-Proto\":\"https\",\"CloudFront-Is-Desktop-Viewer\":\"true\",\"CloudFront-Is-Mobile-Viewer\":\"false\",\"CloudFront-Is-SmartTV-Viewer\":\"false\",\"CloudFront-Is-Tablet-Viewer\":\"false\",\"CloudFront-Viewer-Country\":\"US\",\"Host\":\"1234567890.execute-api.cn-northwest-1.amazonaws.com.cn\",\"Upgrade-Insecure-Requests\":\"1\",\"User-Agent\":\"Custom User Agent String\",\"Via\":\"1.1 08f323deadbeefa7af34d5feb414ce27.cloudfront.net (CloudFront)\",\"X-Amz-Cf-Id\":\"cDehVQoZnx43VYQb9j2-nvCh-9z396Uhbp027Y2JvkCPNLmGJHqlaA==\",\"X-Forwarded-For\":\"127.0.0.1, 127.0.0.2\",\"X-Forwarded-Port\":\"443\",\"X-Forwarded-Proto\":\"https\"},\"requestContext\":{\"accountId\":\"123456789012\",\"resourceId\":\"123456\",\"stage\":\"prod\",\"requestId\":\"c6af9ac6-7b61-11e6-9a41-93e8deadbe23\",\"requestTime\":\"09/Apr/2015:12:34:56 +0000\",\"requestTimeEpoch\":1428582896000,\"identity\":{\"cognitoIdentityPoolId\":null,\"accountId\":null,\"cognitoIdentityId\":null,\"caller\":null,\"accessKey\":null,\"sourceIp\":\"127.0.0.1\",\"cognitoAuthenticationType\":null,\"cognitoAuthenticationProvider\":null,\"userArn\":null,\"userAgent\":\"Custom User Agent String\",\"user\":null},\"path\":\"/prod/path/to/resource\",\"resourcePath\":\"/{proxy+}\",\"httpMethod\":\"POST\",\"apiId\":\"1234567890\",\"protocol\":\"HTTP/1.1\"}}";
        LambdaFunctionHandler lambdaFunctionHandler = new LambdaFunctionHandler();
        GatewayResponse result = lambdaFunctionHandler.handleRequest(JSON.parseObject(json), null);
        System.out.println(result.getBody());
    }
    //建表
    @org.junit.Test
    public  void createTable() throws InterruptedException {
        String tableName="CopyHistory_CopyHistory";
        Table table = dynamoDB.createTable(tableName,
                Arrays.asList(new KeySchemaElement("Id", KeyType.HASH),new KeySchemaElement("Sn", KeyType.RANGE)),
                Arrays.asList(new AttributeDefinition("Id", ScalarAttributeType.S),new AttributeDefinition("Sn", ScalarAttributeType.S)),
                new ProvisionedThroughput(10L, 10L));
        TableUtils.waitUntilActive(DynamodbConstant.client, tableName);
        System.out.println("Table status: " + table.getDescription().getTableStatus());
    }


}
