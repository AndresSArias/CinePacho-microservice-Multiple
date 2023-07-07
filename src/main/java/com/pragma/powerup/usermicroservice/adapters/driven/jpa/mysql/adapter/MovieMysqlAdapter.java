package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IMovieEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMovieRepository;
import com.pragma.powerup.usermicroservice.domain.model.Movie;
import com.pragma.powerup.usermicroservice.domain.spi.IMoviePersistencePort;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Transactional
public class MovieMysqlAdapter implements IMoviePersistencePort {
    private final IMovieRepository movieRepository;
    private final IMovieEntityMapper movieEntityMapper;


    @Override
    public List<Movie> getAllMovies() {
        return movieEntityMapper.toListModel(movieRepository.findAll());
    }
}