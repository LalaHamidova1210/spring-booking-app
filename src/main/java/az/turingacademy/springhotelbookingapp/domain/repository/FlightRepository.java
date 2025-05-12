package az.turingacademy.springhotelbookingapp.domain.repository;


import az.turingacademy.springhotelbookingapp.domain.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {}


