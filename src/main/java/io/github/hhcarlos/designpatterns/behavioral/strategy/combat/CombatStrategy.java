package io.github.hhcarlos.designpatterns.behavioral.strategy.combat;

public interface CombatStrategy {

    void attack(int quantity);

    void defend(int quantity);
}
