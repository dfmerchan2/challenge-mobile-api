package co.com.yape.backend.stepdefinitions;

import co.com.yape.backend.dto.DataBooking;

import co.com.yape.backend.dto.builder.DataBookingBuilder;
import co.com.yape.backend.questions.TheMessageObtained;
import co.com.yape.backend.tasks.PostCreateBooking;
import co.com.yape.backend.tasks.TheReservationInformation;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.yape.backend.utilities.enums.ActorNotepad.CREATE_BOOKING_RESPONSE;
import static co.com.yape.backend.utilities.enums.ActorNotepad.CREATE_BOOKING_REQUEST;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR;
import static org.hamcrest.Matchers.equalTo;

public class CreateBookingStepDefinition {

    @When("{string} creates successful reservation")
    public void createsSuccessfulReservation(String actor) {
        DataBooking createBookingRequest =
                DataBookingBuilder.bookingRequest();

        theActorCalled(actor).attemptsTo(
                PostCreateBooking.with(createBookingRequest));

        theActorInTheSpotlight().remember(CREATE_BOOKING_REQUEST.getKey(), createBookingRequest);
        theActorInTheSpotlight().remember(CREATE_BOOKING_RESPONSE.getKey(), PostCreateBooking.getResponseBody());
    }

    @When("{string} sends a reservation creation request with null values")
    public void sendsAReservationCreationRequestWithNullValues(String actor) {
        DataBooking createBookingRequest =
                DataBookingBuilder.bookingRequestWithValueNull();

        theActorCalled(actor).attemptsTo(
                PostCreateBooking.with(createBookingRequest)
                        .withStatusCode(SC_INTERNAL_SERVER_ERROR));
    }

    @Then("the response should contain the information of the created reservation")
    public void theResponseShouldContainTheInformationOfTheCreatedReservation() {
        DataBooking createBookingRequest =
                theActorInTheSpotlight().recall(CREATE_BOOKING_REQUEST.getKey());

        theActorInTheSpotlight().attemptsTo(
                TheReservationInformation.areCorrect(createBookingRequest, PostCreateBooking.getResponseBody().getBooking()));
    }

    @Then("the response should have the message {string}")
    public void theResponseShouldHaveTheStatusCodeAndTheMessage(String message) {
        theActorInTheSpotlight().should(
                seeThat(TheMessageObtained.isCorrect
                        (PostCreateBooking.messageErrorResponse(), message), equalTo(true))
        );
    }

}
