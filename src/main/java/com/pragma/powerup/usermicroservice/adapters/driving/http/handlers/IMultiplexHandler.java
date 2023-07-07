package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.MultiplexRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MovieResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MultiplexResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.NewMultiplexResponseDto;

import java.util.List;

public interface IMultiplexHandler {

    NewMultiplexResponseDto saveMultiplex (MultiplexRequestDto multiplexRequestDto);
    List<MultiplexResponseDto> getAllMultiplex ();
}
