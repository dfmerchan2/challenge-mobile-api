package co.com.yape.mobile.utilities.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ActorNotepad {
    BOOKING_INFORMATION("booking information"),
    DESCRIPTION_BOOKING("description booking"),
    HOTEL_NAME("hotel name"),
    HOTEL_VALUE("hotel value"),
    USER_NAME("user name"),
    CHECK_IN("check in"),
    CHECKOUT("checkout"),
    ROOMS_GUESTS("rooms guests");

    private final String key;

}
