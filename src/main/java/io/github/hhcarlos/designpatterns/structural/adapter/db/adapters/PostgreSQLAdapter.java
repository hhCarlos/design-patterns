package io.github.hhcarlos.designpatterns.structural.adapter.db.adapters;

import io.github.hhcarlos.designpatterns.structural.adapter.db.DBAdapter;
import io.github.hhcarlos.designpatterns.structural.adapter.db.connectors.PostgreSQL;

public class PostgreSQLAdapter implements DBAdapter {
    private PostgreSQL postgreSQL;

    public PostgreSQLAdapter(PostgreSQL postgreSQL) {
        this.postgreSQL = postgreSQL;
    }

    @Override
    public void connect() {
        this.postgreSQL.makeConnection();
    }

    @Override
    public void disconnect() {
        throw new UnsupportedOperationException(
                "This PostgreSQL connector does not support disconnecting."
        );
    }

    @Override
    public void resetConnection() {
    this.postgreSQL.reinitConnection();
    }
}
