package az.turingacademy.test;

import az.turingacademy.springhotelbookingapp.domain.entity.Flight;
import az.turingacademy.springhotelbookingapp.service.FlightService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class FlightServiceTest {

    private FlightService flightService;

    @Test
    public void testCreateAndGetFlight() {
        Flight flight = Flight.builder()
                .origin("Baku")
                .destination("Istanbul")
                .availableSeats(120)
                .timestamp(LocalDateTime.now())
                .build();

        Flight saved = flightService.createFlight(flight);
        assertNotNull(saved.getId());

        Flight fetched = flightService.getFlightById(saved.getId());
        assertEquals("Baku", fetched.getOrigin());
    }

    @Test
    public void testGetAllFlights() {
        List flights = flightService.getAllFlights();
        assertNotNull(flights);
    }
}
