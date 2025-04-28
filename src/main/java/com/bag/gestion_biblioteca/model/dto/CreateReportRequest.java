package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.util.Type;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CreateReportRequest {
    @NotNull(message = "El id del usuario no puede ser nulo.")
    private Long userId;

    @NotNull(message = "El id del libro no puede ser nulo.")
    private Long bookId;

    @NotEmpty(message = "El campo tipo  no puede ser vacío o nulo.")
    private Type Type;

    @NotEmpty(message = "El campo descripción no puede ser vacío o nulo.")
    private String description;

    @NotEmpty(message = "El campo fecha de restock no puede ser vacío o nulo.")
    private LocalDate restockDate;

    private Boolean resolved;
}
