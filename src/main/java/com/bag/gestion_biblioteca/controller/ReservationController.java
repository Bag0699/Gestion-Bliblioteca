package com.bag.gestion_biblioteca.controller;

import com.bag.gestion_biblioteca.model.dto.BookResponse;
import com.bag.gestion_biblioteca.model.dto.CreateReservationRequest;
import com.bag.gestion_biblioteca.model.dto.ReservationResponse;
import com.bag.gestion_biblioteca.model.dto.UserResponse;
import com.bag.gestion_biblioteca.service.ReservationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponse> save(@Valid
                                                    @RequestBody
                                                    CreateReservationRequest request) {

        ReservationResponse reservation = reservationService.save(request);
        return ResponseEntity.created(URI.create("/api/reservations/" + reservation.getId()))
                .body(reservation);
    }

    @GetMapping
    public List<ReservationResponse> findAll() {
        return reservationService.findAll();
    }
}
