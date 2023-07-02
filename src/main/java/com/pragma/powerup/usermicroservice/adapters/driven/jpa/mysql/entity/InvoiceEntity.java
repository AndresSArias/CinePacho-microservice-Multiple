package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "invoices")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_theaters", nullable = false)
    private TheaterEntity theater;

    @Column(nullable = false)
    private String clientId;

    @Column(nullable = true)
    private Double ratingMovie;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Integer netValue;

    @Column(nullable = false)
    private String state;
}