package az.turingacademy.springhotelbookingapp.mapper;

import az.turingacademy.springhotelbookingapp.domain.entity.Passenger;
import az.turingacademy.springhotelbookingapp.model.request.PassengerRequest;
import az.turingacademy.springhotelbookingapp.model.response.PassengerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    PassengerMapper INSTANCE = Mappers.getMapper(PassengerMapper.class);

    Passenger toEntity(PassengerRequest request);
    PassengerResponse toResponse(Passenger passenger);
}
