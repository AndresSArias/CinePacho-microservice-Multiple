package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "show_invoice")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShowInvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_show",nullable = false)
    private MovieTheaterEntity idShow;

    @ManyToOne
    @JoinColumn(name = "id_invoice",nullable = false)
    private InvoiceEntity idInvoice;

    @Column(nullable = false)
    private String quantityChairGeneral;

    @Column(nullable = false)
    private String quantityChairPreferential;

    @Column(nullable = false)
    private int value;

    @Column(nullable = false,length = 50)
    private String state;
}
