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

    @ManyToOne
    @JoinColumn(name = "id_theater", nullable = false)
    private TheaterEntity theater;

    @ManyToOne
    @JoinColumn(name = "id_movie", nullable = false)
    private MovieEntity movie;

    @Column(nullable = false)
    private LocalDate day;

    @Column(nullable = false)
    private LocalTime schedule;

}