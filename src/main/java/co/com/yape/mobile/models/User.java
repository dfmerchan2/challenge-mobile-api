package co.com.yape.mobile.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private String name;
    private String lastName;
    private String email;
    private String address;
    private String codePostal;
    private String city;
    private String country;
    private String phone;
    private String reasonTrip;
}
