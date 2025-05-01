package com.bag.gestion_biblioteca.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CreateReservationRequest {

    @NotNull(message = "El id del usuario no puede ser nulo.")
    private Long userId;

    @NotNull(message = "El id del libro no puede ser nulo.")
    private Long bookId;

    @NotEmpty(message = "El campo fecha de retorno no puede ser vacío o nulo.")
    private LocalDate returnDate;

    @NotEmpty(message = "El camp fecha de recojo no puede ser vacío o nulo.")
    private LocalDate pickupDate;

    @NotNull(message = "El id del estado de la reserva no puede ser nulo.")
    private Long reservationStatusId;
}
