package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.AuthorResponse;
import com.bag.gestion_biblioteca.model.dto.CreateAuthorRequest;
import com.bag.gestion_biblioteca.model.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorResponse toAuthorResponse(Author author);

    Author toAuthor(CreateAuthorRequest request);
}
