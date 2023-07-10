package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.*;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.*;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.*;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.InvoiceCompleteRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.InvoiceSnackRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.ObjectCreateResponseDto;
import com.pragma.powerup.usermicroservice.domain.model.ShowInvoice;
import com.pragma.powerup.usermicroservice.domain.spi.IInvoicePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static com.pragma.powerup.usermicroservice.configuration.Constants.STATE_COMPLETE;
import static com.pragma.powerup.usermicroservice.configuration.Constants.STATE_PROGRESS;

@RequiredArgsConstructor
@Transactional
public class InvoiceMySqlAdapter implements IInvoicePersistencePort {

    private final IInvoiceRepository invoiceRepository;
    private final IMovieRepository movieRepository;
    private final ITheaterRepository theaterRepository;
    private final IMovieTheaterRepository movieTheaterRepository;
    private final IShowInvoiceRepository showInvoiceRepository;
    private final ISnackRepository snackRepository;
    private final ISnackInvoiceRepository snackInvoiceRepository;
    @Override
    public ObjectCreateResponseDto saveCompleteInvoice(InvoiceCompleteRequestDto invoiceCompleteRequestDto) {
        //CreateInvoice
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        InvoiceEntity invoiceEntity = new InvoiceEntity();
        invoiceEntity.setIdClient(invoiceCompleteRequestDto.getNumberDocument());
        invoiceEntity.setRatingMovie(0.00);
        invoiceEntity.setDate(LocalDate.now());
        invoiceEntity.setState(STATE_PROGRESS);


        //Create InvoiceShow
        Optional<MovieEntity> movie = movieRepository.findById(Long.parseLong(invoiceCompleteRequestDto.getIdMovie()));
        if (!movie.isPresent()){
            throw new NoMovieFoundException();
        }
        Optional<TheaterEntity> theaterEntity = theaterRepository.findById(Long.parseLong(invoiceCompleteRequestDto.getIdTheater()));
        if (!theaterEntity.isPresent()){
            throw new NoTheatreFoundException();
        }

        List<MovieTheaterEntity> shows = movieTheaterRepository.findByMovieAndTheater(movie.get().getId(),theaterEntity.get().getId());
        if (shows.isEmpty()){
            throw new NoShowFoundException();
        }

        MovieTheaterEntity selectShow = seleccionarShow(shows, invoiceCompleteRequestDto.getSchedule());
        int valueGeneral = 0;
        int valuePreferential = 0;

        if(!invoiceCompleteRequestDto.getChairGeneral().equals("0")){
            String[] selectChair = invoiceCompleteRequestDto.getChairGeneral().split(",");
            selectShow.setChairGeneral(updateChair(selectChair,selectShow.getChairGeneral()));
            valueGeneral = selectChair.length * 11000;
        }

        if(!invoiceCompleteRequestDto.getChaiPreferential().equals("0")){
            String[] selectChair = invoiceCompleteRequestDto.getChaiPreferential().split(",");
            selectShow.setChairPreferential(updateChair(selectChair,selectShow.getChairPreferential()));
            valuePreferential = selectChair.length*15000;
        }

        for(InvoiceSnackRequestDto snack : invoiceCompleteRequestDto.getSnaks()){
            Optional<SnackEntity> snackEntity = snackRepository.findById(Long.parseLong(snack.getIdSnack()));
            if(!snackEntity.isPresent()){
                throw new NoDataFoundException();
            }

        }

        MovieTheaterEntity savedShow = movieTheaterRepository.save(selectShow);
        InvoiceEntity savedInvoice = invoiceRepository.save(invoiceEntity);

        ShowInvoiceEntity showInvoiceEntity = new ShowInvoiceEntity();
        showInvoiceEntity.setIdShow(savedShow);
        showInvoiceEntity.setIdInvoice(savedInvoice);
        showInvoiceEntity.setQuantityChairGeneral(invoiceCompleteRequestDto.getChairGeneral());
        showInvoiceEntity.setQuantityChairPreferential(invoiceCompleteRequestDto.getChaiPreferential());
        showInvoiceEntity.setValue(valueGeneral+valuePreferential);
        showInvoiceEntity.setState(STATE_COMPLETE);

        ShowInvoiceEntity savedShowInvoice = showInvoiceRepository.save(showInvoiceEntity);
        int valueTotalSnack = 0;
        //Creación de snacks
        for(InvoiceSnackRequestDto snack : invoiceCompleteRequestDto.getSnaks()){

            Optional<SnackEntity> snackEntity = snackRepository.findById(Long.parseLong(snack.getIdSnack()));
            SnackInvoiceEntity snackInvoiceEntity = new SnackInvoiceEntity();
            snackInvoiceEntity.setIdSnack(snackEntity.get());
            snackInvoiceEntity.setIdInvoice(savedInvoice);
            snackInvoiceEntity.setQuantity(Integer.parseInt(snack.getQuantitySnack()));
            snackInvoiceEntity.setValue(snackInvoiceEntity.getQuantity()*snackEntity.get().getPrice());
            valueTotalSnack = valueTotalSnack + snackInvoiceEntity.getValue();
            snackInvoiceEntity.setState(STATE_COMPLETE);

            snackInvoiceRepository.save(snackInvoiceEntity);

        }

        savedInvoice.setNetValue(valueGeneral+valuePreferential+valueTotalSnack);
        savedShowInvoice.setState(STATE_COMPLETE);

        InvoiceEntity updateInvoice = invoiceRepository.save(savedInvoice);

        ObjectCreateResponseDto objectCreateResponseDto = new ObjectCreateResponseDto(
                updateInvoice.getId()+"",
                "Factura creada éxitosamente"
        );

        return objectCreateResponseDto;
    }

    private String updateChair(String[] selectChair, String selectShow) {

        String[] chairs = selectShow.split(",");

        for (int i = 0; i< selectChair.length;i++){
            if(chairs[Integer.parseInt(selectChair[i])-1].equals("1")){
                throw new SelectChairReservedException();
            }else if(chairs[Integer.parseInt(selectChair[i])].equals("0")){
                chairs[Integer.parseInt(selectChair[i])-1] = "1";
            }
        }


        return String.join(",", chairs);
    }

    private MovieTheaterEntity seleccionarShow(List<MovieTheaterEntity> shows, String schedule) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        for(MovieTheaterEntity show : shows){
            if(show.getSchedule().format(formato).equals(schedule)){
                return show;
            }
        }
        throw new NoShowExistException();
    }
}
