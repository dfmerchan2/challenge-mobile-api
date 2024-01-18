package co.com.yape.mobile.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DestinationPlacePage {
    public static final Target BTN_SEARCH_DESTINATION =
            Target.the("Button search destination")
                    .locatedForAndroid(By.id("com.booking:id/facet_search_box_basic_field_label"))
                    .locatedForIOS(By.id(""));
    public static final Target TXT_DESTINATION =
            Target.the("Text box destination")
                    .locatedForAndroid(By.id("com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content"))
                    .locatedForIOS(By.id(""));
    public static final Target LST_DESTINATION =
            Target.the("Destination list")
                    .locatedBy("//android.widget.TextView[@text='{0}']");
}