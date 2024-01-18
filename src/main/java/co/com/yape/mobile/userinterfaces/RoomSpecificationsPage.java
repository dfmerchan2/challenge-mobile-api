package co.com.yape.mobile.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomSpecificationsPage {
    public static final Target BTN_APPLY =
            Target.the("Button apply")
                    .locatedForAndroid(By.id("com.booking:id/group_config_apply_button"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_DECREASE_ADULT =
            Target.the("Button decrease number of adult")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/group_config_adults_count']//*[@resource-id='com.booking:id/bui_input_stepper_remove_button']"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_DECREASE_ROOMS =
            Target.the("Button decrease number of rooms")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/group_config_rooms_count']//*[@resource-id='com.booking:id/bui_input_stepper_remove_button']"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_INCREASE_ADULTS =
            Target.the("Button increase number of adults")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/group_config_adults_count']//*[@resource-id='com.booking:id/bui_input_stepper_add_button']"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_INCREASE_CHILDREN =
            Target.the("Button increase number of children")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/group_config_children_count']//*[@resource-id='com.booking:id/bui_input_stepper_add_button']"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_INCREASE_ROOMS =
            Target.the("Button increase number of rooms")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/group_config_rooms_count']//*[@resource-id='com.booking:id/bui_input_stepper_add_button']"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_OK =
            Target.the("Button OK")
                    .locatedForAndroid(By.id("android:id/button1"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_ROOM_SPECIFICATION =
            Target.the("Button room specifications")
                    .locatedForAndroid(By.id("com.booking:id/facet_search_box_accommodation_occupancy"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_CHILD_AGE =
            Target.the("Label child age")
                    .locatedBy("//android.widget.EditText[@text='{0}']");
    public static final Target LBL_NUMBER_OF_ADULTS =
            Target.the("Label number of adults")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/group_config_adults_count']//*[@resource-id='com.booking:id/bui_input_stepper_value']"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_NUMBER_OF_CHILDREN =
            Target.the("Label number of children")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/group_config_children_count']//*[@resource-id='com.booking:id/bui_input_stepper_value']"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_NUMBER_OF_ROOMS =
            Target.the("Label number of rooms")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/group_config_rooms_count']//*[@resource-id='com.booking:id/bui_input_stepper_value']"))
                    .locatedForIOS(By.id(""));
}
