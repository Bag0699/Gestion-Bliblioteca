package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.model.entity.Book;
import com.bag.gestion_biblioteca.model.entity.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReservationResponse {

    private Long id;
    private User user;
    private Book book;
    private String reservationDate;
    private String returnDate;
}
