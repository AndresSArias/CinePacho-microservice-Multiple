package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.MovieRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MovieResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.NewMovieResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.factory.mapper.request.IMovieRequestMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.factory.mapper.response.IMovieResponseMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IMovieHandler;
import com.pragma.powerup.usermicroservice.domain.api.IMovieServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieHandlerImpl implements IMovieHandler {
    private final IMovieServicePort movieServicePort;
    private final IMovieRequestMapper movieRequestMapper;
    private final IMovieResponseMapper movieResponseMapper;
    @Override
    public NewMovieResponseDto saveMovie (MovieRequestDto movieRequestDto){
        NewMovieResponseDto newMovieResponseDto = movieResponseMapper.toDto(movieServicePort.saveMovie(movieRequestMapper.toModel(movieRequestDto)));

        return newMovieResponseDto;
    }
    @Override
    public List<MovieResponseDto> getAllMovies() {
        return movieResponseMapper.toListDto(movieServicePort.getAllMovies());
    }
}
