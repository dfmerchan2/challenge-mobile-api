package co.com.yape.backend.dto.builder;

import co.com.yape.backend.dto.BookingDates;
import co.com.yape.backend.dto.DataBooking;
import co.com.yape.backend.dto.DataBookingId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import static co.com.yape.backend.utilities.Constants.FORMAT_DATE;
import static co.com.yape.backend.utilities.ConversionUtility.*;
import static co.com.yape.mobile.utilities.Constants.faker;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class DataBookingBuilder {

    public static DataBooking bookingRequest() {
        return DataBooking.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .totalPrice(Integer.parseInt(faker.number().digits(3)))
                .depositPaid(true)
                .bookingDates(
                        BookingDates.builder()
                                .checkIn(getCurrentDateFormatted(FORMAT_DATE))
                                .checkOut(getFutureOrPastDate(FORMAT_DATE, 5))
                                .build())
                .additionalNeeds("Breakfast")
                .build();
    }

    public static DataBooking bookingRequestWithValueNull() {
        return DataBooking.builder()
                .firstName(null)
                .lastName(null)
                .totalPrice(Integer.parseInt(faker.number().digits(3)))
                .depositPaid(true)
                .bookingDates(
                        BookingDates.builder()
                                .checkIn(getCurrentDateFormatted(FORMAT_DATE))
                                .checkOut(getFutureOrPastDate(FORMAT_DATE, 5))
                                .build())
                .additionalNeeds("Breakfast")
                .build();
    }

    public static DataBooking patchBookingRequest(DataBookingId dataBookingId) {
        return DataBooking.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .totalPrice(dataBookingId.getBooking().getTotalPrice())
                .depositPaid(dataBookingId.getBooking().isDepositPaid())
                .bookingDates(
                        BookingDates.builder()
                                .checkIn(dataBookingId.getBooking().getBookingDates().getCheckIn())
                                .checkOut(dataBookingId.getBooking().getBookingDates().getCheckOut())
                                .build())
                .additionalNeeds(dataBookingId.getBooking().getAdditionalNeeds())
                .build();
    }

}
