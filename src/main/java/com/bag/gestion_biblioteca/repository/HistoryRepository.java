package com.bag.gestion_biblioteca.repository;

import com.bag.gestion_biblioteca.model.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}
