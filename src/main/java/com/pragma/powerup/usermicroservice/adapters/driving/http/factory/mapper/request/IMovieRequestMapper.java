package com.pragma.powerup.usermicroservice.adapters.driving.http.factory.mapper.request;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.MovieRequestDto;
import com.pragma.powerup.usermicroservice.domain.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IMovieRequestMapper {

    Movie toModel (MovieRequestDto movieRequestDto);

}
