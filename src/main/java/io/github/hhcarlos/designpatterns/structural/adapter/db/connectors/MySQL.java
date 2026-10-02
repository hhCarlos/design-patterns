package io.github.hhcarlos.designpatterns.structural.adapter.db.connectors;

public class MySQL {
    public void createConnection() {
        System.out.println("MySQL: connection opened.");
    }

    public void deleteConnection() {
        System.out.println("MySQL: connection closed.");
    }

    public void resetConnection() {
        System.out.println("MySQL: connection reseted.");
    }
}
