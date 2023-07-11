package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IInvoiceRepository extends JpaRepository<InvoiceEntity, Long> {

    @Query("SELECT i " +
            "FROM InvoiceEntity i " +
            "INNER JOIN ShowInvoiceEntity si ON  si.idInvoice = i.id " +
            "INNER JOIN MovieTheaterEntity mt ON  si.idShow = mt.id " +
            "INNER JOIN MovieEntity m ON mt.movieId = m.id " +
            "WHERE m.id = :movieId " +
            "AND i.state = 'PAGADO' ")
    List<InvoiceEntity> getInvoiceByIdMovie(@Param("movieId") Long movieId);
}
