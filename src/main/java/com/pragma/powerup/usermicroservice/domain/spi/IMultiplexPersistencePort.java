package com.pragma.powerup.usermicroservice.domain.spi;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMultiplexPersistencePort {
    Multiplex saveMultiplex (Multiplex multiplex);
    Page<Multiplex> getAllMultiplexes(Pageable pageable);
}
