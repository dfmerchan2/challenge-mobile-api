package co.com.yape.mobile.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SummaryPage {

    public static final Target LBL_NAME_HOTEL =
            Target.the("Label name hotel")
                    .locatedForAndroid(By.id("com.booking:id/bp_overview_hotelname"))
                    .locatedForIOS(By.id(""));
    public static final Target LB_CHECK_IN_DATE =
            Target.the("Label check in  date")
                    .locatedForAndroid(By.id("com.booking:id/checkin_date"))
                    .locatedForIOS(By.id(""));
    public static final Target LB_CHECKOUT_DATE =
            Target.the("Label checkout date")
                    .locatedForAndroid(By.id("com.booking:id/checkout_date"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_YOU_SELECTED =
            Target.the("Label you selected")
                    .locatedForAndroid(By.xpath("//android.widget.LinearLayout[@resource-id='com.booking:id/header_container']//android.widget.TextView[@resource-id='com.booking:id/subtitle']"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_TOTAL =
            Target.the("Label value total")
                    .locatedForAndroid(By.id("com.booking:id/bp_price_summary_total_price_value"))
                    .locatedForIOS(By.id(""));
}
