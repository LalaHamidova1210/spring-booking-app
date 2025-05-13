package az.turingacademy.tests;

import az.turingacademy.springhotelbookingapp.domain.entity.Flight;
import az.turingacademy.springhotelbookingapp.service.FlightService;
import org.junit.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;


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
        List<Flight> flights = flightService.getAllFlights();
        assertNotNull(flights);
    }
}