package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieTheaterEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMovieRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMovieTheaterRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowScheduleResponseDto;
import com.pragma.powerup.usermicroservice.domain.api.IShowServicePort;
import com.pragma.powerup.usermicroservice.domain.spi.IShowPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Transactional
public class ShowMySqlAdapter implements IShowPersistencePort {

    private final IMovieTheaterRepository movieTheaterRepository;
    private final IMovieRepository movieRepository;

    @Override
    public List<ShowScheduleResponseDto> getAllShowSchedule() {
        List<MovieTheaterEntity> shows = movieTheaterRepository.findAll();
        if(shows.isEmpty()){
            throw new NoDataFoundException();
        }
        List<ShowScheduleResponseDto> showScheduleResponseDtos = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        for(int i = 0; i < shows.size(); i++){
            showScheduleResponseDtos.add(new ShowScheduleResponseDto(
                    shows.get(i).getId()+"",
                    movieRepository.findById(shows.get(i).getMovieId().getId()).get().getTitle(),
                    shows.get(i).getTheaterId().getId()+"",
                    shows.get(i).getDay().format(formatter),
                    shows.get(i).getSchedule().format(formato)


            ));
        }
        return showScheduleResponseDtos;
    }
}
