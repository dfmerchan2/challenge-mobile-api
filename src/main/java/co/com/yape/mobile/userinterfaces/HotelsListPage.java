package co.com.yape.mobile.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HotelsListPage {

    public static final Target BTN_CHOOSE_ROOM =
            Target.the("button choose room")
                    .locatedForAndroid(By.id("com.booking:id/select_room_cta"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_DESCRIPTION_BOOKING =
            Target.the("Label reservation description")
                    .locatedForAndroid(By.id("com.booking:id/price_view_stay_details"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_HOTEL_NAME =
            Target.the("Label Hotel name")
                    .locatedForAndroid(By.id("com.booking:id/property_name"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_HOTEL_PRICE =
            Target.the("Label hotel price")
                    .locatedForAndroid(By.id("com.booking:id/price_view_price"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_CHECK_IN =
            Target.the("Label date check in")
                    .locatedForAndroid(By.id("com.booking:id/checkin_display"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_CHECKOUT =
            Target.the("Label date checkout")
                    .locatedForAndroid(By.id("com.booking:id/checkout_display"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_HOTEL =
            Target.the("hotel list")
                    .locatedBy("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2+{0}]");
    public static final Target LST_HOTELS =
            Target.the("hotel list")
                    .located(By.id("com.booking:id/results_list_facet"));
    public static final Target BTN_CLOSE_BANNER =
            Target.the("Close banner button")
                    .located(By.id("com.booking:id/bui_banner_close_button"));
}
