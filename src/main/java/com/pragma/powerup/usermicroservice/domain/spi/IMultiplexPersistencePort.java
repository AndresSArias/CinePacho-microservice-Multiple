package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MultiplexPointsResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.Movie;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMultiplexPersistencePort {
    Multiplex saveMultiplex (Multiplex multiplex);
    List<Multiplex> getAllMultiplex ();


    Multiplex getMultiplexById(Long idMultiplex);

    Multiplex updatePoints(Long idMultiplex, MultiplexPointsResponseDto multiplexRequestDto);

    void createTheatres(Multiplex multiplex);
}
