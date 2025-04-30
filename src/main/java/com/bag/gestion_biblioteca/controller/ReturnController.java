package com.bag.gestion_biblioteca.controller;

import com.bag.gestion_biblioteca.model.dto.CreateReturnRequest;
import com.bag.gestion_biblioteca.model.dto.ReturnResponse;
import com.bag.gestion_biblioteca.service.ReturnService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/returns")
public class ReturnController {

    private final ReturnService returnService;

    @PostMapping
    public ResponseEntity<ReturnResponse> save(@Valid
                                               @RequestBody
                                               CreateReturnRequest request) {
        ReturnResponse returnResponse = returnService.save(request);
        return ResponseEntity.created(URI.create("/api/returns/" + returnResponse.getId()))
                .body(returnResponse);
    }

    @GetMapping
    public List<ReturnResponse> findAll() {
        return returnService.findAll();
    }

    @GetMapping("/{id}")
    public ReturnResponse findById(@PathVariable Long id) {
        return returnService.findById(id);
    }

    @PutMapping("/{id}")
    public ReturnResponse update(@PathVariable Long id,
                                 @Valid
                                 @RequestBody CreateReturnRequest request) {
        return returnService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        returnService.deleteById(id);
    }
}
