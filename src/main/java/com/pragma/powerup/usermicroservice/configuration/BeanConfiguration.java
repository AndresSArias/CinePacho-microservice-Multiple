package com.pragma.powerup.usermicroservice.configuration;

<<<<<<< HEAD
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.MovieMysqlAdapter;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IMovieEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IMultiplexEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMovieRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMultiplexRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserClient;
import com.pragma.powerup.usermicroservice.domain.api.IMovieServicePort;
import com.pragma.powerup.usermicroservice.domain.api.usecase.MovieUseCase;
import com.pragma.powerup.usermicroservice.domain.spi.IMoviePersistencePort;
=======
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.MultiplexMySqlAdapter;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IMultiplexEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMultiplexRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserClient;
import com.pragma.powerup.usermicroservice.domain.api.IMultiplexServicePort;
import com.pragma.powerup.usermicroservice.domain.api.usecase.MultiplexUseCase;
import com.pragma.powerup.usermicroservice.domain.spi.IMultiplexPersistencePort;
>>>>>>> 8dd3d35f996391ac6a1f285026f56c5ab92a81d5
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {


<<<<<<< HEAD
    //private final ICategoryEntityMapper categoryEntityMapper;
    private final IMovieRepository movieRepository;
    private final IMovieEntityMapper movieEntityMapper;
=======
    private final IMultiplexRepository multiplexRepository;

    private final IMultiplexEntityMapper multiplexEntityMapper;
>>>>>>> 8dd3d35f996391ac6a1f285026f56c5ab92a81d5

    private  final IUserClient userClient;


    @Bean
    public IMultiplexPersistencePort multiplexPersistencePort () {
        return new MultiplexMySqlAdapter(multiplexRepository, multiplexEntityMapper);
    }

    @Bean
    public IMultiplexServicePort multiplexServicePort() {
        return new MultiplexUseCase(multiplexPersistencePort());
    }
<<<<<<< HEAD
*/
@Bean
public IMoviePersistencePort moviePersistencePort(){
        return new MovieMysqlAdapter(movieRepository,movieEntityMapper);
    }
@Bean
    public IMovieServicePort movieServicePort(){
    return new MovieUseCase(moviePersistencePort());
    }
=======


>>>>>>> 8dd3d35f996391ac6a1f285026f56c5ab92a81d5

}
