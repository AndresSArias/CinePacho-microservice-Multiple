package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MultiplexPointsResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.Movie;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IMultiplexServicePort {

    Multiplex saveMultiplex(Multiplex multiplex);

    List<Multiplex> getAllMultiplex();


    Multiplex getMultiplexById(Long idMultiplex);

    Multiplex setMultiplexById(Long idMultiplex, MultiplexPointsResponseDto multiplexRequestDto);
}
