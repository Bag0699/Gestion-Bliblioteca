package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.model.dto.CreateUserRequest;
import com.bag.gestion_biblioteca.model.dto.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse save(CreateUserRequest request);
    List<UserResponse> findAll();
    UserResponse findById(Long id);
    UserResponse update(Long id, CreateUserRequest request);
    void deleteById(Long id);
}
