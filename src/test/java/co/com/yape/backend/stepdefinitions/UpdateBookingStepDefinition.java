package co.com.yape.backend.stepdefinitions;

import co.com.yape.backend.dto.DataBooking;
import co.com.yape.backend.dto.DataBookingId;
import co.com.yape.backend.dto.builder.DataBookingBuilder;
import co.com.yape.backend.questions.TheMessageObtained;
import co.com.yape.backend.tasks.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.yape.backend.utilities.enums.ActorNotepad.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;

public class UpdateBookingStepDefinition {

    @When("update the information of a reservation created")
    public void updateTheInformationOfAReservationCreated() {
        DataBookingId createBookingResponse =
                theActorInTheSpotlight().recall(CREATE_BOOKING_RESPONSE.getKey());

        DataBooking updateBookingRequest =
                DataBookingBuilder.bookingRequest();

        theActorInTheSpotlight().attemptsTo(
                PutBooking.with(createBookingResponse.getBookingId(), updateBookingRequest));

        theActorInTheSpotlight().remember(UPDATE_BOOKING_REQUEST.getKey(), updateBookingRequest);
    }

    @When("to update information for a non-existing reservation")
    public void toUpdateInformationForANonExistingReservation() {
        DataBooking updateBookingRequest =
                DataBookingBuilder.bookingRequest();

        theActorInTheSpotlight().attemptsTo(
                PutBooking.with(Faker.instance().number().digits(10), updateBookingRequest)
                        .withStatusCode(SC_METHOD_NOT_ALLOWED));
    }

    @When("to update reservation information without sending the ID")
    public void toUpdateReservationInformationWithoutSendingTheID() {
        DataBooking updateBookingRequest =
                DataBookingBuilder.bookingRequest();

        theActorInTheSpotlight().attemptsTo(
                PutBooking.with("", updateBookingRequest)
                        .withStatusCode(SC_NOT_FOUND));
    }

    @When("to update reservation information by sending null values")
    public void toUpdateReservationInformationBySendingNullValues() {
        DataBookingId createBookingResponse =
                theActorInTheSpotlight().recall(CREATE_BOOKING_RESPONSE.getKey());

        DataBooking updateBookingRequest =
                DataBookingBuilder.bookingRequestWithValueNull();

        theActorInTheSpotlight().attemptsTo(
                PutBooking.with(createBookingResponse.getBookingId(), updateBookingRequest)
                        .withStatusCode(SC_BAD_REQUEST));
    }

    @Then("the response must contain the new reservation information")
    public void theResponseMustContainTheNewReservationInformation() {
        DataBooking updateBookingRequest =
                theActorInTheSpotlight().recall(UPDATE_BOOKING_REQUEST.getKey());

        theActorInTheSpotlight().attemptsTo(
                TheReservationInformation.areCorrect(updateBookingRequest, PutBooking.getResponseBody())
        );
    }

    @Then("the service response should have the message {string}")
    public void theServiceResponseShouldHaveTheMessage(String message) {
        theActorInTheSpotlight().should(
                seeThat(TheMessageObtained.isCorrect(
                        PutBooking.messageErrorResponse(), message), equalTo(true))
        );
    }

}
