package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.InvoiceEntity;
import com.pragma.powerup.usermicroservice.domain.model.Invoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IInvoiceEntityMapper {
    @Mapping(target = "theaterEntity.id", source = "theater.id")
    InvoiceEntity toEntity(Invoice invoice);
    @Mapping(target = "theater.id", source = "theaterEntity.id")
    Invoice toModel(InvoiceEntity entity);
}
