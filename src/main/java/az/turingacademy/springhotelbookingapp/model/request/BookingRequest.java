package az.turingacademy.springhotelbookingapp.model.request;

import lombok.Data;

import java.util.List;
@Data
public class BookingRequest {

    private Long flightId;
    private Integer numberOfSeats;

}
