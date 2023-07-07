package com.pragma.powerup.usermicroservice.domain.api.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IMovieEntityMapper;
import com.pragma.powerup.usermicroservice.domain.api.IMovieServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Movie;
import com.pragma.powerup.usermicroservice.domain.spi.IMoviePersistencePort;

import java.util.List;

public class MovieUseCase implements IMovieServicePort{
    private final IMoviePersistencePort moviePersistencePort;

    public MovieUseCase(IMoviePersistencePort moviePersistencePort) {
        this.moviePersistencePort = moviePersistencePort;
    }

    @Override
    public List<Movie> getAllMovies() {
        return moviePersistencePort.getAllMovies();
    }
}
