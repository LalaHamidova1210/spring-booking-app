package az.turingacademy.springhotelbookingapp.controller;

import az.turingacademy.springhotelbookingapp.mapper.FlightMapper;
import az.turingacademy.springhotelbookingapp.model.request.FlightRequest;
import az.turingacademy.springhotelbookingapp.model.response.FlightResponse;
import az.turingacademy.springhotelbookingapp.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flights")
@RequiredArgsConstructor

public class FlightController {
    private final FlightService flightService;
    private final FlightMapper flightMapper;

    @GetMapping
    public List<FlightResponse> getAll() {
        return flightService.getAllFlights().stream().map(flightMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public FlightResponse get(@PathVariable Long id) {
        return flightMapper.toResponse(flightService.getFlightById(id));
    }

    @PostMapping
    public FlightResponse create(@RequestBody FlightRequest request) {
        return flightMapper.toResponse(flightService.createFlight(flightMapper.toEntity(request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }



}
