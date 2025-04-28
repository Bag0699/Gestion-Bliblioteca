package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.CreateReservationStatusRequest;
import com.bag.gestion_biblioteca.model.dto.ReservationStatusResponse;
import com.bag.gestion_biblioteca.model.entity.ReservationStatus;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationStatusMapper {

    ReservationStatusResponse toReservationStatusResponse(ReservationStatus reservationStatus);

    ReservationStatus toReservationStatus(CreateReservationStatusRequest request);
}
