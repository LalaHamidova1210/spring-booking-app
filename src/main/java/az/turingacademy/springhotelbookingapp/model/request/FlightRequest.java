package az.turingacademy.springhotelbookingapp.model.request;
import lombok.Data;

import java.time.LocalDateTime;

@Data

public class FlightRequest {
    private String origin;
    private String destination;
    private Integer availableSeats;
    private LocalDateTime timestamp;

}
