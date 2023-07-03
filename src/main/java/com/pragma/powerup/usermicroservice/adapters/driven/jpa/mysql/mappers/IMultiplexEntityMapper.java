package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IMultiplexEntityMapper {
    MultiplexEntity toEntity(Multiplex multiplex);

    Multiplex toModel(MultiplexEntity entity);
}
