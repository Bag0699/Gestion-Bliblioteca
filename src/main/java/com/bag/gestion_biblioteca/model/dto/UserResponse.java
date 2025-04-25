package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.util.Role;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Role role;
}
