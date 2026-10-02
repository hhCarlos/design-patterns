package io.github.hhcarlos.designpatterns.structural.adapter.db.adapters;

import io.github.hhcarlos.designpatterns.structural.adapter.db.DBAdapter;
import io.github.hhcarlos.designpatterns.structural.adapter.db.connectors.MySQL;

public class MySQLAdapter implements DBAdapter {
    private MySQL mySQL;

    public MySQLAdapter(MySQL mySQL) {
        this.mySQL = mySQL;
    }

    @Override
    public void connect() {
        this.mySQL.createConnection();
    }

    @Override
    public void disconnect() {
        this.mySQL.deleteConnection();
    }

    @Override
    public void resetConnection() {
        this.mySQL.resetConnection();
    }
}
