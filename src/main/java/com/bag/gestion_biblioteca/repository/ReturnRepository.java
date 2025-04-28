package com.bag.gestion_biblioteca.repository;

import com.bag.gestion_biblioteca.model.entity.Return;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReturnRepository extends JpaRepository<Return, Long> {
}
