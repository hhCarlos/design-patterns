package io.github.hhcarlos.designpatterns.behavioral.state.lamp.states;

import io.github.hhcarlos.designpatterns.behavioral.state.lamp.Lamp;
import io.github.hhcarlos.designpatterns.behavioral.state.lamp.LampState;
import io.github.hhcarlos.designpatterns.behavioral.state.lamp.LampStatus;

public class OnState implements LampState {
    @Override
    public void press(Lamp lamp) {
        System.out.println("Turn lamp off.");

        lamp.changeState(new OffState());
    }

    @Override
    public LampStatus status() {
        return LampStatus.ON;
    }
}
