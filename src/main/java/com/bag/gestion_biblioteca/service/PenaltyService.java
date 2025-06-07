package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.model.dto.CreatePenaltyRequest;
import com.bag.gestion_biblioteca.model.dto.PenaltyResponse;

import java.util.List;

public interface PenaltyService {

    PenaltyResponse save(CreatePenaltyRequest request);
    List<PenaltyResponse> findAll();
    PenaltyResponse findById(Long id);
    PenaltyResponse update(Long id, CreatePenaltyRequest request);
    void deleteById(Long id);
}
