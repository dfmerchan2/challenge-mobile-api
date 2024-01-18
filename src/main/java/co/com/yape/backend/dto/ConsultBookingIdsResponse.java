package co.com.yape.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultBookingIdsResponse {

    @JsonProperty("bookingid")
    private String bookingId;

}
