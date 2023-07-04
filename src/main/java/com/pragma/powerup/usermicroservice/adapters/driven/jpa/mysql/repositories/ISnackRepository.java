package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.SnackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISnackRepository extends JpaRepository<SnackEntity, Long> {
}