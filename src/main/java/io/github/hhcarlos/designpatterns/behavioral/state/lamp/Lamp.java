package io.github.hhcarlos.designpatterns.behavioral.state.lamp;

import io.github.hhcarlos.designpatterns.behavioral.state.lamp.states.OffState;

import java.util.Objects;

public class Lamp {
    private LampState state;

    public Lamp() {
        this.state = new OffState();
    }

    public void pressButton() {
        this.state.press(this);
    }

    public void changeState(LampState newState) {
        this.state = Objects.requireNonNull(newState);
    }

    public LampStatus currentStatus() {
        return this.state.status();
    }
}
