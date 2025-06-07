package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.model.dto.BookResponse;
import com.bag.gestion_biblioteca.model.dto.CreateReadingListRequest;
import com.bag.gestion_biblioteca.model.dto.ReadingListResponse;

import java.util.List;

public interface ReadingListService {

    ReadingListResponse save(CreateReadingListRequest request);
    ReadingListResponse findById(Long id);
    List<ReadingListResponse> findAll();
    List<BookResponse> findAllByUserId(Long userId);
    void deleteById(Long id);
}
