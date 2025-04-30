package com.bag.gestion_biblioteca.controller;

import com.bag.gestion_biblioteca.model.dto.CreateHistoryRequest;
import com.bag.gestion_biblioteca.model.dto.HistoryResponse;
import com.bag.gestion_biblioteca.service.HistoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/histories")
public class HistoryController {

    private final HistoryService historyService;

    @PostMapping
    public ResponseEntity<HistoryResponse> save(@Valid
                                                @RequestBody
                                                CreateHistoryRequest request) {

        HistoryResponse history = historyService.save(request);
        return ResponseEntity.created(URI.create("/api/histories/" + history.getId()))
                .body(history);
    }
    @GetMapping
    public List<HistoryResponse> findAll() {
        return historyService.findAll();
    }

    @GetMapping("/{id}")
    public HistoryResponse findById(@PathVariable Long id) {
        return historyService.findById(id);
    }

    @PutMapping("/{id}")
    public HistoryResponse update(@PathVariable Long id,
                                   @Valid
                                   @RequestBody CreateHistoryRequest request) {

        return historyService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        historyService.deleteById(id);
    }
}
