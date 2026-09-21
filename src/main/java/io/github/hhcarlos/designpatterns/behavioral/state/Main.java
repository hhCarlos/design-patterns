package io.github.hhcarlos.designpatterns.behavioral.state;

import io.github.hhcarlos.designpatterns.behavioral.state.lamp.LampExample;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        System.out.println("Working with the State pattern.");

        LampExample.run();
    }
}
