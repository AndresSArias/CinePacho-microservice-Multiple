package com.pragma.powerup.usermicroservice.domain.model;

public class ShowInvoice {
    private Long id;
    private Long showId;
    private Long invoiceId;
    private String quantityChairGeneral;
    private String quantityChairPreferential;
    private int value;
    private int state;

    public ShowInvoice(Long id, Long showId, Long invoiceId, String quantityChairGeneral, String quantityChairPreferential, int value, int state) {
        this.id = id;
        this.showId = showId;
        this.invoiceId = invoiceId;
        this.quantityChairGeneral = quantityChairGeneral;
        this.quantityChairPreferential = quantityChairPreferential;
        this.value = value;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getQuantityChairGeneral() {
        return quantityChairGeneral;
    }

    public void setQuantityChairGeneral(String quantityChairGeneral) {
        this.quantityChairGeneral = quantityChairGeneral;
    }

    public String getQuantityChairPreferential() {
        return quantityChairPreferential;
    }

    public void setQuantityChairPreferential(String quantityChairPreferential) {
        this.quantityChairPreferential = quantityChairPreferential;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}