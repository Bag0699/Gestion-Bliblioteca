package com.bag.gestion_biblioteca.controller;

import com.bag.gestion_biblioteca.model.dto.CategoryResponse;
import com.bag.gestion_biblioteca.model.dto.CreateCategoryRequest;
import com.bag.gestion_biblioteca.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@Valid
                                                 @RequestBody
                                                 CreateCategoryRequest request) {

        CategoryResponse category = categoryService.save(request);
        return ResponseEntity.created(URI.create("/api/categories/" + category.getId()))
                .body(category);
    }

    @GetMapping
    public List<CategoryResponse> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable Long id) {
        return categoryService.findById(id);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(@PathVariable Long id,
                                   @Valid
                                   @RequestBody CreateCategoryRequest request) {

        return categoryService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
    }
}
