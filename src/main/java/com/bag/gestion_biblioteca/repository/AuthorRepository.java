package com.bag.gestion_biblioteca.repository;

import com.bag.gestion_biblioteca.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
