package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;

public interface IMultiplexPersistencePort {
    Multiplex saveMultiplex (Multiplex multiplex);
}
