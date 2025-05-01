package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.util.Status;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateReservationStatusRequest {

    @NotEmpty(message = "El campo estado no puede ser vacío o nulo.")
    private Status status;
}
