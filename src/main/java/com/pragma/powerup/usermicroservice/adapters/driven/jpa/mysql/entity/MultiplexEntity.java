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
<<<<<<< HEAD
=======

>>>>>>> 6a8a9cb5054dbd14e43c657a4224baf6ba390c51
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

<<<<<<< HEAD
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer numSala;

    @Column(nullable = false)
    private Integer pointTicket;

    @Column(nullable = false)
    private Integer pointSnack;
}
=======
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private int numSala;

    @Column(nullable = false)
    private int pointTicket;

    @Column(nullable = false)
    private int pointSnack;

}
>>>>>>> 6a8a9cb5054dbd14e43c657a4224baf6ba390c51
