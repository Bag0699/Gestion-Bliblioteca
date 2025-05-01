package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.util.Reason;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class PenaltyResponse {

    private Long id;
    private UserResponse user;
    private BigDecimal amount;
    private Reason reason;
    private String suspensionDate;
    private String suspensionEndDate;
    private Boolean paid;

}
