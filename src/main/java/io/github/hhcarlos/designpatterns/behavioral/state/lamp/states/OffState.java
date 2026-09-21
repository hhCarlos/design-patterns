package io.github.hhcarlos.designpatterns.behavioral.state.lamp.states;

import io.github.hhcarlos.designpatterns.behavioral.state.lamp.Lamp;
import io.github.hhcarlos.designpatterns.behavioral.state.lamp.LampState;
import io.github.hhcarlos.designpatterns.behavioral.state.lamp.LampStatus;

public class OffState implements LampState {
    @Override
    public void press(Lamp lamp) {
        System.out.println("Lamp at medium intensity");

        lamp.changeState(new MidState());
    }

    @Override
    public LampStatus status() {
        return LampStatus.OFF;
    }
}
