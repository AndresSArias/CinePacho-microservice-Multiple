package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieTheaterEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.TheaterEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.*;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMovieRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMovieTheaterRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMultiplexRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.ITheaterRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.ScheduleRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ScheduleCreateResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowAliveResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ShowScheduleResponseDto;
import com.pragma.powerup.usermicroservice.domain.api.IShowServicePort;
import com.pragma.powerup.usermicroservice.domain.spi.IShowPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @Override
    public ScheduleCreateResponseDto saveSchedule(ScheduleRequestDto scheduleRequestDto) {
        Optional<MovieEntity> movie = movieRepository.findByTitle(scheduleRequestDto.getMovieName());
        if (!movie.isPresent()){
            throw new NoMovieFoundException();
        }
        Optional<TheaterEntity> theaterEntity = theaterRepository.findById(Long.parseLong(scheduleRequestDto.getIdTheater()));
        if (!theaterEntity.isPresent()){
            throw new NoTheatreFoundException();
        }

        MovieTheaterEntity newShow = new MovieTheaterEntity();

        newShow.setTheaterId(theaterEntity.get());
        newShow.setMovieId(movie.get());
        newShow.setDay(LocalDate.parse(scheduleRequestDto.getDay(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        newShow.setSchedule(LocalTime.parse(scheduleRequestDto.getSchedule(), DateTimeFormatter.ofPattern("HH:mm:ss")));
        newShow.setChairGeneral("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0");
        newShow.setChairPreferential("0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0");

        List<MovieTheaterEntity> oldShows = movieTheaterRepository.findAllByTheaterId(theaterEntity.get());
        MovieTheaterEntity savedShow;
        if (oldShows.isEmpty()){
            savedShow = movieTheaterRepository.save(newShow);
        }else{
            for(MovieTheaterEntity oldShow : oldShows){
                if (newShow.getDay().equals(oldShow.getDay())&& newShow.getSchedule().equals(oldShow.getSchedule())){
                    throw new NoCreateShowException();
                }
            }
            savedShow = movieTheaterRepository.save(newShow);
        }

        ScheduleCreateResponseDto showCreated = new ScheduleCreateResponseDto(savedShow.getId()+"","Se creó la función correctamente");
        return showCreated;
    }
}
