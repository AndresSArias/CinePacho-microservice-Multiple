package com.pragma.powerup.usermicroservice.domain.model;

public class Theater {
    private Long id;
    private Multiplex idMultiplex;
    private int idSala;


    public Theater(Long id, Multiplex idMultiplex, int idSala) {
        this.id = id;
        this.idMultiplex = idMultiplex;
        this.idSala = idSala;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Multiplex getIdMultiplex() {
        return idMultiplex;
    }

    public void setIdMultiplex(Multiplex idMultiplex) {
        this.idMultiplex = idMultiplex;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

}
