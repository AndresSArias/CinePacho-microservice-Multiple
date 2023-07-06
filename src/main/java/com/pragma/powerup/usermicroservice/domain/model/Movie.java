package com.pragma.powerup.usermicroservice.domain.model;

import java.sql.Time;
import java.time.LocalTime;

public class Movie {
    private Long id;
    private String title;
    private LocalTime duration;
    private int yearAllowed;
    private String synopsis;
    private String url;

    public Movie(Long id, String title, LocalTime duration, int yearAllowed, String synopsis, String url) {
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

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public int getYearAllowed() {
        return yearAllowed;
    }

    public void setYearAllowed(int yearAllowed) {
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
