package az.turingacademy.springhotelbookingapp.service;

import az.turingacademy.springhotelbookingapp.domain.entity.Flight;
import az.turingacademy.springhotelbookingapp.domain.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException("Flight not found"));
    }

    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
