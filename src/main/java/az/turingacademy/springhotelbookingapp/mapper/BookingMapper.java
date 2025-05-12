package az.turingacademy.springhotelbookingapp.mapper;

import az.turingacademy.springhotelbookingapp.domain.entity.Booking;
import az.turingacademy.springhotelbookingapp.model.request.BookingRequest;
import az.turingacademy.springhotelbookingapp.model.response.BookingResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingMapper INSTANCE = Mappers.getMapper(BookingMapper.class);

    Booking toEntity(BookingRequest request);
    BookingResponse toResponse(Booking booking);
}


