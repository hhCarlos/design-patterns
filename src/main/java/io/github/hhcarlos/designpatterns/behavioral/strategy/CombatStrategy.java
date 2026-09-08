package io.github.hhcarlos.designpatterns.behavioral.strategy;

public interface CombatStrategy {

    void attack(int quantity);

    void defend(int quantity);
}
