package com.pragma.powerup.usermicroservice.domain.api.usecase;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.domain.api.IMultiplexServicePort;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import com.pragma.powerup.usermicroservice.domain.spi.IMultiplexPersistencePort;

public class MultiplexUseCase implements IMultiplexServicePort {

    private final IMultiplexPersistencePort multiplexPersistencePort;

    public MultiplexUseCase(IMultiplexPersistencePort multiplexPersistencePort) {
        this.multiplexPersistencePort = multiplexPersistencePort;
    }

    @Override
    public Multiplex saveMultiplex(Multiplex multiplex) {
        return multiplexPersistencePort.saveMultiplex(multiplex);
    }
}
