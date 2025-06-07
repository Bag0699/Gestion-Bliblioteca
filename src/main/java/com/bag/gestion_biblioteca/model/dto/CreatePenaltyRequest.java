package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.util.Reason;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class CreatePenaltyRequest {

    @NotNull(message = "El id del usuario no puede ser nulo.")
    private Long userId;

    @NotNull(message = "El campo monto no puede ser nulo.")
    @PositiveOrZero(message = "El monto debe ser mayor o igual a cero.")
    private BigDecimal amount;

    @NotNull(message = "El campo razón no puede ser nulo.")
    private Reason reason;

    @NotNull(message = "El campo fecha de suspensión no puede ser nulo.")
    private LocalDate suspensionEndDate;

    private Boolean paid;
}
