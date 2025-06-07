package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.model.entity.Author;
import com.bag.gestion_biblioteca.model.entity.Category;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookResponse {
    private Long id;
    private String title;
    private String description;
    private Boolean available;
    private Integer quantity;
    private Category category;
    private Author author;
}
