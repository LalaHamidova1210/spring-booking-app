package az.turingacademy.springhotelbookingapp.service;

import az.turingacademy.springhotelbookingapp.domain.entity.Passenger;
import az.turingacademy.springhotelbookingapp.domain.repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}
