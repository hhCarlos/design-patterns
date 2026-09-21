package io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility;

import io.github.hhcarlos.designpatterns.behavioral.chainofresponsibility.roles.RoleChainExample;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        System.out.println("Working with the Chain of Responsibility pattern.");

        RoleChainExample.run();
    }
}
