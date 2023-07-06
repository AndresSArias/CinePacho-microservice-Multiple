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
    @Mapping(target = "showId.id", source = "idShow.id")
    @Mapping(target = "invoiceId.id", source = "idInvoice.id")
    ShowInvoice entityToModel(ShowInvoiceEntity entity);

    @Mapping(target = "idShow.id", source = "showId.id")
    @Mapping(target = "idInvoice.id", source = "invoiceId.id")
    ShowInvoiceEntity modelToEntity(ShowInvoice model);
}
