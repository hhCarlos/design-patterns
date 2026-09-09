package io.github.hhcarlos.designpatterns.behavioral.strategy.combat;

public final class CombatExample {

    private CombatExample() {}

    public static void run() {
        CombatStrategy aggressiveStrategy = new AggressiveCombatStrategy();

        Enemy enemy = new Enemy(
                "Marrano infernal",
                aggressiveStrategy
        );

        enemy.attack(40);
        enemy.defend(40);

        Enemy enemy1 = new Enemy(
                "Molis Crayolis",
                new SlowCombatStrategy()
        );

        enemy1.attack(1000);
        enemy1.defend(4000);
    }
}
