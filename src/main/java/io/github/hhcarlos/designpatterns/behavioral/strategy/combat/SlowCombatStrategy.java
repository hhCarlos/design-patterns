package io.github.hhcarlos.designpatterns.behavioral.strategy.combat;

public class SlowCombatStrategy implements CombatStrategy {
    @Override
    public void attack(int quantity) {
        System.out.println(
                "Ataque de slow estrategy: " + quantity
        );
    }

    @Override
    public void defend(int quantity) {
        System.out.println(
                "Defensa de slow estrategy: " + quantity
        );

        spitElement();
    }

    private void spitElement() {
        System.out.println("Este enemigo escupe acido.");
    }
}
