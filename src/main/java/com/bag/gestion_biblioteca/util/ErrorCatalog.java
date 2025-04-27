package com.bag.gestion_biblioteca.util;

import lombok.Getter;

@Getter
public enum ErrorCatalog {

    AUTHOR_NOT_FOUND("ERR_ATR_001", "Autor no encontrado."),
    INVALID_AUTHOR("ERR_ATR_002", "Parámetros invalido de autor."),

    BOOK_NOT_FOUND("ERR_BK_001", "Libro no encontrado."),
    INVALID_BOOK("ERR_BK_002", "Parámetros invalido de estudiante."),

    CATEGORY_NOT_FOUND("ERR_CAT_001", "Categoría no encontrada."),
    INVALID_CATEGORY("ERR_CAT_002", "Parámetros inválidos de categoría."),

    RESERVATION_NOT_FOUND("ERR_RES_001", "Reserva no encontrada."),
    INVALID_RESERVATION("ERR_RES_002", "Parámetros inválidos de reserva."),

    USER_NOT_FOUND("ERR_USR_001", "Usuario no encontrado."),
    INVALID_USER("ERR_USR_002", "Parámetros inválidos de usuario."),

    GENERIC_ERROR("ERR_GEN_001", "Un error inesperado ocurrió.");

    private final String code;
    private final String message;

    ErrorCatalog(String name, String message) {
        this.code = name;
        this.message = message;
    }
}
