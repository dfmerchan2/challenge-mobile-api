package co.com.yape.mobile.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CalendarPage {

    public static final Target BTN_BOOKING_DAY =
            Target.the("Button reservation day")
                    .locatedBy("//android.view.View[@content-desc='{0}']");
    public static final Target BTN_SELECT_DATE =
            Target.the("Button select date")
                    .locatedForAndroid(By.id("com.booking:id/facet_date_picker_confirm"))
                    .locatedForIOS(By.id(""));
}
