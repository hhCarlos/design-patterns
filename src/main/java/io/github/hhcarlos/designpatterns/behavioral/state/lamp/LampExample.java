package io.github.hhcarlos.designpatterns.behavioral.state.lamp;

import io.github.hhcarlos.designpatterns.behavioral.state.lamp.states.OnState;

public class LampExample {
    public static void run() {
        Lamp lamp = new Lamp();

        System.out.println("Status before pressbutton => " + lamp.currentStatus()); // OFF

        lamp.pressButton();
        System.out.println("Status before pressbutton => " + lamp.currentStatus()); // MID

        lamp.pressButton();
        System.out.println("Status before pressbutton => " + lamp.currentStatus()); // ON

        lamp.pressButton();
        System.out.println("Status before pressbutton => " + lamp.currentStatus()); // OFF
    }
}
