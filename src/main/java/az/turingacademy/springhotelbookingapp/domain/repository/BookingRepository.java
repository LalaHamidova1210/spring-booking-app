package az.turingacademy.springhotelbookingapp.domain.repository;

import az.turingacademy.springhotelbookingapp.domain.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface BookingRepository extends JpaRepository<Booking, Long> {

    }

