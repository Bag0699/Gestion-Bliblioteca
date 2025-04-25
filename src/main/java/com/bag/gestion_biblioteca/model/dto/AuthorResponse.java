package com.bag.gestion_biblioteca.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthorResponse {

    private Long id;
    private Long name;
}
