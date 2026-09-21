package io.github.hhcarlos.designpatterns.behavioral.state.lamp;

public interface LampState {
    public void press(Lamp lamp);

    LampStatus status();
}
