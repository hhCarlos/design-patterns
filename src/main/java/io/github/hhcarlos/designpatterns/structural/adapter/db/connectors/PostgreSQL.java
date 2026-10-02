package io.github.hhcarlos.designpatterns.structural.adapter.db.connectors;

public class PostgreSQL {
    public void makeConnection() {
        System.out.println("PostgreSQL: connection opened.");
    }

    public void reinitConnection() {
        System.out.println("PostgreSQL: connection reinitialized.");
    }
}
