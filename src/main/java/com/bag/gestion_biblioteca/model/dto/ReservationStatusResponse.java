package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.util.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReservationStatusResponse {

    private Long id;
    private Status status;
}
