package com.pragma.powerup.usermicroservice.domain.api.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.domain.api.IMultiplexServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.LenghtPageException;
import com.pragma.powerup.usermicroservice.domain.exceptions.LenghtSizeException;
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
        return multiplexPersistencePort.saveMultiplex(multiplex);
    }

    @Override
    public Page<Multiplex> getAllMultiplexes(int page, int size) {
        if (size < 1){
            throw  new LenghtSizeException();
        }
        if (page < 0){
            throw  new LenghtPageException();
        }

        final Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "nombre"));
        return multiplexPersistencePort.getAllMultiplexes(pageable);
    }
}
