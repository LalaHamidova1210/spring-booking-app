package az.turingacademy.springhotelbookingapp.controller;

import az.turingacademy.springhotelbookingapp.mapper.PassengerMapper;
import az.turingacademy.springhotelbookingapp.model.request.PassengerRequest;
import az.turingacademy.springhotelbookingapp.model.response.PassengerResponse;
import az.turingacademy.springhotelbookingapp.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/passengers")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;
    private final PassengerMapper passengerMapper;

    @PostMapping
    public PassengerResponse create(@RequestBody PassengerRequest request) {
        return passengerMapper.toResponse(passengerService.createPassenger(passengerMapper.toEntity(request)));
    }

    @GetMapping
    public List<PassengerResponse> getAll() {
        return passengerService.getAllPassengers().stream().map(passengerMapper::toResponse).collect(Collectors.toList());
    }

}
