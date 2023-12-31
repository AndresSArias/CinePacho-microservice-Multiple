package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieTheaterEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface IMovieTheaterRepository extends JpaRepository<MovieTheaterEntity, Long> {
    List<MovieTheaterEntity> findAllByTheaterId (TheaterEntity theaterEntity);

    @Query("SELECT mt " +
            "FROM MovieTheaterEntity mt " +
            "INNER JOIN MovieEntity m ON mt.movieId = m.id " +
            "INNER JOIN TheaterEntity t ON mt.theaterId = t.id " +
            "INNER JOIN MultiplexEntity mp ON t.multiplex = mp.id " +
            "WHERE m.id = :movieId " +
            "AND mp.id = :multiplexId " +
            "ORDER BY mt.schedule")
    List<MovieTheaterEntity> findByMovieAndMultiplex(@Param("movieId") Long movieId, @Param("multiplexId") Long multiplexId);


    @Query("SELECT mt " +
            "FROM MovieTheaterEntity mt " +
            "INNER JOIN MovieEntity m ON mt.movieId = m.id " +
            "INNER JOIN TheaterEntity t ON mt.theaterId = t.id " +
            "WHERE m.id = :movieId " +
            "AND t.id = :theaterId ")
    List<MovieTheaterEntity> findByMovieAndTheater(@Param("movieId") Long movieId, @Param("theaterId") Long theaterId);

    @Query("SELECT mt " +
            "FROM MovieTheaterEntity mt " +
            "INNER JOIN MovieEntity m ON mt.movieId = m.id " +
            "INNER JOIN TheaterEntity t ON mt.theaterId = t.id " +
            "INNER JOIN MultiplexEntity mp ON t.multiplex = mp.id " +
            "WHERE m.id = :movieId "+
            "AND mp.id = :multiplexId "+
            "AND mt.day = :day " +
            "AND mt.schedule = :schedule ")
    Optional<MovieTheaterEntity> findByIdMovieAndIdMultiplexAndDayAndSchedule (@Param("movieId") Long movieId, @Param("multiplexId") Long multiplexId, @Param("day") LocalDate day, @Param("schedule")LocalTime schedule);




}
