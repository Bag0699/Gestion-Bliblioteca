package com.bag.gestion_biblioteca.controller;

import com.bag.gestion_biblioteca.model.dto.CreateUserRequest;
import com.bag.gestion_biblioteca.model.dto.UserResponse;
import com.bag.gestion_biblioteca.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> save(@Valid
                                             @RequestBody
                                             CreateUserRequest request) {

        UserResponse user = userService.save(request);
        return ResponseEntity.created(URI.create("/api/users/" + user.getId()))
                .body(user);
    }

    @GetMapping
    public List<UserResponse> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable Long id){
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id,
                               @Valid
                               @RequestBody CreateUserRequest request) {

        return userService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
