package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieTheaterEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.TheaterEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoDataFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoMovieFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoMultiplexFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoShowFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMovieRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMovieTheaterRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMultiplexRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.ITheaterRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowAliveResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowScheduleResponseDto;
import com.pragma.powerup.usermicroservice.domain.api.IShowServicePort;
import com.pragma.powerup.usermicroservice.domain.spi.IShowPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.format.DateTimeFormatter;
import java.util.*;

@RequiredArgsConstructor
@Transactional
public class ShowMySqlAdapter implements IShowPersistencePort {

    private final IMovieTheaterRepository movieTheaterRepository;
    private final IMovieRepository movieRepository;
    private final IMultiplexRepository multiplexRepository;
    private final ITheaterRepository theaterRepository;

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

    @Override
    public List<ShowAliveResponseDto> getShowsByMovieAndMultiplex(String idMovie, String idMultiplex) {
        Optional<MultiplexEntity> multiplexTarget = multiplexRepository.findById(Long.parseLong(idMultiplex));
        if (!multiplexTarget.isPresent()){
            throw new NoMultiplexFoundException();
        }
        Optional<MovieEntity> movieTarget = movieRepository.findById(Long.parseLong(idMovie));
        if(!movieTarget.isPresent()){
            throw new NoMovieFoundException();
        }

        List<MovieTheaterEntity> showAllowedList = movieTheaterRepository.findByMovieAndMultiplex(movieTarget.get().getId(),multiplexTarget.get().getId());

        if (showAllowedList.isEmpty()){
            throw new NoShowFoundException();
        }
        /*
        List<ShowAliveResponseDto> showAlive= new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        showAlive.add(new ShowAliveResponseDto(
                showAllowedList.get(0).getTheaterId().getId()+"",
                showAllowedList.get(0).getSchedule().format(formato)
        ));

        for (int i = 1; i < showAllowedList.size(); i++){
            for(int j = i; j <showAllowedList.size();j++){
                if(showAlive.get(i-1).getIdTheater().equals(showAllowedList.get(j).getTheaterId().getId()+"")){
                    showAlive.get(i-1).setHours(showAlive.get(i-1).getHours()+","+showAllowedList.get(j).getSchedule().format(formato));
                }
            }
            showAlive.add(new ShowAliveResponseDto(
                    showAllowedList.get(i).getTheaterId().getId()+"",
                    showAllowedList.get(i).getSchedule().format(formato)
            ));
        }
*/
        List<ShowAliveResponseDto> showAlive = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        Map<String, StringBuilder> hoursMap = new HashMap<>();

        for (MovieTheaterEntity show : showAllowedList) {
            String idTheater = show.getTheaterId().getId() + "";
            String schedule = show.getSchedule().format(formato);

            if (hoursMap.containsKey(idTheater)) {
                hoursMap.get(idTheater).append(",").append(schedule);
            } else {
                StringBuilder hoursBuilder = new StringBuilder(schedule);
                hoursMap.put(idTheater, hoursBuilder);
            }
        }

        for (Map.Entry<String, StringBuilder> entry : hoursMap.entrySet()) {
            showAlive.add(new ShowAliveResponseDto(entry.getKey(), entry.getValue().toString()));
        }

        return showAlive;
    }
}
