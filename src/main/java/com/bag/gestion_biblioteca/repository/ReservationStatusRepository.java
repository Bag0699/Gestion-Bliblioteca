package com.bag.gestion_biblioteca.repository;

import com.bag.gestion_biblioteca.model.entity.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationStatusRepository extends JpaRepository<ReservationStatus, Long> {
}
