package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "movie_theater")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MovieTheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long theaterId;

    @Column(nullable = false)
    private Long movieId;

    @Column(nullable = false)
    private LocalDate day;

    @Column(nullable = false)
    private LocalTime schedule;

    @Column(nullable = false)
    private String chairGeneral;

    @Column(nullable = false)
    private String chairPreferencial;
}