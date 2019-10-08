package com.xhorse.common.util;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DynamoTabGenerator {
    static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
            new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "cn-northwest-1")).build();
    static DynamoDB dynamoDB = new DynamoDB(client);


    static void createExampleTable(String tableName,List<AttributeDefinition> attributeDefinitions,
                                   List<KeySchemaElement> keySchema,ProvisionedThroughput provisionedThroughput) {
        try {

            CreateTableRequest request = new CreateTableRequest().withTableName(tableName).withKeySchema(keySchema)
                    .withAttributeDefinitions(attributeDefinitions).withProvisionedThroughput(
                            new ProvisionedThroughput().withReadCapacityUnits(provisionedThroughput.getReadCapacityUnits()).withWriteCapacityUnits(provisionedThroughput.getWriteCapacityUnits()));

            System.out.println("Issuing CreateTable request for " + tableName);
            Table table = dynamoDB.createTable(request);

            System.out.println("Waiting for " + tableName + " to be created...this may take a while...");
            table.waitForActive();
        }
        catch (Exception e) {
            System.err.println("CreateTable request failed for " + tableName);
            System.err.println(e.getMessage());
        }

    }

    static void listMyTables() {

        TableCollection<ListTablesResult> tables = dynamoDB.listTables();
        Iterator<Table> iterator = tables.iterator();

        System.out.println("Listing table names");

        while (iterator.hasNext()) {
            Table table = iterator.next();
            System.out.println(table.getTableName());
        }
    }

    static void getTableInformation(String tableName) {

        System.out.println("Describing " + tableName);

        TableDescription tableDescription = dynamoDB.getTable(tableName).describe();
        System.out.format(
                "Name: %s:\n" + "Status: %s \n" + "Provisioned Throughput (read capacity units/sec): %d \n"
                        + "Provisioned Throughput (write capacity units/sec): %d \n",
                tableDescription.getTableName(), tableDescription.getTableStatus(),
                tableDescription.getProvisionedThroughput().getReadCapacityUnits(),
                tableDescription.getProvisionedThroughput().getWriteCapacityUnits());
    }

    static void updateExampleTable(String tableName) {

        Table table = dynamoDB.getTable(tableName);
        System.out.println("Modifying provisioned throughput for " + tableName);

        try {
            table.updateTable(new ProvisionedThroughput().withReadCapacityUnits(6L).withWriteCapacityUnits(7L));

            table.waitForActive();
        }
        catch (Exception e) {
            System.err.println("UpdateTable request failed for " + tableName);
            System.err.println(e.getMessage());
        }
    }

    static void deleteExampleTable(String tableName) {

        Table table = dynamoDB.getTable(tableName);
        try {
            System.out.println("Issuing DeleteTable request for " + tableName);
            table.delete();

            System.out.println("Waiting for " + tableName + " to be deleted...this may take a while...");

            table.waitForDelete();
        }
        catch (Exception e) {
            System.err.println("DeleteTable request failed for " + tableName);
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String tableName="Music3";
        List<AttributeDefinition> attributeDefinitions=new ArrayList<>();
        AttributeDefinition a = new AttributeDefinition();
        a.setAttributeName("Id");
        a.setAttributeType("N");
        attributeDefinitions.add(a);
        List<KeySchemaElement> keySchema=new ArrayList<>();
        KeySchemaElement k = new KeySchemaElement();
        k.setAttributeName("Id");
        k.withKeyType(KeyType.HASH);
        keySchema.add(k);
        ProvisionedThroughput provisionedThroughput=new ProvisionedThroughput();
        provisionedThroughput.setReadCapacityUnits(5L);
        provisionedThroughput.setWriteCapacityUnits(6L);
        createExampleTable(tableName,attributeDefinitions,keySchema,provisionedThroughput);

        listMyTables();

        getTableInformation("ProductCatalog");
    }
}

