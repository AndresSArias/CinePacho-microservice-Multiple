package com.pragma.powerup.usermicroservice.domain.model;

public class Theater {
    private Long id;
    private Long idMultiplex;
    private Integer idSala;
    private String sillasGeneral;
    private String sillasPreferencial;

    public Theater(Long id, Long idMultiplex, Integer idSala, String sillasGeneral, String sillasPreferencial) {
        this.id = id;
        this.idMultiplex = idMultiplex;
        this.idSala = idSala;
        this.sillasGeneral = sillasGeneral;
        this.sillasPreferencial = sillasPreferencial;
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

    public String getSillasGeneral() {
        return sillasGeneral;
    }

    public void setSillasGeneral(String sillasGeneral) {
        this.sillasGeneral = sillasGeneral;
    }

    public String getSillasPreferencial() {
        return sillasPreferencial;
    }

    public void setSillasPreferencial(String sillasPreferencial) {
        this.sillasPreferencial = sillasPreferencial;
    }
}
