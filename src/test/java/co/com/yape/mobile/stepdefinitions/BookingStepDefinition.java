package co.com.yape.mobile.stepdefinitions;

import co.com.yape.mobile.models.BookingInformation;
import co.com.yape.mobile.models.builder.BookingInformationBuilder;
import co.com.yape.mobile.models.builder.CreditCardInformationBuilder;
import co.com.yape.mobile.models.builder.UserBuilder;
import co.com.yape.mobile.tasks.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static co.com.yape.mobile.utilities.enums.ActorNotepad.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BookingStepDefinition {

    @Given("that {string} is looking for a hotel in {string} to reserve with the following information")
    public void thatIsLookingForAHotelInToReserveWithTheFollowingInformation(String actor, String destination, List<Map<String, String>> data) {
        BookingInformation bookingInformation = BookingInformationBuilder.bookingInformation(destination, data);
        theActorCalled(actor).remember(BOOKING_INFORMATION.getKey(), bookingInformation);
        theActorCalled(actor).attemptsTo(
                SearchHotel.toBooking(bookingInformation)
        );
    }

    @When("select the room from item {string} from the hotel search results")
    public void selectItemOfTheHotelSearchResults(String item) {
        theActorInTheSpotlight().attemptsTo(
                ChooseHotel.toBook(item),
                ChooseRoom.toBook()
        );
    }

    @And("add personal information in the application")
    public void enterTheRequestedPersonalData() {
        theActorInTheSpotlight().attemptsTo(
                AddPersonalInformation.inTheApplication(UserBuilder.getUser())
        );
    }

    @Then("should then be able to see the reservation summary")
    public void shouldThenBeAbleToSeeTheReservationSummary() {
        BookingInformation dataSummary = BookingInformationBuilder
                .getDataSummary(theActorInTheSpotlight().recall(BOOKING_INFORMATION.getKey()),
                        theActorInTheSpotlight().recall(HOTEL_NAME.getKey()),
                        theActorInTheSpotlight().recall(HOTEL_VALUE.getKey()));

        theActorInTheSpotlight().attemptsTo(
                ReviewBookingInformation.isCorrect(dataSummary)
        );
    }

    @And("the payment information process")
    public void thePaymentInformationProcess() {
        theActorInTheSpotlight().attemptsTo(
                AddCreditCardInformation
                        .toMakeThePayment(CreditCardInformationBuilder.getCreditCardInformation())
        );
    }

}
