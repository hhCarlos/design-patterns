package io.github.hhcarlos.designpatterns.behavioral.strategy;

public class AggressiveCombatStrategy implements CombatStrategy {
    @Override
    public void attack(int quantity) {
        System.out.println(
                "Ataque agresivo con fuerza: " + quantity
        );
    }

    @Override
    public void defend(int quantity) {
        System.out.println(
                "Defensa agresiva: " + quantity
        );
    }
}
