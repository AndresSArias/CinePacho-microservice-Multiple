package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.MultiplexRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MovieResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MultiplexResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.NewMultiplexResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.factory.mapper.request.IMultiplexRequestMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.factory.mapper.response.IMultiplexResponseMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IMultiplexHandler;
import com.pragma.powerup.usermicroservice.domain.api.IMultiplexServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pragma.powerup.usermicroservice.configuration.Constants.MULTIPLEX_CREATED_MESSAGE;

@Service
@RequiredArgsConstructor
public class MultiplexHandlerImpl implements IMultiplexHandler {

    private final IMultiplexServicePort multiplexServicePort;

    private final IMultiplexRequestMapper multiplexRequestMapper;
    private final IMultiplexResponseMapper multiplexResponseMapper;

    @Override
    public NewMultiplexResponseDto saveMultiplex(MultiplexRequestDto multiplexRequestDto) {

        NewMultiplexResponseDto newMultiplexResponseDto = multiplexResponseMapper.toDto(multiplexServicePort.saveMultiplex(multiplexRequestMapper.toModel(multiplexRequestDto)));
        newMultiplexResponseDto.setMessage(MULTIPLEX_CREATED_MESSAGE);

        return newMultiplexResponseDto;
    }

    public List<MultiplexResponseDto> getAllMultiplex() {
        return multiplexResponseMapper.toListDto(multiplexServicePort.getAllMultiplex());
    }

}
