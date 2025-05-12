package az.turingacademy.springhotelbookingapp.model.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightResponse {
    private Long id;
    private String origin;
    private String destination;
    private Integer availableSeats;
    private LocalDateTime timestamp;


}
