package com.pragma.powerup.usermicroservice.configuration;

import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserClient;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    //private final ICategoryRepository categoryRepository;

    //private final ICategoryEntityMapper categoryEntityMapper;

    private  final IUserClient userClient;

/*
    @Bean
    public ICategoryPersistencePort categoryPersistencePort () {
        return new CategoryMysqlAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort () {
        return new CategoryUseCase(categoryPersistencePort());
    }
*/


}
