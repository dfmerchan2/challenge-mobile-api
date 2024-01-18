package co.com.yape.mobile.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditCardInformationPage {
    public static final Target TXT_CARD_NUMBER =
            Target.the("Card number text box")
                    .locatedForAndroid(By.id("com.booking:id/new_credit_card_number_edit"))
                    .locatedForIOS(By.id(""));
    public static final Target TXT_HOLDER_NAME =
            Target.the("Holder name text box")
                    .locatedForAndroid(By.id("com.booking:id/new_credit_card_holder_edit"))
                    .locatedForIOS(By.id(""));
    public static final Target TXT_EXPIRY_DATE =
            Target.the("Expiry date text box")
                    .locatedForAndroid(By.id("com.booking:id/new_credit_card_expiry_date_edit"))
                    .locatedForIOS(By.id(""));
}
