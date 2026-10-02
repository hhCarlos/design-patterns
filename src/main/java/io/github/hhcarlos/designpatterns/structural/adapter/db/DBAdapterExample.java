package io.github.hhcarlos.designpatterns.structural.adapter.db;

import io.github.hhcarlos.designpatterns.structural.adapter.db.adapters.MySQLAdapter;
import io.github.hhcarlos.designpatterns.structural.adapter.db.adapters.PostgreSQLAdapter;
import io.github.hhcarlos.designpatterns.structural.adapter.db.connectors.MySQL;
import io.github.hhcarlos.designpatterns.structural.adapter.db.connectors.PostgreSQL;

public class DBAdapterExample {
    public static void run() {
        MySQLAdapter mySQLAdapter = new MySQLAdapter(new MySQL());
        mySQLAdapter.connect();
        mySQLAdapter.resetConnection();
        mySQLAdapter.disconnect();

        PostgreSQLAdapter postgreSQLAdapter =
                new PostgreSQLAdapter(new PostgreSQL());

        postgreSQLAdapter.connect();

        try {
            postgreSQLAdapter.disconnect();
        } catch (UnsupportedOperationException e) {
            System.out.println("Operation not supported: " + e.getMessage());
        }

        postgreSQLAdapter.resetConnection();
    }
}
