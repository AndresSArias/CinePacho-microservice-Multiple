package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.InvoiceEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MovieEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.ShowInvoiceEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoMovieFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.NoMultiplexFoundException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IInvoiceRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMovieRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMultiplexRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IShowInvoiceRepository;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.StatisticRaitingResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.StatisticSaleResponseDto;
import com.pragma.powerup.usermicroservice.domain.spi.IStatisticPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Transactional
public class StatisticMySqlAdapter implements IStatisticPersistencePort {

    private final IShowInvoiceRepository showInvoiceRepository;
    private final IMultiplexRepository multiplexRepository;

    private final IInvoiceRepository invoiceRepository;
    private final IMovieRepository movieRepository;
    @Override
    public List<StatisticSaleResponseDto> getStatisticSales() {

        List<MultiplexEntity> multiplexEntityList = multiplexRepository.findAll();
        if (multiplexEntityList.isEmpty()){
            throw new NoMultiplexFoundException();
        }
        List<StatisticSaleResponseDto> statisticSaleList = new ArrayList<>();

        for (MultiplexEntity multiplex : multiplexEntityList){
            int totalSales = 0;

            List<ShowInvoiceEntity> showInvoiceEntityList = showInvoiceRepository.getShowInvoiceByIdMultiplex(multiplex.getId());

            for (ShowInvoiceEntity showInvoice: showInvoiceEntityList){
                if (!showInvoice.getQuantityChairGeneral().equals("0")){
                    totalSales = totalSales + showInvoice.getQuantityChairGeneral().split(",").length;
                }
                if (!showInvoice.getQuantityChairPreferential().equals("0")){
                    totalSales = totalSales + showInvoice.getQuantityChairPreferential().split(",").length;
                }
            }

            statisticSaleList.add(new StatisticSaleResponseDto(multiplex.getName(), totalSales+""));
        }

        return statisticSaleList;
    }

    @Override
    public List<StatisticRaitingResponseDto> getStatisticRainting() {

        List<MovieEntity> movieEntityList = movieRepository.findAll();
        if(movieEntityList.isEmpty()){
            throw new NoMovieFoundException();
        }

        List<StatisticRaitingResponseDto> statisticRaitingList = new ArrayList<>();

        for (MovieEntity movie: movieEntityList){
            int elementos = 0;
            Double suma = 0.00;

            List<InvoiceEntity> invoiceEntityList = invoiceRepository.getInvoiceByIdMovie(movie.getId());

            for(InvoiceEntity invoice: invoiceEntityList){
                if (invoice.getRatingMovie() != 0.00){
                    suma = suma + invoice.getRatingMovie();
                    elementos++;
                }
            }
            if (elementos == 0){
                statisticRaitingList.add(new StatisticRaitingResponseDto(movie.getTitle(),"None"));
            }else{
                double avg = suma/elementos;
                statisticRaitingList.add(new StatisticRaitingResponseDto(movie.getTitle(),avg+""));
            }

        }

        return statisticRaitingList;
    }
}
