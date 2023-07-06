package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieTheaterEntity;
import com.pragma.powerup.usermicroservice.domain.model.MovieTheater;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IMovieTheaterEntityMapper {

    @Mapping(target = "theaterId.id", source = "idTheater.id")
    @Mapping(target = "movieId.id", source = "idMovie.id")
    MovieTheaterEntity toEntity(MovieTheater movieTheater);
    @Mapping(target = "idTheater.id", source = "theaterId.id")
    @Mapping(target = "idMovie.id", source = "movieId.id")
    MovieTheater toModel(MovieTheaterEntity entity);
}
