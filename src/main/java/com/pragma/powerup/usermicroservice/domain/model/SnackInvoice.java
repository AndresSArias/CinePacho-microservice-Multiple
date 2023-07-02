package com.pragma.powerup.usermicroservice.domain.model;

public class SnackInvoice {
    private Long id;
    private Long snackId;
    private Long invoiceId;
    private Integer quantity;
    private Integer value;

    public SnackInvoice(Long id, Long snackId, Long invoiceId, Integer quantity, Integer value) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
