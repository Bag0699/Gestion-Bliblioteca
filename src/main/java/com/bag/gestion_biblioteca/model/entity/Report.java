package com.bag.gestion_biblioteca.model.entity;

import com.bag.gestion_biblioteca.util.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String description;

    @Column(name = "report_date")
    private LocalDate reportDate;

    @Column(name = "restock_date")
    private LocalDate restockDate;

    private Boolean resolved;
}
