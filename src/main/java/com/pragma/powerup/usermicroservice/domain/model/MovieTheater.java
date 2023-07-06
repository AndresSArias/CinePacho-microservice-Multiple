package com.pragma.powerup.usermicroservice.domain.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovieTheater {
    private Long id;
    private Theater idTheater;
    private Movie idMovie;
    private LocalDate day;
    private LocalTime schedule;
    private String chairGeneral;
    private String chairPreferential;

    public MovieTheater(Long id, Long Theater, Movie idMovie, LocalDate day, LocalTime schedule, String chairGeneral, String chairPreferential) {
        this.id = id;
        this.idTheater = idTheater;
        this.idMovie = idMovie;
        this.day = day;
        this.schedule = schedule;
        this.chairGeneral = chairGeneral;
        this.chairPreferential = chairPreferential;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Theater getIdTheater() {
        return idTheater;
    }

    public void setIdTheater(Theater idTheater) {
        this.idTheater = idTheater;
    }

    public Movie getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Movie idMovie) {
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

    public String getChairPreferential() {
        return chairPreferential;
    }

    public void setChairPreferential(String chairPreferential) {
        this.chairPreferential = chairPreferential;
    }
}
