package com.bag.gestion_biblioteca.repository;

import com.bag.gestion_biblioteca.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
