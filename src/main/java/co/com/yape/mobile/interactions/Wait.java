package co.com.yape.mobile.interactions;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

public class Wait implements Interaction {

    private int time;

    public Wait(int time) {
        this.time = time;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        new InternalSystemClock().pauseFor(time);
    }

    public static Wait forAbout(int time) {
        return new Wait(time);
    }

    public Wait seconds() {
        this.time = time * 1000;
        return this;
    }
}
