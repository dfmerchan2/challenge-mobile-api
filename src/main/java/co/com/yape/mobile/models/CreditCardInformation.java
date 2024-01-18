package co.com.yape.mobile.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreditCardInformation {
    private String numberCard;
    private String holderName;
    private String expirationDate;
}
