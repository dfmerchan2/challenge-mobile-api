package co.com.yape.mobile.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HomePage {

    public static final Target BTN_CLOSE_MODAL_LOGIN =
            Target.the("Button search")
                    .locatedForAndroid(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_SEARCH =
            Target.the("Button search")
                    .locatedForAndroid(By.id("com.booking:id/facet_search_box_cta"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_START_SEARCH =
            Target.the("Button start search")
                    .locatedForAndroid(By.id("com.booking:id/genius_onbaording_bottomsheet_cta"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_WELCOME_MESSAGE =
            Target.the("Label welcome message")
                    .locatedForAndroid(By.id("com.booking:id/genius_onbaording_bottomsheet_title"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_NOT_ACCOMMODATION_FOUND =
            Target.the("Label no accommodation found")
                    .locatedForAndroid(By.xpath("//android.widget.LinearLayout[@resource-id='com.booking:id/informative_cta_view_price_container']//android.widget.TextView[contains (@text,'US$')]"))
                    .locatedForIOS(By.id(""));
}
