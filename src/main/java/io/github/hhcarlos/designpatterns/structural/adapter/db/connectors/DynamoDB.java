package io.github.hhcarlos.designpatterns.structural.adapter.db.connectors;

public class DynamoDB {
    public void dbConnection() {
        System.out.println("DynamoDB: connection opened.");
    }

    public void close() {
        System.out.println("DynamoDB: connection closed.");
    }
}
