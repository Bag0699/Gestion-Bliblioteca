package com.bag.gestion_biblioteca.model.entity;

import com.bag.gestion_biblioteca.util.Reason;
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

    @Enumerated(EnumType.STRING)
    private Reason reason;

    @Column(name = "suspension_date")
    private LocalDate suspensionDate;

    @Column(name = "suspension_end_date")
    private LocalDate suspensionEndDate;

    private Boolean paid;
}
