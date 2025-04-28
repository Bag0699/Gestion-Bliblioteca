package com.bag.gestion_biblioteca.repository;

import com.bag.gestion_biblioteca.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Long> {
}
