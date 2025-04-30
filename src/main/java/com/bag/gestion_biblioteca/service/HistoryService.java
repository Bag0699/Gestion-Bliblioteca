package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.model.dto.CreateHistoryRequest;
import com.bag.gestion_biblioteca.model.dto.HistoryResponse;

import java.util.List;

public interface HistoryService {

    HistoryResponse save(CreateHistoryRequest request);
    List<HistoryResponse> findAll();
    HistoryResponse findById(Long id);
    HistoryResponse update(Long id, CreateHistoryRequest request);
    void deleteById(Long id);

}
