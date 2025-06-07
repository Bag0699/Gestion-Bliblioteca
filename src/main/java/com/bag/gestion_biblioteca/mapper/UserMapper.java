package com.bag.gestion_biblioteca.mapper;

import com.bag.gestion_biblioteca.model.dto.CreateUserRequest;
import com.bag.gestion_biblioteca.model.dto.UserResponse;
import com.bag.gestion_biblioteca.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse toUserResponse(User user);

    User toUser(CreateUserRequest request);
}
