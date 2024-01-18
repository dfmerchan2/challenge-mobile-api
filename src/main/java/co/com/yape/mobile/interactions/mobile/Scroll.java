package co.com.yape.mobile.interactions.mobile;

import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.thucydides.core.annotations.Step;

import static co.com.yape.mobile.utilities.ScreenSpecifications.getHeightSizeScreen;
import static co.com.yape.mobile.utilities.ScreenSpecifications.getWidthSizeScreen;
import static co.com.yape.mobile.utilities.enums.ValueScroll.LARGE_SCROLL;
import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class Scroll implements Interaction {

    private final int scrollSize;

    @Step("{0} scroll vertically on the screen")
    @Override
    public <T extends Actor> void performAs(T actor) {

        int startX = getWidthSizeScreen(LARGE_SCROLL.getSize());
        int startY = getHeightSizeScreen(LARGE_SCROLL.getSize());
        int endY = startY - scrollSize;
        int endX = startX;

        actor.attemptsTo(
                MakeScroll.to(startX, startY, endX, endY));
    }

    public static Performable verticalFromCenter(int scrollSize) {
        return instrumented(Scroll.class, scrollSize);
    }

}
