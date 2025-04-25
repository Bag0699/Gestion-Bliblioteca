package com.bag.gestion_biblioteca.repository;

import com.bag.gestion_biblioteca.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
