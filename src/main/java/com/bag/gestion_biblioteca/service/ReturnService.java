package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.model.dto.CreateReturnRequest;
import com.bag.gestion_biblioteca.model.dto.ReturnResponse;

import java.util.List;

public interface ReturnService {

    ReturnResponse save(CreateReturnRequest request);
    List<ReturnResponse> findAll();
    ReturnResponse findById(Long id);
    ReturnResponse update(Long id, CreateReturnRequest request);
    void deleteById(Long id);
}
