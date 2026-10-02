package io.github.hhcarlos.designpatterns.structural.adapter.db.adapters;

import io.github.hhcarlos.designpatterns.structural.adapter.db.DBAdapter;
import io.github.hhcarlos.designpatterns.structural.adapter.db.connectors.MongoDB;

public class MongoDBAdapter implements DBAdapter {
    private MongoDB mongoDB;

    public MongoDBAdapter(MongoDB mongoDB) {
        this.mongoDB = mongoDB;
    }

    @Override
    public void connect() {
    this.mongoDB.startMongoDB();
    }

    @Override
    public void disconnect() {
        this.mongoDB.turnItDown();
    }

    @Override
    public void resetConnection() {
        throw new UnsupportedOperationException(
                "This MongoDB does not support operation."
        );
    }
}
