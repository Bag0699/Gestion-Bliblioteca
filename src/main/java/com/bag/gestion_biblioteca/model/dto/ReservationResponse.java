package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.model.entity.Book;
import com.bag.gestion_biblioteca.model.entity.ReservationStatus;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class ReservationResponse {

    private Long id;
    private UserResponse user;
    private String reservationDate;
    private String returnDate;
    private String pickupDate;
    private ReservationStatus reservationStatus;
}
