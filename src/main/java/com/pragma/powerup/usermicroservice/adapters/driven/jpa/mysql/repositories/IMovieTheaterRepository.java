package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieTheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IMovieTheaterRepository extends JpaRepository<MovieTheaterEntity, Long> {
}
