package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.model.dto.BookResponse;
import com.bag.gestion_biblioteca.model.dto.CreateReservationRequest;
import com.bag.gestion_biblioteca.model.dto.ReservationResponse;
import com.bag.gestion_biblioteca.model.dto.UserResponse;

import java.util.List;

public interface ReservationService {

    ReservationResponse save(CreateReservationRequest request);
    List<ReservationResponse> findAll();
}
