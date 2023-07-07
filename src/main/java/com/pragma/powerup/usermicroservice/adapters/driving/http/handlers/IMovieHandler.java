package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MovieResponseDto;

import java.util.List;

public interface IMovieHandler {

    List<MovieResponseDto> getAllMovies ();
}
