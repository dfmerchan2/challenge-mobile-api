package co.com.yape.mobile.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.yape.mobile.userinterfaces.DestinationPlacePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

@AllArgsConstructor
public class SelectDestination implements Interaction {

    private final String destination;

    @Step("{0} select #destination as destination to book")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_SEARCH_DESTINATION, isPresent()),
                Click.on(BTN_SEARCH_DESTINATION),
                WaitUntil.the(TXT_DESTINATION, isEnabled()),
                Enter.keyValues(destination).into(TXT_DESTINATION),
                WaitUntil.the(LST_DESTINATION.of(destination), isPresent()),
                Click.on(LST_DESTINATION.of(destination)));
    }

    public static Performable ofBooking(String destination) {
        return instrumented(SelectDestination.class, destination);
    }
}
