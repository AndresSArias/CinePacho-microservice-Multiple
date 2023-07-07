package com.pragma.powerup.usermicroservice.adapters.driving.http.factory.mapper.response;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MovieResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.MultiplexResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.NewMultiplexResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.Movie;
import com.pragma.powerup.usermicroservice.domain.model.Multiplex;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMultiplexResponseMapper {
    @Mapping(target = "Created_id", source = "id")
    NewMultiplexResponseDto toDto (Multiplex multiplex);
    MultiplexResponseDto toMultiplexResponse (Multiplex multiplex);

    List<MultiplexResponseDto> toListDto (List<Multiplex> multiplex);



}
