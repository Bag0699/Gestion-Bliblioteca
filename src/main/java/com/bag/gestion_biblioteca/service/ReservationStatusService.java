package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.model.dto.CreateReservationStatusRequest;
import com.bag.gestion_biblioteca.model.dto.ReservationStatusResponse;

import java.util.List;

public interface ReservationStatusService {

    ReservationStatusResponse save(CreateReservationStatusRequest request);
    List<ReservationStatusResponse> findAll();
    ReservationStatusResponse findById(Long id);
    ReservationStatusResponse update(Long id, CreateReservationStatusRequest request);
    void deleteById(Long id);

}
