package com.pragma.powerup.usermicroservice.domain.api;

import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import org.springframework.data.domain.Page;

public interface IMultiplexServicePort {

    Multiplex saveMultiplex(Multiplex multiplex);

    Page<Multiplex> getAllMultiplexes(int page, int size);

}
