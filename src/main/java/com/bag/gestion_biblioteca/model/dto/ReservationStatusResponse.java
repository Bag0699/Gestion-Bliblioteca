package com.bag.gestion_biblioteca.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReservationStatusResponse {

    private Long id;
    private String status;
}
