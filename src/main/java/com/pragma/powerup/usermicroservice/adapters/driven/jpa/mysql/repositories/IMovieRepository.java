package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMovieRepository extends JpaRepository<MovieEntity, Long> {
    Optional<MovieEntity> findByTitle(String title);
}