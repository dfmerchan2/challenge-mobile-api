package co.com.yape.mobile.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingInformation {
    private String destination;
    private String checkIn;
    private String checkOut;
    private int rooms;
    private int adults;
    private int children;
    private String childrenAge;
    private String nameHotel;
    private String priceHotel;
    private String youSelected;
}
