package com.pragma.powerup.usermicroservice.domain.api.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MultiplexPointsResponseDto;
import com.pragma.powerup.usermicroservice.domain.api.IMultiplexServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.LenghtPageException;
import com.pragma.powerup.usermicroservice.domain.exceptions.LenghtSizeException;
import com.pragma.powerup.usermicroservice.domain.model.Movie;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import com.pragma.powerup.usermicroservice.domain.spi.IMultiplexPersistencePort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MultiplexUseCase implements IMultiplexServicePort {

    private final IMultiplexPersistencePort multiplexPersistencePort;

    public MultiplexUseCase(IMultiplexPersistencePort multiplexPersistencePort) {
        this.multiplexPersistencePort = multiplexPersistencePort;
    }

    @Override
    public Multiplex saveMultiplex(Multiplex multiplex) {
        Multiplex multiplex1 = multiplexPersistencePort.saveMultiplex(multiplex);
        multiplexPersistencePort.createTheatres(multiplex1);
        return multiplex1;
    }

    public List<Multiplex> getAllMultiplex() {
        return multiplexPersistencePort.getAllMultiplex();
    }

    @Override
    public Multiplex getMultiplexById(Long idMultiplex) {
        return multiplexPersistencePort.getMultiplexById(idMultiplex);
    }

    public Multiplex setMultiplexById(Long idMultiplex,MultiplexPointsResponseDto multiplexRequestDto) {
        return multiplexPersistencePort.updatePoints(idMultiplex,multiplexRequestDto);
    }

}
