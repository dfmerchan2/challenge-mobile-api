package co.com.yape.mobile.interactions;

import co.com.yape.mobile.interactions.mobile.ScrollVerticalSearchElement;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.thucydides.core.annotations.Step;

import static co.com.yape.mobile.userinterfaces.RoomSpecificationsPage.*;
import static co.com.yape.mobile.utilities.enums.ValueScroll.MEDIUM_SCROLL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class SelectQuantityChildren implements Interaction {

    private final int quantityChildren;
    private final String ageChildren;

    @Step("{0} select the number of #quantityChildren children to reserve")
    @Override
    public <T extends Actor> void performAs(T actor) {
        int currentNumberChildren = Integer.parseInt(LBL_NUMBER_OF_CHILDREN.resolveFor(actor).getText());

        while (currentNumberChildren != quantityChildren) {
            actor.attemptsTo(
                    Check.whether(currentNumberChildren < quantityChildren).andIfSo(
                            Click.on(BTN_INCREASE_CHILDREN),
                            ScrollVerticalSearchElement.with(LBL_CHILD_AGE.of(ageChildren), MEDIUM_SCROLL.getSize()),
                            Click.on(LBL_CHILD_AGE.of(ageChildren)),
                            Click.on(BTN_OK)
                    ).otherwise(
                            Click.on(BTN_DECREASE_ROOMS)
                    )
            );
            currentNumberChildren = Integer.parseInt(LBL_NUMBER_OF_CHILDREN.resolveFor(actor).getText());
        }
    }

    public static Performable toBook(int quantityChildren, String ageChildren) {
        return instrumented(SelectQuantityChildren.class, quantityChildren, ageChildren);
    }
}
