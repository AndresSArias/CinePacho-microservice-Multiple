package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITheaterRepository extends JpaRepository<TheaterEntity, Long> {
}