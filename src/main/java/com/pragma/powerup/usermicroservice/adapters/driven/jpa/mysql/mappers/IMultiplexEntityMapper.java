package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
<<<<<<< HEAD

public interface IMultiplexEntityMapper {
    MultiplexEntity toEntity(Multiplex multiplex);

    Multiplex toModel(MultiplexEntity entity);
=======
public interface IMultiplexEntityMapper {
    Multiplex toMultiplexModel (MultiplexEntity multiplexEntity);

    MultiplexEntity toMultiplexEntity (Multiplex multiplex);
>>>>>>> 6a8a9cb5054dbd14e43c657a4224baf6ba390c51
}
