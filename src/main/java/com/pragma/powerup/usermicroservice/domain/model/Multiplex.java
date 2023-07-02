package com.pragma.powerup.usermicroservice.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Multiplex {

    private Long id;

    private String name;

    private int numSala;

    private int pointTicket;

    private int pointSnack;

    public Multiplex() {

    }
    public Multiplex(Long id, String name, int numSala, int pointTicket, int pointSnack) {
        this.id = id;
        this.name = name;
        this.numSala = numSala;
        this.pointTicket = pointTicket;
        this.pointSnack = pointSnack;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public int getPointTicket() {
        return pointTicket;
    }

    public void setPointTicket(int pointTicket) {
        this.pointTicket = pointTicket;
    }

    public int getPointSnack() {
        return pointSnack;
    }

    public void setPointSnack(int pointSnack) {
        this.pointSnack = pointSnack;
    }
}
