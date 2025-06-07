package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.model.dto.BookResponse;
import com.bag.gestion_biblioteca.model.dto.CreateReservationDetailRequest;
import com.bag.gestion_biblioteca.model.dto.ReservationDetailResponse;

import java.util.List;

public interface ReservationDetailService {

    ReservationDetailResponse save(CreateReservationDetailRequest request);
    List<BookResponse> findAllByReservationId(Long reservationId);
    List<ReservationDetailResponse> findAll();
}
