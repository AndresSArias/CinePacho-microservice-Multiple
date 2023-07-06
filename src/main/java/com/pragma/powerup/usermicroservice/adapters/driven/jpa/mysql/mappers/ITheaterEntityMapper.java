package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.TheaterEntity;
import com.pragma.powerup.usermicroservice.domain.model.Theater;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ITheaterEntityMapper {
    @Mapping(target = "multiplex.id", source = "idMultiplex.id")
    TheaterEntity toEntity(Theater theater);
    @Mapping(target = "idMultiplex.id", source = "multiplex.id")
    Theater toModel(TheaterEntity entity);
}