package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.ShowInvoiceEntity;
import com.pragma.powerup.usermicroservice.domain.model.ShowInvoice;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface  IShowInvoiceMapper {
    @Mapping(target = "movieTheaterEntity.id", source = "movieTheater.id")
    @Mapping(target = "invoicesEntity.id", source = "invoices.id")
    ShowInvoice entityToModel(ShowInvoiceEntity entity);

    @Mapping(target = "movieTheater.id", source = "movieTheaterEntity.id")
    @Mapping(target = "invoices.id", source = "invoicesEntity.id")
    ShowInvoiceEntity modelToEntity(ShowInvoice model);
}
