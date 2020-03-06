package com.xhorse.common.constant;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class DynamodbConstant {
public static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
        new AwsClientBuilder.EndpointConfiguration("http://127.0.0.1:8000", "cn-northwest-1")).build();
//    public static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
    public static DynamoDB dynamoDB = new DynamoDB(client);
    public static DynamoDBMapper mapper = new DynamoDBMapper(client);
}
