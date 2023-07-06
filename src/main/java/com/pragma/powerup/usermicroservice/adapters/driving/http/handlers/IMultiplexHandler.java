package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.MultiplexRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.NewMultiplexResponseDto;

public interface IMultiplexHandler {

    NewMultiplexResponseDto saveMultiplex (MultiplexRequestDto multiplexRequestDto);

}
