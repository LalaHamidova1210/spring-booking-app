package az.turingacademy.springhotelbookingapp.domain.repository;

import az.turingacademy.springhotelbookingapp.domain.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {}

