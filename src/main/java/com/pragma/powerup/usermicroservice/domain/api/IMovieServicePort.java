package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.Movie;

import java.util.List;

public interface IMovieServicePort {
Movie saveMovie(Movie movie);
    List<Movie> getAllMovies();

}
