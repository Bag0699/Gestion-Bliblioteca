package com.bag.gestion_biblioteca.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "penalties")
public class Penalty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private BigDecimal amount;
    private String reason;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "suspension_date")
    private LocalDate suspensionDate;

    private Boolean paid;
}
