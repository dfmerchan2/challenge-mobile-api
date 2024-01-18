package co.com.yape.mobile.tasks;

import co.com.yape.mobile.interactions.Wait;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.yape.mobile.userinterfaces.HotelsListPage.*;
import static co.com.yape.mobile.utilities.enums.ActorNotepad.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

@AllArgsConstructor
public class ChooseHotel implements Task {

    private final String item;

    @Step("{0} select the hotel from the record number #item")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LST_HOTELS, isPresent()),
                Wait.forAbout(1),
                Check.whether(BTN_CLOSE_BANNER.resolveFor(actor).isPresent())
                        .andIfSo(MoveMouse.to(BTN_CLOSE_BANNER),
                                Click.on(BTN_CLOSE_BANNER)),
                WaitUntil.the(BTN_HOTEL.of(item), isPresent()),
                Click.on(BTN_HOTEL.of(item)),
                WaitUntil.the(LBL_HOTEL_NAME, isPresent()));
        actor.remember(HOTEL_NAME.getKey(), LBL_HOTEL_NAME.resolveFor(actor).getText());
        actor.remember(DESCRIPTION_BOOKING.getKey(), LBL_DESCRIPTION_BOOKING.resolveFor(actor).getText());
        actor.remember(HOTEL_VALUE.getKey(), LBL_HOTEL_PRICE.resolveFor(actor).getText());
        actor.remember(CHECK_IN.getKey(), LBL_CHECK_IN.resolveFor(actor).getText());
        actor.remember(CHECKOUT.getKey(), LBL_CHECKOUT.resolveFor(actor).getText());
        actor.attemptsTo(Click.on(BTN_CHOOSE_ROOM));
    }

    public static Performable toBook(String item) {
        return instrumented(ChooseHotel.class, item);
    }
}
