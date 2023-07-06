package com.pragma.powerup.usermicroservice.domain.model;

public class SnackInvoice {
    private Long id;
    private Snack snackId;
    private Invoice invoiceId;
    private int quantity;

    private int value;
    private String state;

    public SnackInvoice(Long id, Snack snackId, Invoice invoiceId, int quantity, int value, String state) {
        this.id = id;
        this.snackId = snackId;
        this.invoiceId = invoiceId;
        this.quantity = quantity;
        this.value = value;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Snack getSnackId() {
        return snackId;
    }

    public void setSnackId(Snack snackId) {
        this.snackId = snackId;
    }

    public Invoice getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Invoice invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
