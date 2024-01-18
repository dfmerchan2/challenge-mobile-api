package co.com.yape.mobile.interactions;

import co.com.yape.mobile.interactions.mobile.ScrollVerticalSearchElement;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.yape.mobile.userinterfaces.CalendarPage.BTN_BOOKING_DAY;
import static co.com.yape.mobile.userinterfaces.CalendarPage.BTN_SELECT_DATE;
import static co.com.yape.mobile.utilities.enums.ValueScroll.LARGE_SCROLL;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

@AllArgsConstructor
public class SelectDate implements Interaction {

    private final String checkIn;
    private final String checkOut;


    @Step("{0} Select date #checkIn and date #checkOut of the booking")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SELECT_DATE, isPresent()),
                ScrollVerticalSearchElement.with(BTN_BOOKING_DAY.of(checkIn), LARGE_SCROLL.getSize()),
                Click.on(BTN_BOOKING_DAY.of(checkIn)),
                ScrollVerticalSearchElement.with(BTN_BOOKING_DAY.of(checkOut), LARGE_SCROLL.getSize()),
                Click.on(BTN_BOOKING_DAY.of(checkOut)),
                Click.on(BTN_SELECT_DATE)
        );
    }

    public static Performable ofBooking(String checkIn, String checkOut) {
        return instrumented(SelectDate.class, checkIn, checkOut);
    }
}
