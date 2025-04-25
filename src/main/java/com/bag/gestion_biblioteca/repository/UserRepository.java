package com.bag.gestion_biblioteca.repository;

import com.bag.gestion_biblioteca.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
