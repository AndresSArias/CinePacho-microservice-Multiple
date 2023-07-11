package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.ShowInvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IShowInvoiceRepository extends JpaRepository<ShowInvoiceEntity, Long> {

    @Query("SELECT si " +
            "FROM ShowInvoiceEntity si " +
            "INNER JOIN InvoiceEntity i ON  si.idInvoice = i.id " +
            "INNER JOIN MovieTheaterEntity mt ON  si.idShow = mt.id " +
            "INNER JOIN MovieEntity m ON mt.movieId = m.id " +
            "INNER JOIN TheaterEntity t ON mt.theaterId = t.id " +
            "INNER JOIN MultiplexEntity mp ON t.multiplex = mp.id " +
            "WHERE mp.id = :multiplexId " +
            "AND si.state = 'PAGADO'")
    List<ShowInvoiceEntity> getShowInvoiceByIdMultiplex (@Param("multiplexId") Long multiplexId);

}