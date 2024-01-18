package co.com.yape.mobile.runner;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/mobile/Booking.feature",
        plugin = {"pretty", "summary"},
        glue = "co.com.yape.mobile.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class BookingRunner {

}
