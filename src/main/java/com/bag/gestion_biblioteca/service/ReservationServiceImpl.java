package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.exception.BookNotFoundException;
import com.bag.gestion_biblioteca.exception.ReservationStatusNotFoundException;
import com.bag.gestion_biblioteca.exception.UserNotFoundException;
import com.bag.gestion_biblioteca.mapper.BookMapper;
import com.bag.gestion_biblioteca.mapper.ReservationMapper;
import com.bag.gestion_biblioteca.mapper.ReservationStatusMapper;
import com.bag.gestion_biblioteca.mapper.UserMapper;
import com.bag.gestion_biblioteca.model.dto.BookResponse;
import com.bag.gestion_biblioteca.model.dto.CreateReservationRequest;
import com.bag.gestion_biblioteca.model.dto.ReservationResponse;
import com.bag.gestion_biblioteca.model.dto.UserResponse;
import com.bag.gestion_biblioteca.model.entity.Reservation;
import com.bag.gestion_biblioteca.repository.BookRepository;
import com.bag.gestion_biblioteca.repository.ReservationRepository;
import com.bag.gestion_biblioteca.repository.ReservationStatusRepository;
import com.bag.gestion_biblioteca.repository.UserRepository;
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
    private final ReservationMapper reservationMapper;
    private final BookMapper bookMapper;
    private final UserMapper userMapper;
    private final ReservationStatusMapper resMapper;

    @Override
    public ReservationResponse save(CreateReservationRequest request) {
        return userRepository.findById(request.getUserId())
                .map(user -> bookRepository.findById(request.getBookId())
                        .map(book -> res.findById(request.getReservationStatusId())
                                .map(reservationStatus -> {
                                    Reservation reservation = new Reservation();
                                    reservation.setUser(user);
                                    reservation.setBook(book);
                                    reservation.setReservationDate(LocalDate.now());
                                    reservation.setReturnDate(request.getReturnDate());
                                    reservation.setReservationStatus(reservationStatus);
                                    return reservationRepository.save(reservation);
                                })
                                .orElseThrow(ReservationStatusNotFoundException::new))
                        .map(reservationMapper::toReservationResponse)
                        .orElseThrow(BookNotFoundException::new))
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<BookResponse> findAllByUserId(Long userId) {
        return userRepository.findById(userId)
                .map(user -> reservationRepository.findAllByUser_Id(userId))
                .map(reservations -> reservations.stream()
                        .map(Reservation::getBook)
                        .map(bookMapper::toBookResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<UserResponse> findAllByBookId(Long bookId) {
        return bookRepository.findById(bookId)
                .map(book -> reservationRepository.findAllByBook_Id(bookId))
                .map(reservations -> reservations.stream()
                        .map(Reservation::getUser)
                        .map(userMapper::toUserResponse)
                        .collect(Collectors.toList()))
                .orElseThrow(BookNotFoundException::new);
    }

    @Override
    public List<ReservationResponse> findAll() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toReservationResponse)
                .collect(Collectors.toList());
    }
}
