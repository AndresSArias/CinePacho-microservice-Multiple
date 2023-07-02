package com.pragma.powerup.usermicroservice.domain.model;

<<<<<<< HEAD
public class Multiplex {
    private Long id;
    private String name;
    private Integer numSala;
    private Integer pointTicket;
    private Integer pointSnack;

    public Multiplex(Long id, String name, Integer numSala, Integer pointTicket, Integer pointSnack) {
=======
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
>>>>>>> 6a8a9cb5054dbd14e43c657a4224baf6ba390c51
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

<<<<<<< HEAD
    public Integer getNumSala() {
        return numSala;
    }

    public void setNumSala(Integer numSala) {
        this.numSala = numSala;
    }

    public Integer getPointTicket() {
        return pointTicket;
    }

    public void setPointTicket(Integer pointTicket) {
        this.pointTicket = pointTicket;
    }

    public Integer getPointSnack() {
        return pointSnack;
    }

    public void setPointSnack(Integer pointSnack) {
        this.pointSnack = pointSnack;
    }
}
=======
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
>>>>>>> 6a8a9cb5054dbd14e43c657a4224baf6ba390c51
