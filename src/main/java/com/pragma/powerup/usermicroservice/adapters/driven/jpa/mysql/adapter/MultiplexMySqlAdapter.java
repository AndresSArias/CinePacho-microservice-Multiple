package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.TheaterEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.MultiplexAlredyExistException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoMultiplexFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoTheatresEnoughException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IMultiplexEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMultiplexRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.ITheaterRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MultiplexPointsResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import com.pragma.powerup.usermicroservice.domain.spi.IMultiplexPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
public class MultiplexMySqlAdapter implements IMultiplexPersistencePort {

    private final IMultiplexRepository multiplexRepository;
    private final IMultiplexEntityMapper multiplexEntityMapper;
    private final ITheaterRepository theaterRepository;

    @Override
    public Multiplex saveMultiplex(Multiplex multiplex) {

        if(multiplexRepository.findByName(multiplex.getName()).isPresent()){
            throw new MultiplexAlredyExistException();
        }
        if (multiplex.getNumSala()<5 || multiplex.getNumSala()>15 ){
            throw new NoTheatresEnoughException();
        }
        return multiplexEntityMapper.toModel(multiplexRepository.save(multiplexEntityMapper.toEntity(multiplex)));
    }

    @Override
    public List<Multiplex> getAllMultiplex() {
        return multiplexEntityMapper.toListModel(multiplexRepository.findAll());
    }



    public Multiplex getMultiplexById(Long idMultiplex) {
        Optional<MultiplexEntity> multiplexEntity = multiplexRepository.findById(idMultiplex);

        if (!multiplexEntity.isPresent()){
            throw new NoMultiplexFoundException();
        }
        return multiplexEntityMapper.toModel(multiplexEntity.get());
    }

    @Override
    public Multiplex updatePoints(Long idMultiplex, MultiplexPointsResponseDto multiplexRequestDto) {
        Optional<MultiplexEntity> multiplexEntity = multiplexRepository.findById(idMultiplex);

        if (!multiplexEntity.isPresent()){
            throw new NoMultiplexFoundException();
        }
        MultiplexEntity multiplex = multiplexEntity.get();
        multiplex.setPointSnack(multiplexRequestDto.getPointSnack());
        multiplex.setPointTicket(multiplexRequestDto.getPointTicket());
        return  multiplexEntityMapper.toModel(multiplexRepository.save(multiplex));
    }

    @Override
    public void createTheatres(Multiplex multiplex) {
        MultiplexEntity multiplex1 = multiplexEntityMapper.toEntity(multiplex);
        for(int i=0;i<multiplex1.getNumSala(); i++){
            TheaterEntity theater = new TheaterEntity();
            theater.setMultiplex(multiplex1);
            theater.setIdSala(i+1);
            theaterRepository.save(theater);
        }
    }
}
