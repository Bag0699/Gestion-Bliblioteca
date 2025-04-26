package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.CategoryResponse;
import com.bag.gestion_biblioteca.model.dto.CreateCategoryRequest;
import com.bag.gestion_biblioteca.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toCategoryResponse(Category category);

    Category toCategory(CreateCategoryRequest request);
}
