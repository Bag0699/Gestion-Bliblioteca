package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.model.entity.Book;
import com.bag.gestion_biblioteca.model.entity.Reservation;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReservationDetailResponse {

    private Long id;
    private Reservation reservation;
    private Book book;
}
