package az.turingacademy.springhotelbookingapp.mapper;

import az.turingacademy.springhotelbookingapp.domain.entity.Flight;
import az.turingacademy.springhotelbookingapp.model.request.FlightRequest;
import az.turingacademy.springhotelbookingapp.model.response.FlightResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FlightMapper {
    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);

    Flight toEntity(FlightRequest request);
    FlightResponse toResponse(Flight flight);
}


