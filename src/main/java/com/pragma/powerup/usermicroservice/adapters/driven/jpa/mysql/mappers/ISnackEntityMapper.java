package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.SnackEntity;
import com.pragma.powerup.usermicroservice.domain.model.Snack;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ISnackEntityMapper {

    SnackEntity toEntity(Snack snack);

    Snack toModel(SnackEntity entity);
}
