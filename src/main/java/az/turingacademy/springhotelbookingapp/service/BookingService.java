package az.turingacademy.springhotelbookingapp.service;

import az.turingacademy.springhotelbookingapp.domain.entity.Booking;
import az.turingacademy.springhotelbookingapp.domain.entity.Flight;
import az.turingacademy.springhotelbookingapp.domain.repository.BookingRepository;
import az.turingacademy.springhotelbookingapp.domain.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;

    public Booking createBooking(Booking booking) {
        Flight flight = flightRepository.findById(booking.getFlightId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException("Flight not found"));
        if (flight.getAvailableSeats() < booking.getNumberOfSeats()) {
            throw new IllegalArgumentException("Not enough seats available");
        }
        flight.setAvailableSeats(flight.getAvailableSeats() - booking.getNumberOfSeats());
        flightRepository.save(flight);
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id).orElseThrow(() -> new ChangeSetPersister.NotFoundException("Booking not found"));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);


    }
}
