package io.github.hhcarlos.designpatterns.behavioral.strategy;

import io.github.hhcarlos.designpatterns.behavioral.strategy.combat.*;
import io.github.hhcarlos.designpatterns.behavioral.strategy.order.OrderExample;

public final class Main {

    public static void main(String[] args) {
        System.out.println("Working with the Strategy pattern.");

        // CombatExample.run();

        OrderExample.run();
    }
}
