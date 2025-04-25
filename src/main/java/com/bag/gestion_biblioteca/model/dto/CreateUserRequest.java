package com.bag.gestion_biblioteca.model.dto;

import com.bag.gestion_biblioteca.util.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequest {

    @NotEmpty(message = "El campo nombre no puede ser vacío o nulo.")
    private String name;

    @Email(message = "El formato del correo electrónico no es valido.")
    private String email;

    @NotEmpty(message = "El campo contraseña no puede ser vacío o nulo.")
    private String password;

    private Role role;
}
