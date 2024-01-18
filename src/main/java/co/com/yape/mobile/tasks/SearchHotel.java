package co.com.yape.mobile.tasks;

import co.com.yape.mobile.interactions.*;
import co.com.yape.mobile.models.BookingInformation;
import co.com.yape.mobile.userinterfaces.RoomSpecificationsPage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.yape.mobile.userinterfaces.HomePage.BTN_CLOSE_MODAL_LOGIN;
import static co.com.yape.mobile.userinterfaces.HomePage.BTN_SEARCH;
import static co.com.yape.mobile.userinterfaces.RoomSpecificationsPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;

@AllArgsConstructor
public class SearchHotel implements Task {

    private final BookingInformation bookingInformation;

    @Step("{0} Enter the information to search for accommodation")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_CLOSE_MODAL_LOGIN, isPresent()),
                Click.on(BTN_CLOSE_MODAL_LOGIN),
                SelectDestination.ofBooking(bookingInformation.getDestination()),
                SelectDate.ofBooking(bookingInformation.getCheckIn(), bookingInformation.getCheckOut()),
                Click.on(RoomSpecificationsPage.BTN_ROOM_SPECIFICATION),
                SelectQuantity.ofRooms(bookingInformation.getRooms(), BTN_INCREASE_ROOMS, BTN_DECREASE_ROOMS, LBL_NUMBER_OF_ROOMS),
                SelectQuantity.ofAdults(bookingInformation.getAdults(), BTN_INCREASE_ADULTS, BTN_DECREASE_ADULT, LBL_NUMBER_OF_ADULTS),
                SelectQuantityChildren.toBook(bookingInformation.getChildren(), bookingInformation.getChildrenAge()),
                Click.on(BTN_APPLY),
                Click.on(BTN_SEARCH)
        );
    }

    public static Performable toBooking(BookingInformation bookingInformation) {
        return instrumented(SearchHotel.class, bookingInformation);
    }
}
