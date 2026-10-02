package io.github.hhcarlos.designpatterns.structural.adapter.db;

public interface DBAdapter {
    public void connect();
    public void disconnect();
    public void resetConnection();
}
