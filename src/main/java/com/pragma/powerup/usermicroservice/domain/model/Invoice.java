package com.pragma.powerup.usermicroservice.domain.model;

import java.time.LocalDate;

public class Invoice {
    private Long id;
    private Long theaterId;
    private String clientId;
    private Double ratingMovie;
    private LocalDate date;
    private Integer netValue;
    private String state;

    public Invoice(Long id, Long theaterId, String clientId, Double ratingMovie, LocalDate date, Integer netValue, String state) {
        this.id = id;
        this.theaterId = theaterId;
        this.clientId = clientId;
        this.ratingMovie = ratingMovie;
        this.date = date;
        this.netValue = netValue;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Double getRatingMovie() {
        return ratingMovie;
    }

    public void setRatingMovie(Double ratingMovie) {
        this.ratingMovie = ratingMovie;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getNetValue() {
        return netValue;
    }

    public void setNetValue(Integer netValue) {
        this.netValue = netValue;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
