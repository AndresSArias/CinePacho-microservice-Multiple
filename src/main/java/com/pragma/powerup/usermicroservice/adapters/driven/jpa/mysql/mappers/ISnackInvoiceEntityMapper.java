package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.SnackInvoiceEntity;
import com.pragma.powerup.usermicroservice.domain.model.SnackInvoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface ISnackInvoiceEntityMapper {
    @Mapping(target = "idSnack.id", source = "snackId.id")
    @Mapping(target = "idInvoice.id", source = "invoiceId.id")
    SnackInvoiceEntity toEntity(SnackInvoice snackInvoice);
    @Mapping(target = "snackId.id", source = "idSnack.id")
    @Mapping(target = "invoiceId.id", source = "idInvoice.id")
    SnackInvoice toModel(SnackInvoiceEntity entity);
}