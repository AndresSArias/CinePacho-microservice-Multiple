package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MovieResponseDto;
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
    private final IMovieResponseMapper movieResponseMapper;
    @Override
    public List<MovieResponseDto> getAllMovies() {
        return movieResponseMapper.toListDto(movieServicePort.getAllMovies());
    }
}
