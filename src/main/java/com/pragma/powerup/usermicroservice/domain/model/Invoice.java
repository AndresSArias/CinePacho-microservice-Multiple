package com.pragma.powerup.usermicroservice.domain.model;

import java.time.LocalDate;

public class Invoice {
    private Long id;
    private Long idClient;
    private Double ratingMovie;
    private LocalDate date;
    private int netValue;
    private String state;

    public Invoice(Long id, Long idClient, Double ratingMovie, LocalDate date, int netValue, String state) {
        this.id = id;
        this.idClient = idClient;
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

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
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

    public int getNetValue() {
        return netValue;
    }

    public void setNetValue(int netValue) {
        this.netValue = netValue;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
