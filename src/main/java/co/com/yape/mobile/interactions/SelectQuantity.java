package co.com.yape.mobile.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

@AllArgsConstructor
public class SelectQuantity implements Interaction {

    private final int quantity;
    private final Target increaseValue;
    private final Target decreaseValue;
    private final Target currentItemValue;

    @Step("{0} select the number of #quantityAdults adults to reserve")
    @Override
    public <T extends Actor> void performAs(T actor) {
        int currentNumberAdults = Integer.parseInt(currentItemValue.resolveFor(actor).getText());

        while (currentNumberAdults != quantity) {
            actor.attemptsTo(
                    WaitUntil.the(currentItemValue, isPresent()),
                    Check.whether(currentNumberAdults < quantity)
                            .andIfSo(
                                    Click.on(increaseValue)
                            ).otherwise(
                                    Click.on(decreaseValue)
                            )
            );
            currentNumberAdults = Integer.parseInt(currentItemValue.resolveFor(actor).getText());
        }
    }

    public static Performable ofAdults(int quantity, Target increaseValue, Target decreaseValue, Target currentItemValue) {
        return instrumented(SelectQuantity.class, quantity, increaseValue, decreaseValue, currentItemValue);
    }

    public static Performable ofRooms(int quantity, Target increaseValue, Target decreaseValue, Target currentItemValue) {
        return instrumented(SelectQuantity.class, quantity, increaseValue, decreaseValue, currentItemValue);
    }
}
