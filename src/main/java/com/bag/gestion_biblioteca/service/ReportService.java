package com.bag.gestion_biblioteca.service;


import com.bag.gestion_biblioteca.model.dto.CreateReportRequest;
import com.bag.gestion_biblioteca.model.dto.ReportResponse;

import java.util.List;

public interface ReportService {

    ReportResponse save(CreateReportRequest request);
    List<ReportResponse> findAll();
    ReportResponse findById(Long id);
    ReportResponse update(Long id, CreateReportRequest request);
    void deleteById(Long id);
}
