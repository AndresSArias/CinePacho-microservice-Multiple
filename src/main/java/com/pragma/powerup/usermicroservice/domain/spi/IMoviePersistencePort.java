package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieEntity;
import com.pragma.powerup.usermicroservice.domain.model.Movie;

import java.util.List;

public interface IMoviePersistencePort {
    List<Movie> getAllMovies ();


}
