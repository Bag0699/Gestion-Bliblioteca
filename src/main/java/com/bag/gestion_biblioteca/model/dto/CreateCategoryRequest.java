package com.bag.gestion_biblioteca.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateCategoryRequest {

    @NotEmpty(message = "El campo nombre no puede ser vacío o nulo.")
    private String name;
}
