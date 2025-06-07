package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.model.dto.BookResponse;
import com.bag.gestion_biblioteca.model.dto.CreateBookRequest;

import java.util.List;

public interface BookService {

    BookResponse save(CreateBookRequest request);
    List<BookResponse> findAll();
    BookResponse findById(Long id);
    BookResponse update(Long id, CreateBookRequest request);
    void deleteById(Long id);
}
