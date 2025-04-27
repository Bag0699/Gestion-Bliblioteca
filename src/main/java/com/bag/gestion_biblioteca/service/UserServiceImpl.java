package com.bag.gestion_biblioteca.service;

import com.bag.gestion_biblioteca.exception.UserNotFoundException;
import com.bag.gestion_biblioteca.mapper.UserMapper;
import com.bag.gestion_biblioteca.model.dto.CreateUserRequest;
import com.bag.gestion_biblioteca.model.dto.UserResponse;
import com.bag.gestion_biblioteca.model.entity.User;
import com.bag.gestion_biblioteca.repository.UserRepository;
import com.bag.gestion_biblioteca.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse save(CreateUserRequest request) {
        User user = userMapper.toUser(request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::toUserResponse)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserResponse update(Long id, CreateUserRequest request) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(request.getName());
                    user.setEmail(request.getEmail());
                    user.setPassword(request.getPassword());
                    user.setRole(Role.USER);
                    return userRepository.save(user);
                })
                .map(userMapper::toUserResponse)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(userRepository.findById(id).isEmpty()) {
            throw new UserNotFoundException();
        }
        userRepository.deleteById(id);
    }
}
