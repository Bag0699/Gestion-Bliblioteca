package com.bag.gestion_biblioteca.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CreateHistoryRequest {

    @NotNull(message = "El id del usuario no puede ser nulo.")
    private Long userId;

    @NotNull(message = "El id del libro no puede ser nulo.")
    private Long bookId;

    private String activity;

    @NotEmpty(message = "El campo fecha no puede ser vacío o nulo.")
    private LocalDate date;

    private String details;

}
