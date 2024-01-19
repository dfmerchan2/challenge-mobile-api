package co.com.yape.mobile.tasks;

import co.com.yape.mobile.interactions.Wait;
import co.com.yape.mobile.interactions.mobile.ScrollVerticalSearchElement;
import co.com.yape.mobile.models.User;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.yape.mobile.userinterfaces.GenericWizardPage.BTN_NEXT;
import static co.com.yape.mobile.userinterfaces.GenericWizardPage.LBL_PRICE_HOTEL;
import static co.com.yape.mobile.userinterfaces.PersonalInformationPage.*;
import static co.com.yape.mobile.utilities.Constants.BUSINESS;
import static co.com.yape.mobile.utilities.enums.ActorNotepad.HOTEL_VALUE;
import static co.com.yape.mobile.utilities.enums.ValueScroll.LARGE_SCROLL;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

@AllArgsConstructor
public class AddPersonalInformation implements Task {

    private final User user;

    @Step("{0} add the requested information")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_NAME, isEnabled()).forNoMoreThan(40).seconds(),
                Wait.forAbout(1).seconds(),
                Enter.keyValues(user.getName()).into(TXT_NAME),
                Enter.keyValues(user.getLastName()).into(TXT_LAST_NAME),
                Enter.keyValues(user.getEmail()).into(TXT_EMAIL),
                ScrollVerticalSearchElement.with(BTN_BUSINESS, LARGE_SCROLL.getSize()));
        actor.attemptsTo(
                Check.whether(TXT_ADDRESS.resolveFor(actor).isVisible())
                        .andIfSo(Enter.keyValues(user.getAddress()).into(TXT_ADDRESS)),
                Check.whether(TXT_CODE_POSTAL.resolveFor(actor).isVisible())
                        .andIfSo(Enter.keyValues(user.getCodePostal()).into(TXT_CODE_POSTAL)),
                Check.whether(TXT_CITY.resolveFor(actor).isVisible())
                        .andIfSo(Enter.keyValues(user.getCity()).into(TXT_CITY)),
                Clear.field(TXT_COUNTRY),
                Enter.keyValues(user.getCountry()).into(TXT_COUNTRY),
                Enter.keyValues(user.getPhone()).into(TXT_PHONE),
                Check.whether(user.getReasonTrip().equals(BUSINESS))
                        .andIfSo(Click.on(BTN_BUSINESS))
                        .otherwise(Click.on(BTN_LEISURE)),
                Ensure.that(LBL_PRICE_HOTEL).text().isEqualTo(actor.recall(HOTEL_VALUE.getKey())),
                Click.on(BTN_NEXT)
        );
    }

    public static Performable inTheApplication(User user) {
        return instrumented(AddPersonalInformation.class, user);
    }
}
