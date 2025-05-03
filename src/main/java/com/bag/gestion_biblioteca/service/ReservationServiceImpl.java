package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.exception.BookNotFoundException;
import com.bag.gestion_biblioteca.exception.ReservationStatusNotFoundException;
import com.bag.gestion_biblioteca.exception.UserNotFoundException;
import com.bag.gestion_biblioteca.mapper.BookMapper;
import com.bag.gestion_biblioteca.mapper.ReservationMapper;
import com.bag.gestion_biblioteca.mapper.UserMapper;
import com.bag.gestion_biblioteca.model.dto.BookResponse;
import com.bag.gestion_biblioteca.model.dto.CreateReservationRequest;
import com.bag.gestion_biblioteca.model.dto.ReservationResponse;
import com.bag.gestion_biblioteca.model.dto.UserResponse;
import com.bag.gestion_biblioteca.model.entity.Book;
import com.bag.gestion_biblioteca.model.entity.Reservation;
import com.bag.gestion_biblioteca.model.entity.ReservationDetail;
import com.bag.gestion_biblioteca.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final ReservationStatusRepository res;
    private final ReservationDetailRepository reservationDetailRepository;
    private final ReservationMapper reservationMapper;


    @Override
    public ReservationResponse save(CreateReservationRequest request) {
        return userRepository.findById(request.getUserId())
                .map(user -> res.findById(request.getReservationStatusId())
                        .map(reservationStatus -> {
                            // Creando la reservación principal
                            Reservation reservation = new Reservation();
                            reservation.setUser(user);
                            reservation.setReservationDate(LocalDate.now());
                            reservation.setReturnDate(request.getReturnDate());
                            reservation.setPickupDate(request.getPickupDate());
                            reservation.setReservationStatus(reservationStatus);
                            Reservation savedReservation = reservationRepository.save(reservation);
                            // Válida los libros y crea el reservationDetail
                            request.getBookId().forEach(bookId -> {
                                Book book = bookRepository.findById(bookId)
                                        .orElseThrow(BookNotFoundException::new);

                                ReservationDetail detail = new ReservationDetail();
                                detail.setBook(book);
                                detail.setReservation(reservation);
                                reservationDetailRepository.save(detail);
                            });
                            return savedReservation;
                        })
                        .orElseThrow(ReservationStatusNotFoundException::new))
                .map(reservationMapper::toReservationResponse)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<ReservationResponse> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toReservationResponse)
                .collect(Collectors.toList());
    }
}
