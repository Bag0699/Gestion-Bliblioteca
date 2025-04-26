package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.CreateReservationRequest;
import com.bag.gestion_biblioteca.model.dto.ReservationResponse;
import com.bag.gestion_biblioteca.model.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(target = "reservationDate", expression = "java(mapFormatReservationDate(reservation))")
    @Mapping(target = "returnDate", expression = "java(mapFormatReturnDate(reservation))")
    ReservationResponse toReservationResponse(Reservation reservation);

    Reservation toReservation(CreateReservationRequest request);

    default String mapFormatReservationDate(Reservation reservation) {
        return reservation
                .getReservationDate()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    default String mapFormatReturnDate(Reservation reservation) {
        return reservation
                .getReturnDate()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
