package io.github.hhcarlos.designpatterns.structural.adapter.db.connectors;

public class MongoDB {
    public void startMongoDB() {
        System.out.println("MongoDB: server started.");
    }

    public void turnItDown() {
        System.out.println("MongoDB: server stopped.");
    }
}
