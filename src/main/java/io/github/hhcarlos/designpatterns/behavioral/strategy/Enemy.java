package io.github.hhcarlos.designpatterns.behavioral.strategy;

public class Enemy {
    private final String name;
    private CombatStrategy combatStrategy;

    public Enemy(String name, CombatStrategy combatStrategy) {
        this.name = name;
        this.combatStrategy = combatStrategy;
    }

    public void attack(int quantity) {
        combatStrategy.attack(quantity);
    }

    public void defend(int quantity) {
        combatStrategy.defend(quantity);
    }

    public void setCombatStrategy(CombatStrategy combatStrategy) {
        this.combatStrategy = combatStrategy;
    }
}
