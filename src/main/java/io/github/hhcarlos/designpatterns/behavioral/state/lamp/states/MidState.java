package io.github.hhcarlos.designpatterns.behavioral.state.lamp.states;

import io.github.hhcarlos.designpatterns.behavioral.state.lamp.Lamp;
import io.github.hhcarlos.designpatterns.behavioral.state.lamp.LampState;
import io.github.hhcarlos.designpatterns.behavioral.state.lamp.LampStatus;

public class MidState implements LampState {
    @Override
    public void press(Lamp lamp) {
        System.out.println("Lamp at full intensity");

        lamp.changeState(new OnState());
    }

    @Override
    public LampStatus status() {
        return LampStatus.MID;
    }
}
