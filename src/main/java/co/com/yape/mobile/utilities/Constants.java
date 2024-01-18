package co.com.yape.mobile.utilities;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Locale;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final String BUSINESS = "Negocios";
    public static final String LEISURE = "Ocio";
    public static final String COLOMBIA = "COLOMBIA";
    public static final String ADDRESS = "Cra 12 #14-5";
    public static final String BOGOTA = "Bogota";
    public static final String FINGER = "finger";
    public static final String MESSAGE_YOU_SELECTED = "%s adults, %s child";
    public static final Faker faker = new Faker(new Locale("es-MX"));
}
