package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.model.entity.Reservation;
import com.bag.gestion_biblioteca.util.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReturnResponse {

    private Long id;
    private Reservation reservation;
    private String date;
    private Status bookStatus;

}
