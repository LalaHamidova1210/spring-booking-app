package az.turingacademy.springhotelbookingapp.model.response;

import lombok.Data;

import java.util.List;
@Data
public class BookingResponse {

    private Long id;
    private Long flightId;
    private Integer numberOfSeats;

}
