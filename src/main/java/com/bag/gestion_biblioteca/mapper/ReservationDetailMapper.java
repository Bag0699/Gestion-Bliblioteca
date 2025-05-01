package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.CreateReservationDetailRequest;
import com.bag.gestion_biblioteca.model.dto.ReservationDetailResponse;
import com.bag.gestion_biblioteca.model.entity.ReservationDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ReservationMapper.class, BookMapper.class})
public interface ReservationDetailMapper {

    ReservationDetailResponse toReservationDetailResponse(ReservationDetail reservationDetail);

    ReservationDetail toReservationDetail(CreateReservationDetailRequest request);
}
