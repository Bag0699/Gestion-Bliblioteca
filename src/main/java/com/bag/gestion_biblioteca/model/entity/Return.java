package com.bag.gestion_biblioteca.model.entity;

import com.bag.gestion_biblioteca.util.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "`returns`")  // Usando comillas para escapar la palabra reservada
public class Return {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_status")
    private Status bookStatus;


}