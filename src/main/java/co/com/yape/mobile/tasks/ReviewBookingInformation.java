package co.com.yape.mobile.tasks;

import co.com.yape.mobile.models.BookingInformation;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.yape.mobile.userinterfaces.GenericWizardPage.BTN_NEXT;
import static co.com.yape.mobile.userinterfaces.GenericWizardPage.LBL_PRICE_HOTEL;
import static co.com.yape.mobile.userinterfaces.SummaryPage.*;
import static co.com.yape.mobile.utilities.enums.ActorNotepad.HOTEL_VALUE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

@AllArgsConstructor
public class ReviewBookingInformation implements Task {

    private final BookingInformation dataSummary;

    @Step("{0} review the reservation summary")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LBL_NAME_HOTEL, isPresent()).forNoMoreThan(40).seconds(),
                Ensure.that(LBL_NAME_HOTEL).text().isEqualTo(dataSummary.getNameHotel()),
                Ensure.that(LB_CHECK_IN_DATE).text().isEqualTo(dataSummary.getCheckIn()),
                Ensure.that(LB_CHECKOUT_DATE).text().isEqualTo(dataSummary.getCheckOut()),
                Ensure.that(LBL_YOU_SELECTED).text().contains(dataSummary.getYouSelected()),
                Ensure.that(LBL_TOTAL).text().contains(dataSummary.getPriceHotel()),
                Ensure.that(LBL_PRICE_HOTEL).text().isEqualTo(actor.recall(HOTEL_VALUE.getKey())),
                Click.on(BTN_NEXT)
        );
    }

    public static Performable isCorrect(BookingInformation dataSummary) {
        return instrumented(ReviewBookingInformation.class, dataSummary);
    }
}
