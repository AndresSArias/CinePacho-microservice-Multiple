package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "multiplexs")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MultiplexEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int numSala;

    @Column(nullable = false)
    private int pointTicket;

    @Column(nullable = false)
    private int pointSnack;
}