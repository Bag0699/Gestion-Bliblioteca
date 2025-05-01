package com.bag.gestion_biblioteca.model.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateReservationDetailRequest {

    @NotNull(message = "El id de reservación no puede ser nulo.")
    private Long reservationId;

    @NotNull(message = "El id de libro no puede ser nulo.")
    private Long bookId;
}
