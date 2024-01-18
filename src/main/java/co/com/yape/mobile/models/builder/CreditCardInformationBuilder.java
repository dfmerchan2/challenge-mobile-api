package co.com.yape.mobile.models.builder;

import co.com.yape.mobile.models.CreditCardInformation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import static co.com.yape.mobile.utilities.Constants.faker;
import static co.com.yape.mobile.utilities.ConversionUtility.getDateCreditCard;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreditCardInformationBuilder {

    public static CreditCardInformation getCreditCardInformation() {
        return CreditCardInformation.builder()
                .numberCard(faker.number().digits(16))
                .holderName(faker.name().fullName())
                .expirationDate(getDateCreditCard())
                .build();
    }
}
