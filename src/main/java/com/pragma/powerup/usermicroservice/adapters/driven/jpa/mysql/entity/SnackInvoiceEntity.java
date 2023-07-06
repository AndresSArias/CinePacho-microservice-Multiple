package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "snack_invoice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SnackInvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_snack", nullable = false)
    private SnackEntity idSnack;

    @ManyToOne
    @JoinColumn(name = "id_invoice", nullable = false)
    private InvoiceEntity idInvoice;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private int value;

    @Column(nullable = false, length = 50)
    private String state;
}