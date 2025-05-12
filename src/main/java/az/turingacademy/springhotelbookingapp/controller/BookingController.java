package az.turingacademy.springhotelbookingapp.controller;

import az.turingacademy.springhotelbookingapp.mapper.BookingMapper;
import az.turingacademy.springhotelbookingapp.model.request.BookingRequest;
import az.turingacademy.springhotelbookingapp.model.response.BookingResponse;
import az.turingacademy.springhotelbookingapp.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
    private final BookingMapper bookingMapper;

    @PostMapping
    public BookingResponse create(@RequestBody BookingRequest request) {
        return bookingMapper.toResponse(bookingService.createBooking(bookingMapper.toEntity(request)));
    }

    @GetMapping
    public List<BookingResponse> getAll() {
        return bookingService.getAllBookings().stream().map(bookingMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public BookingResponse get(@PathVariable Long id) {
        return bookingMapper.toResponse(bookingService.getBookingById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }

}
