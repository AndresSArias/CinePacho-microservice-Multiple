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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_theater", nullable = false)
    private TheaterEntity theaterId;

    @ManyToOne
    @JoinColumn(name = "id_movie", nullable = false)
    private MovieEntity movieId;

    @Column(nullable = false)
    private LocalDate day;

    @Column(nullable = false)
    private LocalTime schedule;

    @Column(nullable = false, length = 79)
    private String chairGeneral;

    @Column(nullable = false, length = 39)
    private String chairPreferential;
}