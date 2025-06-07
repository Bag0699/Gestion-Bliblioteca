package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.model.dto.CategoryResponse;
import com.bag.gestion_biblioteca.model.dto.CreateCategoryRequest;

import java.util.List;

public interface CategoryService {

    CategoryResponse save(CreateCategoryRequest request);
    List<CategoryResponse> findAll();
    CategoryResponse findById(Long id);
    CategoryResponse update(Long id, CreateCategoryRequest request);
    void deleteById(Long id);
}
