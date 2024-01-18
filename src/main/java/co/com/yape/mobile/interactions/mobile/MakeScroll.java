package co.com.yape.mobile.interactions.mobile;

import co.com.yape.mobile.utilities.MyDriver;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

import static co.com.yape.mobile.utilities.Constants.FINGER;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class MakeScroll implements Interaction {

    private final int startX;
    private final int startY;
    private final int endX;
    private final int endY;

    @Step("{0} make Scroll")
    @Override
    public <T extends Actor> void performAs(T actor) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, FINGER);
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), endX, endY));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        MyDriver.getDriver().perform(List.of(sequence));
    }

    public static Performable to(int startX, int startY, int endX, int endY) {
        return instrumented(MakeScroll.class, startX, startY, endX, endY);
    }
}
