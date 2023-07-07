package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.MovieRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MovieResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.NewMovieResponseDto;

import java.util.List;

public interface IMovieHandler {
NewMovieResponseDto saveMovie(MovieRequestDto movieRequestDto);
    List<MovieResponseDto> getAllMovies ();
}
