package com.pragma.powerup.usermicroservice.adapters.driving.http.factory.mapper.response;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.SnackResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.Snack;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ISnackResponseMapper {
    List<SnackResponseDto> toListDto (List<Snack> snacks);

}
