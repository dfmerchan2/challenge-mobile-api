package co.com.yape.mobile.tasks;

import co.com.yape.mobile.interactions.Wait;
import co.com.yape.mobile.interactions.mobile.ScrollVerticalSearchElement;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static co.com.yape.mobile.userinterfaces.RoomsListPage.*;
import static co.com.yape.mobile.utilities.enums.ActorNotepad.HOTEL_VALUE;
import static co.com.yape.mobile.utilities.enums.ValueScroll.LARGE_SCROLL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ChooseRoom implements Task {

    @Step("{0} Select the first room")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                ScrollVerticalSearchElement.with(BTN_SELECT_ROOM, LARGE_SCROLL.getSize()),
                Ensure.that(LBL_HOTEL_VALUE).text().isEqualTo(actor.recall(HOTEL_VALUE.getKey())),
                Click.on(BTN_SELECT_ROOM),
                Wait.forAbout(2));
        actor.attemptsTo(
                Check.whether(BTN_RESERVE_NOW.resolveFor(actor).isPresent())
                        .andIfSo(
                                MoveMouse.to(BTN_RESERVE_NOW),
                                Click.on(BTN_RESERVE_NOW)
                        )
        );
    }

    public static Performable toBook() {
        return instrumented(ChooseRoom.class);
    }
}
