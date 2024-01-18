package co.com.yape.mobile.models.builder;

import co.com.yape.mobile.models.BookingInformation;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Map;

import static co.com.yape.mobile.utilities.Constants.MESSAGE_YOU_SELECTED;
import static co.com.yape.mobile.utilities.ConversionUtility.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingInformationBuilder {

    public static BookingInformation bookingInformation(String destination, List<Map<String, String>> data) {
        return BookingInformation.builder()
                .destination(upperCaseFirst(destination))
                .checkIn(formatDate(data.get(0).get("check In")))
                .checkOut(formatDate(data.get(0).get("check out")))
                .rooms(Integer.parseInt(data.get(0).get("rooms")))
                .adults(Integer.parseInt(data.get(0).get("adults")))
                .children(Integer.parseInt(data.get(0).get("children")))
                .childrenAge(data.get(0).get("children age"))
                .build();
    }

    public static BookingInformation getDataSummary(BookingInformation dataBooking, String hotelName, String priceHotel) {
        return BookingInformation.builder()
                .nameHotel(hotelName)
                .checkIn(formateDateCheck(dataBooking.getCheckIn()))
                .checkOut(formateDateCheck(dataBooking.getCheckOut()))
                .youSelected(String.format(MESSAGE_YOU_SELECTED, dataBooking.getAdults(), dataBooking.getChildren()))
                .priceHotel(priceHotel)
                .build();
    }
}
