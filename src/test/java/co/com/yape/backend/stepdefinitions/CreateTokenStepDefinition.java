package co.com.yape.backend.stepdefinitions;

import co.com.yape.backend.dto.AuthTokenRequest;
import co.com.yape.backend.dto.AuthTokenResponse;
import co.com.yape.backend.dto.builder.AuthTokenRequestBuilder;
import co.com.yape.backend.tasks.PostAuthCreateToken;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static co.com.yape.backend.utilities.enums.ActorNotepad.AUTH_TOKEN_RESPONSE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.*;

public class CreateTokenStepDefinition {

    @When("{string} login with username {string} and password {string}")
    public void logsInWithUsernameAndPassword(String actor, String user, String password) {
        AuthTokenRequest authTokenRequest =
                AuthTokenRequestBuilder.authTokenRequest(user, password);

        theActorCalled(actor).attemptsTo(
                PostAuthCreateToken.with(authTokenRequest));

        theActorCalled(actor).remember(AUTH_TOKEN_RESPONSE.getKey(), PostAuthCreateToken.getResponseBody());
    }

    @Then("should see the token generated successfully")
    public void shouldSeeTheTokenGeneratedSuccessfully() {
        AuthTokenResponse authTokenResponse =
                theActorInTheSpotlight().recall(AUTH_TOKEN_RESPONSE.getKey());

        theActorInTheSpotlight().should(
                seeThat("Validate successful token generation",
                        actorSee -> authTokenResponse.getToken(), notNullValue())
        );
    }

    @Then("should see the error message {string}")
    public void shouldSeeTheErrorMessage(String message) {
        AuthTokenResponse authTokenResponse =
                theActorInTheSpotlight().recall(AUTH_TOKEN_RESPONSE.getKey());

        theActorInTheSpotlight().should(
                seeThat("Validate incorrect credentials",
                        actorSee -> authTokenResponse.getReason(), equalTo(message)
                )
        );
    }
}