package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.util.Reason;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class CreatePenaltyRequest {

    @NotNull(message = "El id del usuario no puede ser nulo.")
    private Long userId;

    @NotEmpty(message = "El campo monto no puede ser vacío o nulo.")
    private BigDecimal amount;

    @NotEmpty(message = "El campo razón no puede ser vacío o nulo.")
    private Reason reason;

    @NotEmpty(message = "El campo fecha de suspensión no puede ser vacío o nulo.")
    private LocalDate suspensionEndDate;

    private Boolean paid;
}
