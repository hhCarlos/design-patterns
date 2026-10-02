package io.github.hhcarlos.designpatterns.structural.adapter;

import io.github.hhcarlos.designpatterns.structural.adapter.db.DBAdapterExample;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        System.out.println("Working with the Adapter pattern.");

        DBAdapterExample.run();
    }
}
