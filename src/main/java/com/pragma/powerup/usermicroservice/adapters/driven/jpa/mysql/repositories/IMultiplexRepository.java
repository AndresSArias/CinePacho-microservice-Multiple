package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMultiplexRepository extends JpaRepository<MultiplexEntity,Long> {

    Optional<MultiplexEntity> findByName(String name);
    Optional<MultiplexEntity> findById(int idMultiplex);


}