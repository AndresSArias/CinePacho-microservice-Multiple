package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.MultiplexEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.ShowInvoiceEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IMultiplexRepository;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IShowInvoiceRepository;
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
    @Override
    public List<StatisticSaleResponseDto> getStatisticSales() {

        List<MultiplexEntity> multiplexEntityList = multiplexRepository.findAll();
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
}
