package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.util.Status;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CreateReturnRequest {

    @NotNull(message = "El id de la reservación no puede ser nulo.")
    private Long idReservation;

    @NotEmpty(message = "El campo fecha no puede ser vacío o nulo.")
    private LocalDate date;

    @NotEmpty(message = "El campo estado no puede ser vacío o nulo.")
    private Status status;

}
