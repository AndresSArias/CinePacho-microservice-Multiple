package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "snake_invoice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SnakeInvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_snack", nullable = false)
    private SnackEntity idSnack;

    @ManyToOne
    @JoinColumn(name = "id_invoice", nullable = false)
    private InvoiceEntity idInvoice;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer value;

    @Column(nullable = false)
    private Integer state;
}