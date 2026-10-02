package io.github.hhcarlos.designpatterns.structural.adapter.db.adapters;

import io.github.hhcarlos.designpatterns.structural.adapter.db.DBAdapter;
import io.github.hhcarlos.designpatterns.structural.adapter.db.connectors.DynamoDB;

public class DynamoDBAdapter implements DBAdapter {
    private DynamoDB dynamoDB;

    public DynamoDBAdapter(DynamoDB dynamoDB) {
        this.dynamoDB = dynamoDB;
    }

    @Override
    public void connect() {
        this.dynamoDB.dbConnection();
    }

    @Override
    public void disconnect() {
        this.dynamoDB.close();
    }

    @Override
    public void resetConnection() {
        throw new UnsupportedOperationException(
                "This DynamoDB does not support this operation."
        );
    }
}
