package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Time;
import java.time.LocalTime;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class    MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 80)
    private String title;

    @Column(nullable = false)
    private LocalTime duration;

    @Column(nullable = false)
    private int yearAllowed;

    @Column(nullable = false, length = 500)
    private String synopsis;

    @Column(nullable = false)
    private String url;
}