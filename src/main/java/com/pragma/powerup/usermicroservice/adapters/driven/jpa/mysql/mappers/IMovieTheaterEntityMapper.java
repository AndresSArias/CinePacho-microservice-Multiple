package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieTheaterEntity;
import com.pragma.powerup.usermicroservice.domain.model.MovieTheater;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IMovieTheaterEntityMapper {
    MovieTheaterEntity toEntity(MovieTheater movieTheater);

    MovieTheater toModel(MovieTheaterEntity entity);
}
