package co.com.yape.mobile.models.builder;

import co.com.yape.mobile.models.User;
import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import static co.com.yape.mobile.utilities.Constants.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserBuilder {

    public static User getUser(){
        return User.builder()
                .name(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .address(ADDRESS)
                .codePostal(faker.number().digits(5))
                .city(BOGOTA)
                .country(COLOMBIA)
                .phone(faker.number().digits(10))
                .reasonTrip(getReasonTrip())
                .build();
    }

    private static String getReasonTrip() {
        String[] reasonTrip = {BUSINESS, LEISURE};
        int value = Faker.instance().random().nextInt(reasonTrip.length);
        return reasonTrip[value];
    }
}
