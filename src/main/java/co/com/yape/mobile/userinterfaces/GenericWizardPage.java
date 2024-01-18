package co.com.yape.mobile.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GenericWizardPage {

    public static final Target BTN_NEXT =
            Target.the("Next button")
                    .locatedForAndroid(By.id("com.booking:id/action_button"))
                    .locatedForIOS(By.id(""));
    public static final Target LBL_PRICE_HOTEL =
            Target.the("Label price hotel")
                    .locatedForAndroid(By.xpath("//android.widget.TextView[@resource-id='com.booking:id/title' and contains (@text,'US$')]"))
                    .locatedForIOS(By.id(""));
}
