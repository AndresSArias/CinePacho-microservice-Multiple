package com.pragma.powerup.usermicroservice.domain.model;

import java.sql.Time;

public class Movie {
    private Long id;
    private String title;
    private Time duration;
    private Integer yearAllowed;
    private String synopsis;
    private String url;

    public Movie(Long id, String title, Time duration, Integer yearAllowed, String synopsis, String url) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.yearAllowed = yearAllowed;
        this.synopsis = synopsis;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public Integer getYearAllowed() {
        return yearAllowed;
    }

    public void setYearAllowed(Integer yearAllowed) {
        this.yearAllowed = yearAllowed;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
