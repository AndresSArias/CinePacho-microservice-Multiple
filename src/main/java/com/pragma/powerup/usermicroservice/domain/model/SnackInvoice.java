package com.pragma.powerup.usermicroservice.domain.model;

public class SnackInvoice {
    private Long id;
    private Long snackId;
    private Long invoiceId;
    private int quantity;
    private int value;

    public SnackInvoice(Long id, Long snackId, Long invoiceId, int quantity, int value) {
        this.id = id;
        this.snackId = snackId;
        this.invoiceId = invoiceId;
        this.quantity = quantity;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSnackId() {
        return snackId;
    }

    public void setSnackId(Long snackId) {
        this.snackId = snackId;
    }

    public Long getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Long invoiceId) {
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
}
