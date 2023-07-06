package com.pragma.powerup.usermicroservice.domain.model;

public class Theater {
    private Long id;
    private Long idMultiplex;
    private int idSala;


    public Theater(Long id, Long idMultiplex, int idSala) {
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

    public Long getIdMultiplex() {
        return idMultiplex;
    }

    public void setIdMultiplex(Long idMultiplex) {
        this.idMultiplex = idMultiplex;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

}
