package com.pragma.powerup.usermicroservice.domain.model;

public class ShowInvoice {
    private Long id;
    private MovieTheater showId;
    private Invoice invoiceId;
    private String quantityChairGeneral;
    private String quantityChairPreferential;
    private int value;
    private String state;

    public ShowInvoice(Long id, MovieTheater showId, Invoice invoiceId, String quantityChairGeneral, String quantityChairPreferential, int value, String state) {
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

    public MovieTheater getShowId() {
        return showId;
    }

    public void setShowId(MovieTheater showId) {
        this.showId = showId;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}