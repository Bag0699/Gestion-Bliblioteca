package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.exception.ReservationNotFoundException;
import com.bag.gestion_biblioteca.exception.ReturnNotFoundException;
import com.bag.gestion_biblioteca.mapper.ReturnMapper;
import com.bag.gestion_biblioteca.model.dto.CreateReturnRequest;
import com.bag.gestion_biblioteca.model.dto.ReturnResponse;
import com.bag.gestion_biblioteca.model.entity.Return;
import com.bag.gestion_biblioteca.repository.ReservationRepository;
import com.bag.gestion_biblioteca.repository.ReturnRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReturnServiceImpl implements ReturnService{

    private final ReturnRepository returnRepository;
    private final ReturnMapper returnMapper;
    private final ReservationRepository reservationRepository;

    @Override
    public ReturnResponse save(CreateReturnRequest request) {
        return reservationRepository.findById(request.getIdReservation())
                .map(reservation -> {
                    Return aReturn = new Return();
                    aReturn.setReservation(reservation);
                    aReturn.setDate(request.getDate());
                    aReturn.setBookStatus(request.getStatus());
                    return returnRepository.save(aReturn);
                })
                .map(returnMapper::toReturnResponse)
                .orElseThrow(ReservationNotFoundException::new);

    }

    @Override
    public List<ReturnResponse> findAll() {
        return returnRepository.findAll()
                .stream()
                .map(returnMapper::toReturnResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ReturnResponse findById(Long id) {
        return returnRepository.findById(id)
                .map(returnMapper::toReturnResponse)
                .orElseThrow(ReturnNotFoundException::new);
    }

    @Override
    public ReturnResponse update(Long id, CreateReturnRequest request) {
        return returnRepository.findById(id)
                .map(aReturn -> reservationRepository
                        .findById(request.getIdReservation())
                        .map(reservation -> {
                            aReturn.setReservation(reservation);
                            aReturn.setDate(request.getDate());
                            aReturn.setBookStatus(request.getStatus());
                            return returnRepository.save(aReturn);
                        })
                        .orElseThrow(ReservationNotFoundException::new))
                .map(returnMapper::toReturnResponse)
                .orElseThrow(ReservationNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(returnRepository.findById(id).isEmpty()) {
            throw new ReturnNotFoundException();
        }
        returnRepository.deleteById(id);
    }
}