package com.bag.gestion_biblioteca.repository;

import com.bag.gestion_biblioteca.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
