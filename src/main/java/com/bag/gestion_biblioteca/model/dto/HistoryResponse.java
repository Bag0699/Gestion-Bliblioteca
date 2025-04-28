package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.model.entity.Book;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HistoryResponse {

    private Long id;
    private UserResponse user;
    private Book book;
    private String activity;
    private String date;
    private String details;

}
