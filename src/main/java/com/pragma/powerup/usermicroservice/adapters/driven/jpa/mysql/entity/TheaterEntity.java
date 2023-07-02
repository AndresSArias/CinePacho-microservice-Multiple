package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "theaters")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(nullable = false)
=======
>>>>>>> 6a8a9cb5054dbd14e43c657a4224baf6ba390c51
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_multiplex", nullable = false)
<<<<<<< HEAD
    private MultiplexEntity multiplex;

    @Column(nullable = false)
    private Integer salaId;

    @Column(nullable = false)
    private String sillasGeneral;

    @Column(nullable = false)
    private String sillasPreferencial;

}
=======
    private MultiplexEntity multiplexEntity;

}
>>>>>>> 6a8a9cb5054dbd14e43c657a4224baf6ba390c51
