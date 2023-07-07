package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.Movie;

import java.util.List;

public interface IMovieServicePort {
    List<Movie> getAllMovies();

}
