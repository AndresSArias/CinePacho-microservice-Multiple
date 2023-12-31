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
    private Long id;

    @Column(nullable = false, length = 20)
    private String idClient;

    @Column(nullable = true)
    private Double ratingMovie;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = true)
    private int netValue;

    @Column(nullable = false,length = 50)
    private String state;
}
