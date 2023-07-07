package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.MovieMysqlAdapter;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IMovieEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IMultiplexEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMovieRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMultiplexRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserClient;
import com.pragma.powerup.usermicroservice.domain.api.IMovieServicePort;
import com.pragma.powerup.usermicroservice.domain.api.usecase.MovieUseCase;
import com.pragma.powerup.usermicroservice.domain.spi.IMoviePersistencePort;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.MultiplexMySqlAdapter;
import com.pragma.powerup.usermicroservice.domain.api.IMultiplexServicePort;
import com.pragma.powerup.usermicroservice.domain.api.usecase.MultiplexUseCase;
import com.pragma.powerup.usermicroservice.domain.spi.IMultiplexPersistencePort;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {


    private final IMovieRepository movieRepository;
    private final IMovieEntityMapper movieEntityMapper;

    private final IMultiplexRepository multiplexRepository;

    private final IMultiplexEntityMapper multiplexEntityMapper;


    private  final IUserClient userClient;


    @Bean
    public IMultiplexPersistencePort multiplexPersistencePort () {
        return new MultiplexMySqlAdapter(multiplexRepository, multiplexEntityMapper);
    }

    @Bean
    public IMultiplexServicePort multiplexServicePort() {
        return new MultiplexUseCase(multiplexPersistencePort());
    }

    @Bean
    public IMoviePersistencePort moviePersistencePort(){
            return new MovieMysqlAdapter(movieRepository,movieEntityMapper);
        }
    @Bean
    public IMovieServicePort movieServicePort(){
        return new MovieUseCase(moviePersistencePort());
    }


}
