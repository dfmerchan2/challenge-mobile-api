package co.com.yape.backend.questions;

import co.com.yape.backend.dto.DataBookingId;
import co.com.yape.backend.tasks.GetBooking;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

@AllArgsConstructor
public class TheReservationId implements Question<Boolean> {

    private final DataBookingId createBookingResponse;

    @Override
    public Boolean answeredBy(Actor actor) {
        return GetBooking.getResponseBodyList()
                .stream()
                .anyMatch(i -> i.getBookingId()
                        .contains(createBookingResponse.getBookingId()));
    }

    public static TheReservationId isPresent(DataBookingId createBookingResponse) {
        return new TheReservationId(createBookingResponse);
    }
}
