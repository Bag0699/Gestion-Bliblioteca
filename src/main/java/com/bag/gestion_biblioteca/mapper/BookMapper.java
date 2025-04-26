package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.BookResponse;
import com.bag.gestion_biblioteca.model.dto.CreateBookRequest;
import com.bag.gestion_biblioteca.model.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, AuthorMapper.class})
public interface BookMapper {

    BookResponse toBookResponse(Book book);

    Book toBook(CreateBookRequest request);
}
