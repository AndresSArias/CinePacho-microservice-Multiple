package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface IMovieRepository extends JpaRepository<MovieEntity, Long> {
}