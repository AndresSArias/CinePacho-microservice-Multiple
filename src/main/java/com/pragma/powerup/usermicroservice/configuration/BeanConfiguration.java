package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.*;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IMovieEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IMultiplexEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.ISnackEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.*;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserClient;
import com.pragma.powerup.usermicroservice.domain.api.*;
import com.pragma.powerup.usermicroservice.domain.api.usecase.*;
import com.pragma.powerup.usermicroservice.domain.spi.*;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {


    private final IMovieRepository movieRepository;
    private final IMovieEntityMapper movieEntityMapper;

    private final ISnackRepository snackRepository;
    private final ISnackEntityMapper snackEntityMapper;

    private final IMultiplexRepository multiplexRepository;

    private final IMultiplexEntityMapper multiplexEntityMapper;

    private final ITheaterRepository theaterRepository;

    private final IMovieTheaterRepository showRepository;

    private final IInvoiceRepository invoiceRepository;
    private final  IShowInvoiceRepository showInvoiceRepository;
    private  final  ISnackInvoiceRepository snackInvoiceRepository;

    private  final IUserClient userClient;


    @Bean
    public IMultiplexPersistencePort multiplexPersistencePort () {
        return new MultiplexMySqlAdapter(multiplexRepository, multiplexEntityMapper, theaterRepository);
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
    @Bean
    public ISnackPersistencePort snackPersistencePort(){
        return new SnackMysqlAdapter(snackRepository,snackEntityMapper);
    }
    @Bean
    public ISnackServicePort snackServicePort(){
        return new SnackUseCase(snackPersistencePort());
    }

    @Bean
    public IShowPersistencePort showPersistencePort(){
        return new ShowMySqlAdapter(showRepository,movieRepository,multiplexRepository,theaterRepository);
    }
    @Bean
    public IShowServicePort showServicePort(){
        return new ShowUseCase(showPersistencePort());
    }

    @Bean
    public IInvoicePersistencePort invoicePersistencePort () {
        return new InvoiceMySqlAdapter(invoiceRepository,movieRepository,theaterRepository,showRepository,showInvoiceRepository,snackRepository,snackInvoiceRepository);
    }

    @Bean
    public IInvoiceServicePort invoiceServicePort(){
        return new InvoiceUseCase(invoicePersistencePort());
    }

    @Bean
    public IStatisticPersistencePort statisticPersistencePort () {
        return new StatisticMySqlAdapter(showInvoiceRepository,multiplexRepository,invoiceRepository,movieRepository);
    }

    @Bean IStatisticServicePort statisticServicePort () {
        return  new StatisticUseCase(statisticPersistencePort());
    }

}
