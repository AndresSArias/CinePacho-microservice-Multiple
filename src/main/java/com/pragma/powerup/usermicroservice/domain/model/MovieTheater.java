package com.pragma.powerup.usermicroservice.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieTheater {
    private Long id;
    private Long idTheater;
    private Long idMovie;
    private LocalDate day;
    private LocalTime schedule;
    private String chairGeneral;
    private String chairPreferencial;

    public MovieTheater(Long id, Long idTheater, Long idMovie, LocalDate day, LocalTime schedule, String chairGeneral, String chairPreferencial) {
        this.id = id;
        this.idTheater = idTheater;
        this.idMovie = idMovie;
        this.day = day;
        this.schedule = schedule;
        this.chairGeneral = chairGeneral;
        this.chairPreferencial = chairPreferencial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTheater() {
        return idTheater;
    }

    public void setIdTheater(Long idTheater) {
        this.idTheater = idTheater;
    }

    public Long getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Long idMovie) {
        this.idMovie = idMovie;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalTime schedule) {
        this.schedule = schedule;
    }

    public String getChairGeneral() {
        return chairGeneral;
    }

    public void setChairGeneral(String chairGeneral) {
        this.chairGeneral = chairGeneral;
    }

    public String getChairPreferencial() {
        return chairPreferencial;
    }

    public void setChairPreferencial(String chairPreferencial) {
        this.chairPreferencial = chairPreferencial;
    }
}
