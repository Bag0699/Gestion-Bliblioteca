package com.bag.gestion_biblioteca.repository;

import com.bag.gestion_biblioteca.model.entity.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenaltyRepository extends JpaRepository<Penalty, Long> {
}
