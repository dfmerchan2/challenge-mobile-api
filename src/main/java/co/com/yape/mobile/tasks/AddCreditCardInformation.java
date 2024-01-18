package co.com.yape.mobile.tasks;

import co.com.yape.mobile.models.CreditCardInformation;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.yape.mobile.userinterfaces.CreditCardInformationPage.*;
import static co.com.yape.mobile.userinterfaces.GenericWizardPage.LBL_PRICE_HOTEL;
import static co.com.yape.mobile.utilities.enums.ActorNotepad.HOTEL_VALUE;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

@AllArgsConstructor
public class AddCreditCardInformation implements Task {

    private final CreditCardInformation creditCardInformation;

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_CARD_NUMBER, isPresent()).forNoMoreThan(40).seconds(),
                Enter.keyValues(creditCardInformation.getNumberCard()).into(TXT_CARD_NUMBER),
                Enter.keyValues(creditCardInformation.getHolderName()).into(TXT_HOLDER_NAME),
                Enter.keyValues(creditCardInformation.getExpirationDate()).into(TXT_EXPIRY_DATE),
                Ensure.that(LBL_PRICE_HOTEL).text().isEqualTo(actor.recall(HOTEL_VALUE.getKey()))
        );
    }

    public static Performable toMakeThePayment(CreditCardInformation creditCardInformation) {
        return instrumented(AddCreditCardInformation.class, creditCardInformation);
    }
}
