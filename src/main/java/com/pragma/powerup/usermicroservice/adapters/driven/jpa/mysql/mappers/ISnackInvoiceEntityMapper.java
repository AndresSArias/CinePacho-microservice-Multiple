package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.SnakeInvoiceEntity;
import com.pragma.powerup.usermicroservice.domain.model.SnackInvoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ISnackInvoiceEntityMapper {
    @Mapping(target = "snackEntity.id", source = "snack.id")
    @Mapping(target = "invoiceEntity.id", source = "invoice.id")
    SnakeInvoiceEntity toEntity(SnackInvoice snackInvoice);
    @Mapping(target = "snack.id", source = "snackEntity.id")
    @Mapping(target = "invoice.id", source = "invoiceEntity.id")
    SnackInvoice toModel(SnakeInvoiceEntity entity);
}