package com.pragma.powerup.usermicroservice.domain.model;

public class Theater {
    private Long id;
    private Long idMultiplex;
    private Integer idSala;


    public Theater(Long id, Long idMultiplex, Integer idSala) {
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

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

}
