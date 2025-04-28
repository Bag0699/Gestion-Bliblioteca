package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.model.entity.Book;
import com.bag.gestion_biblioteca.util.Type;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReportResponse {

    private Long id;
    private UserResponse user;
    private Book book;
    private Type type;
    private String description;
    private String reportDate;
    private String restockDate;
    private Boolean resolved;

}
