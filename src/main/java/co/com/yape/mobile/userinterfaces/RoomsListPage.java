package co.com.yape.mobile.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomsListPage {
    public static final Target BTN_RESERVE_NOW =
            Target.the("Button book now")
                    .locatedForAndroid(By.xpath("//android.widget.Button[@resource-id='com.booking:id/main_action']"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_SELECT_ROOM =
            Target.the("Button select room")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/rooms_item_select_layout' or @resource-id='com.booking:id/recommended_block_reserve_button']"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_HOTEL_VALUE =
            Target.the("Label hotel value")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/price_view_price' or @resource-id='com.booking:id/recommended_block_subtotal_price_view']"))
                    .locatedForIOS(By.id(""));
}
