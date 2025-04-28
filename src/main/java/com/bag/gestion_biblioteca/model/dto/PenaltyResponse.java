package com.bag.gestion_biblioteca.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class PenaltyResponse {

    private Long id;
    private UserResponse user;
    private BigDecimal amount;
    private String reason;
    private String reportDate;
    private String suspensionDate;
    private Boolean paid;

}
