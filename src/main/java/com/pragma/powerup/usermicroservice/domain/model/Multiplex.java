package com.pragma.powerup.usermicroservice.domain.model;

public class Multiplex {
    private Long id;
    private String name;
    private Integer numSala;
    private Integer pointTicket;
    private Integer pointSnack;

    public Multiplex(Long id, String name, Integer numSala, Integer pointTicket, Integer pointSnack) {
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