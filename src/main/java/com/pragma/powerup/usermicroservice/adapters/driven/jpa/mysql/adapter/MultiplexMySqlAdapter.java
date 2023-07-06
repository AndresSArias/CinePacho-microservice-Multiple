package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.MultiplexAlredyExistException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IMultiplexEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMultiplexRepository;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import com.pragma.powerup.usermicroservice.domain.spi.IMultiplexPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class MultiplexMySqlAdapter implements IMultiplexPersistencePort {

    private final IMultiplexRepository multiplexRepository;
    private final IMultiplexEntityMapper multiplexEntityMapper;

    @Override
    public Multiplex saveMultiplex(Multiplex multiplex) {

        if(multiplexRepository.findByName(multiplex.getName()).isPresent()){
            throw new MultiplexAlredyExistException();
        }
        return multiplexEntityMapper.toModel(multiplexRepository.save(multiplexEntityMapper.toEntity(multiplex)));
    }
}
