package co.com.yape.backend.stepdefinitions;

import co.com.yape.backend.dto.DataBookingId;
import co.com.yape.backend.questions.TheMessageObtained;
import co.com.yape.backend.questions.TheReservationId;
import co.com.yape.backend.tasks.GetBooking;
import co.com.yape.backend.tasks.TheReservationInformation;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.yape.backend.utilities.enums.ActorNotepad.CREATE_BOOKING_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.equalTo;

public class ConsultBookingStepDefinition {

    @When("requests to consult the reservation by ID")
    public void requestsToConsultTheReservationByID() {
        DataBookingId createBookingResponse =
                theActorInTheSpotlight().recall(CREATE_BOOKING_RESPONSE.getKey());

        theActorInTheSpotlight().attemptsTo(
                GetBooking.inTheApplication(createBookingResponse.getBookingId())
        );
    }

    @When("consult existing reservations on the platform")
    public void consultExistingReservationsOnThePlatform() {
        theActorInTheSpotlight().attemptsTo(
                GetBooking.inTheApplication("")
        );
    }

    @When("consult the reservation with ID a non-existent")
    public void consultTheReservationWithIDANonExistentID() {
        theActorInTheSpotlight().attemptsTo(
                GetBooking.inTheApplication(Faker.instance().number().digits(10))
                        .withStatusCode(SC_NOT_FOUND)
        );
    }

    @Then("should be able to see the reservation information")
    public void shouldBeAbleToSeeTheReservationInformation() {
        DataBookingId createBookingResponse =
                theActorInTheSpotlight().recall(CREATE_BOOKING_RESPONSE.getKey());

        theActorInTheSpotlight().attemptsTo(
                TheReservationInformation.areCorrect(GetBooking.getResponseBody(), createBookingResponse.getBooking())
        );
    }

    @Then("should be able to see the id of the reservation created")
    public void shouldBeAbleToSeeTheIdOfTheReservationCreated() {
        DataBookingId createBookingResponse =
                theActorInTheSpotlight().recall(CREATE_BOOKING_RESPONSE.getKey());

        theActorInTheSpotlight().should(
                seeThat(
                        TheReservationId.isPresent(createBookingResponse),
                        is(true)
                )
        );
    }

    @Then("the response should contain the error message {string}")
    public void theResponseShouldContainTheErrorMessage(String message) {
        theActorInTheSpotlight().should(
                seeThat(TheMessageObtained.isCorrect(
                        GetBooking.messageResponse(), message), equalTo(true))
        );
    }
}
