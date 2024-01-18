package co.com.yape.mobile.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonalInformationPage {
    public static final Target TXT_NAME =
            Target.the("Name text box")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/bstage1_contact_firstname_value']//*[@resource-id='com.booking:id/bui_input_container_content']"))
                    .locatedForIOS(By.id("Name text box"));
    public static final Target TXT_LAST_NAME =
            Target.the("Last name text box")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/bstage1_contact_lastname_value']//*[@resource-id='com.booking:id/bui_input_container_content']"))
                    .locatedForIOS(By.id(""));
    public static final Target TXT_EMAIL =
            Target.the("Email text box")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/bstage1_contact_email_value']//*[@resource-id='com.booking:id/bui_input_container_content']"))
                    .locatedForIOS(By.id(""));
    public static final Target TXT_ADDRESS =
            Target.the("Address text box")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/bstage1_contact_address_value']//*[@resource-id='com.booking:id/bui_input_container_content']"))
                    .locatedForIOS(By.id(""));
    public static final Target TXT_CODE_POSTAL =
            Target.the("Code postal text box")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/bstage1_contact_zipcode_value']//*[@resource-id='com.booking:id/bui_input_container_content']"))
                    .locatedForIOS(By.id(""));
    public static final Target TXT_CITY =
            Target.the("City text box")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/bstage1_contact_city_value']//*[@resource-id='com.booking:id/bui_input_container_content']"))
                    .locatedForIOS(By.id(""));
    public static final Target TXT_COUNTRY =
            Target.the("Country text box")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/bstage1_contact_country_value']//*[@resource-id='com.booking:id/bui_input_container_content']"))
                    .locatedForIOS(By.id(""));
    public static final Target TXT_PHONE =
            Target.the("Phone text box")
                    .locatedForAndroid(By.xpath("//*[@resource-id='com.booking:id/bstage1_contact_telephone_value']//*[@resource-id='com.booking:id/bui_input_container_content']"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_BUSINESS =
            Target.the("Business button")
                    .locatedForAndroid(By.id("com.booking:id/business_purpose_business"))
                    .locatedForIOS(By.id(""));
    public static final Target BTN_LEISURE =
            Target.the("Business leisure")
                    .locatedForAndroid(By.id("com.booking:id/business_purpose_leisure"))
                    .locatedForIOS(By.id(""));
}
